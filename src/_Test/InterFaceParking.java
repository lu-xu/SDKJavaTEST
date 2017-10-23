package _Test;

import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;

import _Test.bean.CarInEntity;
import _Test.bean.CarOutEntity;
import net.sf.json.JSONObject;
import sdk.InterfacePark;
import sdk.UploadUtil;
import sqlite.SqliteJDBC;
import util.FileUtil;

public class InterFaceParking extends InterfacePark {
	private String parkid = MainSDK.PARK_ID;

	@Override
	public void receive(String msg) {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis() + ">>>>>�ص�����: " + msg);
		JSONObject object = JSONObject.fromObject(msg);
		String service_name = object.getString("service_name");
		// MainSDK.textField_4.setText(System.currentTimeMillis()+"");
		String back;
		String errmsg;
		int state = 0;
		boolean querry = false;
		String orderid;
		double derate_money = 0;
		String trade_no;
		CarInEntity entity;
		switch (service_name) {
		case "outpark":
			// {"service_name":"outpark","pay_type":"sweepcode","state":1,"errmsg":"֧���ɹ�","trade_no":"kftweixinprepay20010320170725111512897",
			// "order_id":"A1_2C1500952427"}
			orderid = object.getString("order_id");
			trade_no = object.getString("trade_no");
			entity = null;
			for (int i = 0; i < MainSDK.carInList.size(); i++) {
				if (MainSDK.carInList.get(i).getOrder_id().equals(orderid)) {
					querry = true;
					entity = MainSDK.carInList.get(i);
					break;
				} else {
					querry = false;
				}
			}
			if (querry) {
				CarOutEntity outentity = new CarOutEntity();
				outentity.setPay_type(object.getString("pay_type"));
				outentity.setCar_number(entity.getCar_number());
				outentity.setIn_time(entity.getIn_time());
				outentity.setOut_time(System.currentTimeMillis() / 1000);
				outentity.setCar_type(entity.getCar_type());
				outentity.setC_type(entity.getC_type());
				outentity.setUid(entity.getUid());
				outentity.setOut_uid(entity.getUid());
				outentity.setOrder_id(orderid);
				outentity.setOut_channel_id(entity.getIn_channel_id());
				outentity.setTotal(MainSDK.ed_total.getText());
				outentity.setReduce_amount(MainSDK.textField_3.getText());
				outentity.setTicket_id(MainSDK.ticket_id.getText());
				outentity.setElectronic_prepay("0");
				outentity.setElectronic_pay(MainSDK.ed_total.getText());
				outentity.setService_name("upload_order");
				outentity.setData_target("cloud");
				try {
					String outmsg = JSONObject.fromObject(outentity).toString();
					System.out.println(">>>>>outpark���ƶ˷��� :" + outmsg);
					String outstate = UploadUtil.uploadData(outmsg);
					System.out.println(">>>>>outpark���ƶ˷��� :" + state);
					if (MainSDK.getState(outstate) == 1) {
						SqliteJDBC.Delete(outentity.getOrder_id());
//						MainSDK.ShowDialog(outentity.getCar_number() + "�ֽ�����ɹ�");
						MainSDK.clearOrder();
					}
				} catch (Exception e) {
					// lblNewLabel.setText(e.getMessage());
				}
				
				String bolinkstr = "{\"service_name\":\"outpark\",\"data_target\":\"bolink\",\"state\":1,\"errmsg\":\"֧���ɹ�\",\"trade_no\":\""+trade_no+"\",\"order_id\":\""+orderid+"\"}";
				System.out.println(">>>>>outpark��bolink���� :" + bolinkstr);
				String s = UploadUtil.uploadData(bolinkstr);
				System.out.println(">>>>>outpark��bolink���� :" + s);
				
			} else {

			}
			break;
		case "prepay_order":

			String prepay = object.getString("prepay");
			orderid = object.getString("order_id");

			for (int i = 0; i < MainSDK.carInList.size(); i++) {
				if (MainSDK.carInList.get(i).getOrder_id().equals(orderid)) {
					querry = true;
					MainSDK.carInList.get(i).setPrepay(prepay);
					break;
				} else {
					querry = false;
				}
			}

			if (querry) {
				errmsg = "success";
				state = 1;
				SqliteJDBC.Update("prepay", prepay, orderid);
				MainSDK.edit_prepay.setText(prepay);
				String total = MainSDK.ed_total.getText();
				if (total != null && !total.equals("")) {
					double totalnow = new BigDecimal(Double.parseDouble(total) - Double.parseDouble(prepay))
							.setScale(BigDecimal.ROUND_HALF_UP, 2).doubleValue();
					if (totalnow <= 0)
						totalnow = 0;
					MainSDK.ed_total_now.setText(totalnow + "");
				}

			} else {
				state = 0;
				errmsg = "δ��ѯ���˶���";
			}
			back = "{\"service_name\":\"prepay_order\",\"data_target\":\"bolink\",\"errmsg\":\"" + errmsg
					+ "\",\"state\":" + state + ",\"park_id\":\"" + parkid + "\",\"order_id\":\"" + orderid
					+ "\",\"prepay\":\"" + prepay + "\",\"query_time\":" + System.currentTimeMillis() / 100 + "}";
			System.out.println(">>>>>�ص����� :" + back);
			String s = UploadUtil.uploadData(back);
			System.out.println(s);

			break;
		case "query_price":
			String order_id;
			if (msg.contains("order_id")) {
				order_id = object.getString("order_id");
			} else {
				order_id = "";
			}

			double price = 0;

			long duration = 0;
			double Total = 0;
			double derate_duration = 0;
			for (int i = 0; i < MainSDK.carInList.size(); i++) {
				if (MainSDK.carInList.get(i).getOrder_id().equals(order_id)) {
					querry = true;
					long intime = MainSDK.carInList.get(i).getIn_time();
					duration = System.currentTimeMillis() / 1000 - intime;
					price = new BigDecimal(FileUtil.calPrice(duration)).setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue();
					Total = price;
					// �ȼ���Ԥ��
					String prepaystr = SqliteJDBC.Querry("order_id", order_id,"prepay");
//					String prepaystr = MainSDK.edit_prepay.getText().equals("")?"0":MainSDK.edit_prepay.getText();
					if (prepaystr != null && !order_id.equals("")) {
						double prepays = Double.parseDouble(prepaystr);
						Total = price - prepays;
					}

					// �ټ����Ż�ȯ
					String coupon_type = MainSDK.carInList.get(i).getCoupon_type();
					String coupon = MainSDK.carInList.get(i).getCoupon();
					if (coupon_type != null && !coupon_type.equals("")) {
						if (coupon_type.equals("0")) {
							// 0��1ʱ��
							derate_duration = 0;
						} else {
							derate_duration = Double.parseDouble(coupon) * 100 / 60;
							// derate_money = "";
						}
						derate_money = Double.parseDouble(coupon);
						double conponed = price - Double.parseDouble(coupon);
						if (conponed < 0) {
							Total = 0;
						} else {
							Total = new BigDecimal(conponed).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
						}
					}
					Total = new BigDecimal(Total).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

					break;
				}else if(MainSDK.selectionIndex>=MainSDK.carInList.size()){
					querry = false;
					break;
				} else if (MainSDK.selectionIndex<MainSDK.carInList.size()&&MainSDK.selectionIndex>=0&&msg.contains("out_channel_id") && object.getString("out_channel_id")
						.equals(MainSDK.carInList.get(MainSDK.selectionIndex).getIn_channel_id())) {
					CarInEntity entityin = MainSDK.carInList.get(MainSDK.selectionIndex);
					order_id = entityin.getOrder_id();
					querry = true;
					duration = System.currentTimeMillis() / 1000 - entityin.getIn_time();
					price = Double.parseDouble(MainSDK.EditTotal);

					Total = price;
					// �ȼ���Ԥ��
					String prepaystr = MainSDK.edit_prepay.getText().equals("")?"0":MainSDK.edit_prepay.getText();
					if (prepaystr != null && !order_id.equals("")) {
						double prepays = Double.parseDouble(prepaystr);
						Total = price - prepays;
					}

					// �ټ����Ż�ȯ
					String coupon_type = MainSDK.carInList.get(i).getCoupon_type();
					String coupon = MainSDK.carInList.get(i).getCoupon();
					if (coupon_type != null && !coupon_type.equals("")) {
						if (coupon_type.equals("0")) {
							// 0��1ʱ��
							derate_duration = 0;
						} else {
							derate_duration = Double.parseDouble(coupon) * 100 / 60;
							// derate_money = "";
						}
						derate_money = Double.parseDouble(coupon);
						double conponed = price - Double.parseDouble(coupon);
						if (conponed < 0) {
							Total = 0;
						} else {
							Total = new BigDecimal(conponed).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
						}
					}
					Total = new BigDecimal(Total).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					break;
				} else {
					querry = false;
				}
			}
			if (querry) {
				errmsg = "success";
				state = 1;
			} else {
				state = 0;
				errmsg = "δ��ѯ���˶���";
			}
			// = (prices-Double.parseDouble(derate_money))>0
			String query_order_no = "";
			if(object.toString().contains("query_order_no")){
				query_order_no = object.getString("query_order_no");
			}
			back = "{\"service_name\":\"query_price\",\"data_target\":\"bolink\",\"errmsg\":\"" + errmsg
					+ "\",\"state\":" + state + ",\"park_id\":\"" + parkid + "\",\"order_id\":\"" + order_id
					+ "\",\"price\":\"" + Total + "\",\"duration\":" + ((duration / 60) >= 1 ? (duration / 60) : 1)
					+ ",\"free_out_time\":" + 100 + ",\"query_time\":" + System.currentTimeMillis() / 1000
					+ ",\"derate_money\":\"" + derate_money + "\",\"derate_duration\":\"" + derate_duration
					+ "\",\"total\":\"" + price + "\",\"query_order_no\":\""+query_order_no+"\"}";
			System.out.println(">>>>>�ص����� :" + back);
			UploadUtil.uploadData(back);
			break;
		case "lock_car":

			int islock = object.getInt("is_locked");
			if (islock == 0) {
				// ����
				back = "{\"state\":1,\"service_name\":\"lock_car\",\"errmsg\":\"�����ɹ�\",\"data_target\":\"cloud\",\"order_id\":\"12345\",\"is_locked\":0}";
			} else {
				// ����
				back = "{\"state\":1,\"service_name\":\"lock_car\",\"errmsg\":\"�����ɹ�\",\"data_target\":\"cloud\",\"order_id\":\"12345\",\"is_locked\":1}";
			}

			System.out.println(">>>>>�ص����� :" + back);
			s = UploadUtil.uploadData(back);
			System.out.println(s);

			break;
		case "deliver_ticket":

			int ticket_type = object.getInt("ticket_type");
			order_id = object.getString("order_id");
			String ticket_id = object.getString("ticket_id");

			int index = 0;
			for (int i = 0; i < MainSDK.carInList.size(); i++) {
				if (MainSDK.carInList.get(i).getOrder_id().equals(order_id)) {
					querry = true;
					index = i;
					break;
				} else {
					querry = false;
				}
			}
			if (querry) {
				derate_money = 0;// �ش���sdk���Ż�ȯ���
				// CarInEntity entity = MainSDK.carInList.get(index);
				if (ticket_type == 0 || ticket_type == 2) {
					// ����ͣ�����
					derate_money = object.getDouble("money");
				} else {
					// ����ͣ��ʱ�� СʱΪ��λ������۸���3600��
					derate_money = Double.parseDouble(object.getString("duration")) * FileUtil.calPrice(3600);
//					MainSDK.ticket_id.setText(object.getString("duration"));
				}
				MainSDK.textField_3.setText(new BigDecimal(derate_money).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "");
				SqliteJDBC.Update("coupon", derate_money + "", order_id);
				SqliteJDBC.Update("coupon_type", ticket_type + "", order_id);
				SqliteJDBC.Update("couponid", object.getString("ticket_id"), order_id);
				MainSDK.carInList.get(index).setCoupon(derate_money + "");
				MainSDK.carInList.get(index).setCoupon_type(ticket_type + "");
				MainSDK.carInList.get(index).setCouponid(object.getString("ticket_id"));
				back = "{\"service_name\":\"deliver_ticket\",\"data_target\":\"cloud\",\"ticket_id\":\"" + ticket_id
						+ "\",\"order_id\":\"" + order_id + "\",\"state\":1,\"errmsg\":\"�Ѽ���\"}";
			} else {
				back = "{\"service_name\":\"deliver_ticket\",\"data_target\":\"cloud\",\"ticket_id\":\"" + ticket_id
						+ "\",\"order_id\":\"" + order_id
						+ "\",\"derate_money\":\"0\",\"state\":0,\"errmsg\":\"δ�ҵ�����\"}";
			}
			System.out.println(">>>>>�ص����� :" + back);
			s = UploadUtil.uploadData(back);
			System.out.println(s);

			break;
		case "query_prodprice":
			trade_no = object.getString("trade_no");
			back = "{\"service_name\":\"query_prodprice\",\"data_target\":\"cloud\",\"state\":1,\"trade_no\":\""
					+ trade_no + "\",\"errmsg\":\"��ѯ�¿��۸�ɹ�\",\"price\":\"39.9\"}";
			System.out.println(">>>>>�ص����� :" + back);
			s = UploadUtil.uploadData(back);
			System.out.println(s);
			break;
		case "monthcard_pay":
			trade_no = object.getString("trade_no");
			String pay_money = object.getString("pay_money");

			back = "{\"service_name\":\"monthcard_pay\",\"data_target\":\"bolink\",\"state\":1,\"trade_no\":\""
					+ trade_no + "\",\"errmsg\":\"�¿����ѳɹ�\",\"park_id\":\"" + parkid + "\",\"pay_money\":\"" + pay_money
					+ "\"}";
			System.out.println(">>>>>�ص����� :" + back);
			s = UploadUtil.uploadData(back);
			System.out.println(s);
			break;
		case "nolicence_in_park":
			String user_uuid = object.getString("car_number");
			String park_id = object.getString("park_id");
			String channel_id = object.getString("channel_id");
			
			long current =  System.currentTimeMillis();
			
			entity = new CarInEntity();
			entity.setCar_number(user_uuid);
			entity.setIn_time(current/1000);
			entity.setC_type("��ͨ����");
			entity.setCar_type("С�ͳ�");
			entity.setEmpty_plot(99);
			entity.setIn_channel_id(channel_id);
			 entity.setOrder_id(current+"");
			
			entity.setUid(MainSDK.ed_uid.getText());
			MainSDK.carInList.add(entity);
			SqliteJDBC.Insert(entity);
			
			String msgcarin = JSONObject.fromObject(entity).toString();
		
			System.out.println("���ͽ�����" + msgcarin);
			String statein = UploadUtil.uploadInParkOrder(msgcarin);
			System.out.println("���ɽ���������" + state);
			JSONObject stateinjson = JSONObject.fromObject(statein);
			if(stateinjson.getString("state").equals("1")){
				if (MainSDK.carInList != null && MainSDK.carInList.size() > 0) {
					String[] arr = new String[MainSDK.carInList.size()];
					for (int i = 0; i < MainSDK.carInList.size(); i++) {
						arr[i] = MainSDK.carInList.get(i).getCar_number();
					}
					MainSDK.jListModel = new DefaultComboBoxModel(arr); // ����ģ��
					MainSDK.list.setModel(MainSDK.jListModel);
				}
				back = "{\"service_name\":\"nolicence_in_park\",\"data_target\":\"bolink\",\"state\":1,\"errmsg\":\"�������Ƴ�����\",\"user_uuid\":\""+user_uuid+"\"}";
			}else{
				back = "{\"service_name\":\"nolicence_in_park\",\"data_target\":\"bolink\",\"state\":0,\"errmsg\":\"�������Ƴ�����ʧ��\",\"user_uuid\":\""+user_uuid+"\"}";
			}
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(">>>>>�ص����� :" + back);
			s = UploadUtil.uploadData(back);
			System.out.println(s);
			break;
		default:
			back = "{\"state\":1,\"service_name\":\"default_service\",\"errmsg\":\"δ�����msg callback\"}";
			break;
		}

	}

}
