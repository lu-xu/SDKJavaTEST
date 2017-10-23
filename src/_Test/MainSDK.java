package _Test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FontUIResource;



import _Test.bean.CarInEntity;
import _Test.bean.CarOutEntity;
import _Test.bean.PayState;
import net.sf.json.JSONObject;
import sdk.UploadUtil;
import sqlite.SqliteJDBC;
import util.FileUtil;

public class MainSDK {
	// 200002 21776 EA2D90FEEF1E9F8E D8G5M0U488B4A7ZD
	// 200103 21762 10EEF10020BEC31B WERRTTTTYY
	// 21779，ck: Q0RX0PQOF6ZXD4TO 泊链厂商编号：200002,UK:EA2D90FEEF1E9F8E
	// 3251，ck: 9H3YD5U5T73GITSP 泊链厂商编号：200002,UK:EA2D90FEEF1E9F8E
	
//	public static final String PARK_ID = "KJ10001";
//	public static final String U_ID = "200191";
//	public static final String CK = "WERRTTTTYY";
//	public static final String UK= "6E1A70B2BC708876";
	

	public static final String PARK_ID = "21787";
	public static final String U_ID = "200159";
	public static final String CK = "LDGFFLEWS4WE67US";
	public static final String UK= "C160955B1479621F";
	

//	public static final String PARK_ID = "3251";
//	public static final String U_ID = "200002";
//	public static final String CK = "9H3YD5U5T73GITSP";
//	public static final String UK= "EA2D90FEEF1E9F8E";
	
//	public static final String LOCAL_ID= "gg1_channels_hhhh";
//	public static final String LOCAL_ID= "gu_CSMD啊1channels__古月测试车场东门进口Ab-1_古月测试车场东门进口Ab-2_古月测试车场xi门出口Ba—3";
	public static final String LOCAL_ID= "gg1_channels_A1_A2_B3";
//	public static final String LOCAL_ID= "MS-20170114YUXD_channels_01-1_01-2guyue_aa1channelsMS-20170114YUXD_channels_01-1_01-2";
	public static final int LOG_SHOW= 0;
	public static final int PORT = 6789;
//	public static final String CLOUD_ADDR = "yun.bolink.club";
//	public static final String BOLINK_ADDR = "s.bolink.club";
	public static final String CLOUD_ADDR = "test.bolink.club";
	public static final String BOLINK_ADDR = "beta.bolink.club";
//	public static final String BOLINK_ADDR = "192.168.199.206";
//	public static final String BOLINK_ADDR = "192.168.199.222";
//	public static final String CLOUD_ADDR = "192.168.199.214";
	
	private static JFrame frame;
	private JTextField ed_carnumber;
	private JTextField ed_intime;
	private JTextField ed_intype;
	private JTextField ed_cartype;
	private JTextField ed_inchannel;
	private static JTextField ed_carnumber_out;
	private JTextField ed_intime_out;
	private JTextField ed_intype_out;
	private JTextField ed_cartype_out;
	private JTextField ed_inchannel_out;
	private JTextField ed_outtime;
	private JTextField ed_orderid;
	public static JTextField ed_total;

	private static InterFaceParking g_park = null;

	public static void main(String[] args) {

//		try {
//			String encode1 = URLEncoder.encode("红红火火恍恍惚惚", "utf-8");
//			String encode2 = URLEncoder.encode(encode1, "utf-8");
//			System.out.println(encode1);
//			System.out.println(encode2);
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		g_park = new InterFaceParking();
		UploadUtil.setInterfacePark(g_park);
		SqliteJDBC.Init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSDK window = new MainSDK();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private static void InitGlobalFont(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}

	/**
	 * Create the application.
	 */
	public MainSDK() {
		initialize();
	}

	public static int selectionIndex=-1;
	public static String EditTotal;
	public static String Edityouhui;
	static ListModel jListModel; // 数据模型
	String[] strArr = new String[] {};
	static JList list = new JList();
	public static List<CarInEntity> carInList = new ArrayList<CarInEntity>();
	private static List<CarOutEntity> carOutList = new ArrayList<CarOutEntity>();
	private static List<PayState> payStateList = new ArrayList<PayState>();
	private JTextField ed_scan;
	JLabel lblNewLabel_2;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		jListModel = new DefaultComboBoxModel(strArr); // 数据模型
		final JLabel lblNewLabel = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 784, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		
		
		lblNewLabel.setText("input union_id   ukey   parkid   ckey   localid");
		JLabel label = new JLabel("\u8F66\u8F86\u8FDB\u573A");
		springLayout.putConstraint(SpringLayout.NORTH, label, 29, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, label, 59, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u8F66\u724C\u53F7");
		springLayout.putConstraint(SpringLayout.NORTH, list, -1, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 11, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u8FDB\u573A\u65F6\u95F4");
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 15, SpringLayout.SOUTH, label_1);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u8FDB\u573A\u7C7B\u578B");
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 15, SpringLayout.SOUTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label_1);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u8F66\u578B");
		springLayout.putConstraint(SpringLayout.NORTH, label_4, 16, SpringLayout.SOUTH, label_3);
		springLayout.putConstraint(SpringLayout.WEST, label_4, 0, SpringLayout.WEST, label_1);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("\u8FDB\u573A\u901A\u9053");
		springLayout.putConstraint(SpringLayout.NORTH, label_5, 16, SpringLayout.SOUTH, label_4);
		springLayout.putConstraint(SpringLayout.WEST, label_5, 0, SpringLayout.WEST, label_1);
		frame.getContentPane().add(label_5);

		ed_carnumber = new JTextField();
		ed_carnumber.setText("苏DTTTTT");
		springLayout.putConstraint(SpringLayout.WEST, ed_carnumber, 54, SpringLayout.EAST, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, ed_carnumber, 0, SpringLayout.SOUTH, label_1);
		frame.getContentPane().add(ed_carnumber);
		ed_carnumber.setColumns(10);

		ed_intime = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, ed_intime, 0, SpringLayout.WEST, ed_carnumber);
		springLayout.putConstraint(SpringLayout.SOUTH, ed_intime, 0, SpringLayout.SOUTH, label_2);
		frame.getContentPane().add(ed_intime);
		ed_intime.setColumns(10);

		myTimer timer = new myTimer();
		javax.swing.Timer t = new javax.swing.Timer(1000, timer);
		t.start();
		ed_intype = new JTextField();
		ed_intype.setText("\u666E\u901A\u5165\u573A");
		springLayout.putConstraint(SpringLayout.WEST, ed_intype, 0, SpringLayout.WEST, ed_carnumber);
		springLayout.putConstraint(SpringLayout.SOUTH, ed_intype, 0, SpringLayout.SOUTH, label_3);
		frame.getContentPane().add(ed_intype);
		ed_intype.setColumns(10);

		ed_cartype = new JTextField();
		ed_cartype.setText("\u5C0F\u578B\u8F66");
		springLayout.putConstraint(SpringLayout.WEST, ed_cartype, 0, SpringLayout.WEST, ed_carnumber);
		springLayout.putConstraint(SpringLayout.SOUTH, ed_cartype, 0, SpringLayout.SOUTH, label_4);
		frame.getContentPane().add(ed_cartype);
		ed_cartype.setColumns(10);

		ed_inchannel = new JTextField();
		ed_inchannel.setText("A1");
		springLayout.putConstraint(SpringLayout.WEST, ed_inchannel, 0, SpringLayout.WEST, ed_carnumber);
		springLayout.putConstraint(SpringLayout.SOUTH, ed_inchannel, 0, SpringLayout.SOUTH, label_5);
		frame.getContentPane().add(ed_inchannel);
		ed_inchannel.setColumns(10);

		JButton button = new JButton("\u8FDB\u573A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// long intime = System.currentTimeMillis()/1000;
				// System.out.println(" "+intime);
				// String orderid = (intime+"").substring(5, 10);
				// String msg =
				// "{\"car_number\":\""+ed_carnumber.getText()+"\",\"in_time\":"+ed_intime.getText()+",\"car_type\":\""+ed_cartype.getText()+"\",\"c_type\":\""+ed_intype.getText()+"\",\"uid\":"+880099+",\"order_id\":\""+ed_orderid.getText()+"\",\"in_channel_id\":\""+ed_inchannel.getText()+"\"}";
				// System.out.println(msg);
				// String state = UploadUtil.uploadInParkOrder(msg);
				// System.out.println(state);
				lblNewLabel.setText("点击了进场");
				CarInEntity entity = new CarInEntity();
				lblNewLabel.setText(entity.toString());
				entity.setCar_number(ed_carnumber.getText());
				entity.setIn_time(Str2Unix(ed_intime.getText()));
				entity.setC_type(ed_intype.getText());
				entity.setCar_type(ed_cartype.getText());
				entity.setEmpty_plot(Integer.valueOf(ed_emptyPlot.getText()));
				entity.setIn_channel_id(ed_inchannel.getText());
				// entity.setOrder_id((Str2Unix(ed_intime.getText()) +
				// "").substring(5, 10));
				String orderId = ed_orderId.getText();
				if (orderId.equals("A1_2C")) {
					entity.setOrder_id(orderId + Str2Unix(ed_intime.getText()));
				} else {
					entity.setOrder_id((Str2Unix(ed_intime.getText()) + "").substring(5, 10));
				}
				entity.setUid(ed_uid.getText());
				carInList.add(entity);
				SqliteJDBC.Insert(entity);
				lblNewLabel.setText("list size:" + carInList.size());
				String msg = Obj2Json(entity);
				lblNewLabel.setText(msg);
				System.out.println("发送进场：" + msg);
				String state = UploadUtil.uploadInParkOrder(msg);
				System.out.println("进场SDK同步返回：" + state);
				lblNewLabel_2.setText(state);
				if (carInList != null && carInList.size() > 0) {
					String[] arr = new String[carInList.size()];
					for (int i = 0; i < carInList.size(); i++) {
						arr[i] = carInList.get(i).getCar_number();
					}
					jListModel = new DefaultComboBoxModel(arr); // 数据模型
					list.setModel(jListModel);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button, 85, SpringLayout.SOUTH, label_5);
		springLayout.putConstraint(SpringLayout.WEST, button, 43, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(button);

		JLabel label_6 = new JLabel("\u8F66\u8F86\u51FA\u573A");
		springLayout.putConstraint(SpringLayout.WEST, label_6, 245, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, label_6, 0, SpringLayout.SOUTH, label);
		frame.getContentPane().add(label_6);

		JLabel label_7 = new JLabel("\u8F66\u724C\u53F7");
		springLayout.putConstraint(SpringLayout.WEST, label_7, 134, SpringLayout.EAST, ed_carnumber);
		springLayout.putConstraint(SpringLayout.SOUTH, label_7, 0, SpringLayout.SOUTH, label_1);
		frame.getContentPane().add(label_7);

		JLabel label_8 = new JLabel("\u8FDB\u573A\u65F6\u95F4");
		springLayout.putConstraint(SpringLayout.WEST, label_8, 0, SpringLayout.WEST, label_7);
		springLayout.putConstraint(SpringLayout.SOUTH, label_8, 0, SpringLayout.SOUTH, label_2);
		frame.getContentPane().add(label_8);

		JLabel label_9 = new JLabel("\u8FDB\u573A\u7C7B\u578B");
		springLayout.putConstraint(SpringLayout.WEST, label_9, 0, SpringLayout.WEST, label_7);
		springLayout.putConstraint(SpringLayout.SOUTH, label_9, 0, SpringLayout.SOUTH, label_3);
		frame.getContentPane().add(label_9);

		JLabel label_10 = new JLabel("\u8F66\u578B");
		springLayout.putConstraint(SpringLayout.WEST, label_10, 0, SpringLayout.WEST, label_7);
		springLayout.putConstraint(SpringLayout.SOUTH, label_10, 0, SpringLayout.SOUTH, label_4);
		frame.getContentPane().add(label_10);

		JLabel label_11 = new JLabel("\u8FDB\u573A\u901A\u9053");
		springLayout.putConstraint(SpringLayout.WEST, label_11, 0, SpringLayout.WEST, label_7);
		springLayout.putConstraint(SpringLayout.SOUTH, label_11, 0, SpringLayout.SOUTH, label_5);
		frame.getContentPane().add(label_11);

		JLabel label_12 = new JLabel("\u51FA\u573A\u65F6\u95F4");
		springLayout.putConstraint(SpringLayout.NORTH, label_12, 15, SpringLayout.SOUTH, label_11);
		springLayout.putConstraint(SpringLayout.WEST, label_12, 0, SpringLayout.WEST, label_7);
		frame.getContentPane().add(label_12);

		JLabel label_13 = new JLabel("\u8BA2\u5355\u53F7");
		springLayout.putConstraint(SpringLayout.NORTH, label_13, 16, SpringLayout.SOUTH, label_12);
		springLayout.putConstraint(SpringLayout.WEST, label_13, 0, SpringLayout.WEST, label_7);
		frame.getContentPane().add(label_13);

		JLabel label_14 = new JLabel("\u91D1\u989D");
		springLayout.putConstraint(SpringLayout.NORTH, label_14, 13, SpringLayout.SOUTH, label_13);
		springLayout.putConstraint(SpringLayout.WEST, label_14, 0, SpringLayout.WEST, label_7);
		frame.getContentPane().add(label_14);

		ed_carnumber_out = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, ed_carnumber_out, 65, SpringLayout.EAST, label_7);
		springLayout.putConstraint(SpringLayout.SOUTH, ed_carnumber_out, 0, SpringLayout.SOUTH, label_1);
		frame.getContentPane().add(ed_carnumber_out);
		ed_carnumber_out.setColumns(10);

		ed_intime_out = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ed_intime_out, 0, SpringLayout.NORTH, ed_intime);
		springLayout.putConstraint(SpringLayout.WEST, ed_intime_out, 0, SpringLayout.WEST, ed_carnumber_out);
		frame.getContentPane().add(ed_intime_out);
		ed_intime_out.setColumns(10);

		ed_intype_out = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ed_intype_out, 0, SpringLayout.NORTH, ed_intype);
		springLayout.putConstraint(SpringLayout.WEST, ed_intype_out, 0, SpringLayout.WEST, ed_carnumber_out);
		frame.getContentPane().add(ed_intype_out);
		ed_intype_out.setColumns(10);

		ed_cartype_out = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ed_cartype_out, 0, SpringLayout.NORTH, ed_cartype);
		springLayout.putConstraint(SpringLayout.EAST, ed_cartype_out, 0, SpringLayout.EAST, ed_carnumber_out);
		frame.getContentPane().add(ed_cartype_out);
		ed_cartype_out.setColumns(10);

		ed_inchannel_out = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ed_inchannel_out, 0, SpringLayout.NORTH, ed_inchannel);
		springLayout.putConstraint(SpringLayout.EAST, ed_inchannel_out, 0, SpringLayout.EAST, ed_carnumber_out);
		frame.getContentPane().add(ed_inchannel_out);
		ed_inchannel_out.setColumns(10);

		ed_outtime = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ed_outtime, 0, SpringLayout.NORTH, label_12);
		springLayout.putConstraint(SpringLayout.EAST, ed_outtime, 0, SpringLayout.EAST, ed_carnumber_out);
		frame.getContentPane().add(ed_outtime);
		ed_outtime.setColumns(10);

		ed_orderid = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ed_orderid, 0, SpringLayout.NORTH, label_13);
		springLayout.putConstraint(SpringLayout.EAST, ed_orderid, 0, SpringLayout.EAST, ed_carnumber_out);
		frame.getContentPane().add(ed_orderid);
		ed_orderid.setColumns(10);

		ed_total = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ed_total, 0, SpringLayout.NORTH, label_14);
		springLayout.putConstraint(SpringLayout.EAST, ed_total, 0, SpringLayout.EAST, ed_carnumber_out);
		frame.getContentPane().add(ed_total);
		ed_total.setColumns(10);

		JButton button_1 = new JButton("现金出场");
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 37, SpringLayout.SOUTH, label_14);
		springLayout.putConstraint(SpringLayout.WEST, button_1, 224, SpringLayout.WEST, frame.getContentPane());
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("点击了出场");
				CarOutEntity outentity = new CarOutEntity();
				// int islocked = outentity.getIslocked();
				// System.out.println(islocked);
				// outentity.setService_name("pay_status");
				outentity.setPay_type("cash");
				outentity.setCar_number(ed_carnumber_out.getText());
				outentity.setIn_time(Str2Unix(ed_intime_out.getText()));
				outentity.setOut_time(Str2Unix(ed_outtime.getText()));
				outentity.setCar_type(ed_cartype_out.getText());
				outentity.setC_type(ed_intype.getText());
				outentity.setUid(ed_uid.getText());
				String outuid = ed_uid_out.getText().equals("") ? ed_uid.getText() : ed_uid_out.getText();
				outentity.setOut_uid(outuid);
				outentity.setOrder_id(ed_orderid.getText());
				outentity.setOut_channel_id(ed_outChannelId.getText());
				outentity.setTotal(ed_total_now.getText());
				outentity.setReduce_amount(textField_3.getText());
				outentity.setTicket_id(ticket_id.getText());
				outentity.setElectronic_prepay(edit_prepay.getText());
//				outentity.setAmount_receivable(
//						new BigDecimal(FileUtil.calPrice(Str2Unix(ed_outtime.getText()) - Str2Unix(ed_intime_out.getText()))).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "");
				outentity.setAmount_receivable(ed_total.getText());
				// outentity.setAuth_code(ed_scan.getText());
				// outentity.setPay_type("kfcpay");
				// outentity.setFreereasons("15分钟内免费");
				carOut = outentity;
				try {
					String msg = JSONObject.fromObject(outentity).toString();
					lblNewLabel.setText("json msg:" + msg);
					System.out.println(msg);
					lblNewLabel.setText(msg);
					String state = UploadUtil.uploadOutParkOrder(msg);
					System.out.println("点击出场同步:" + state);
					lblNewLabel_2.setText(state);

					if (getState(state) == 1) {
						SqliteJDBC.Delete(carOut.getOrder_id());
						ShowDialog(ed_carnumber_out.getText() + "现金出场成功");
						clearOrder();
					}
				} catch (Exception e) {
					lblNewLabel.setText(e.getMessage());
				}

			}
		});
		frame.getContentPane().add(button_1);
		list.setModel(jListModel);
		list.setPreferredSize(new java.awt.Dimension(120, 200));
		// itemclicklistener
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					selectionIndex = list.getSelectedIndex();
					CarInEntity entity = carInList.get(selectionIndex);
					System.out.println(entity.toString());

					ed_carnumber_out.setText(entity.getCar_number());
					ed_intime_out.setText(Unix2Str(entity.getIn_time(), 1000));
					ed_cartype_out.setText(entity.getCar_type());
					ed_intype_out.setText(entity.getC_type());
					ed_orderid.setText(entity.getOrder_id());
					ed_inchannel_out.setText(entity.getIn_channel_id());
					ed_outChannelId.setText(entity.getIn_channel_id());
					ed_outtime.setText(Unix2Str(System.currentTimeMillis(), 1));
					textField_3.setText(entity.getCoupon());
					ticket_id.setText(entity.getCouponid());
					edit_prepay.setText(entity.getPrepay());

					Long timespan = System.currentTimeMillis() / 1000 - entity.getIn_time();
					double total = FileUtil.calPrice(timespan);// 本地计算的总价格
					ed_total.setText(new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "");
					if (entity.getPrepay() != null && !entity.getPrepay().equals("")) {
						// 预支付
						double prepays = Double.parseDouble(entity.getPrepay());
						total = total - prepays;
					}
					if (entity.getCoupon() != null && !entity.getCoupon().equals("")) {
						// 优惠券减免金额
						double coupon = Double.parseDouble(entity.getCoupon());
						total = total - coupon;
						if (total < 0) {
							total = 0;
						}
					}

					BigDecimal b = new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_UP);
					ed_total_now.setText(b + "");
					EditTotal = ed_total.getText();
					boolean isContain = false;
					int index = 0;
					if (payStateList != null && payStateList.size() > 0) {
						for (int i = 0; i < payStateList.size(); i++) {
							if (payStateList.get(i).getOrder_id().equals(entity.getOrder_id())) {
								isContain = true;
								index = i;
								break;
							} else {
								isContain = false;
							}
						}
					} else {
						isContain = false;
					}
					if (!isContain) {
						String pay_status = "{\"service_name\":\"pay_status\",\"car_number\":\""
								+ entity.getCar_number() + "\",\"order_id\":\"" + entity.getOrder_id() + "\"}";
						String result = UploadUtil.getPayStatus(pay_status);
						System.out.println("query paytype :" + result);
						// {"balance":"0","car_number":"晋AAAQAZ","errmsg":"","is_exist":0,"net_status":1,
						// "order_id":"1494230327","service_name":"pay_status","state":1}
						JSONObject obj = JSONObject.fromObject(result);
						PayState payState = new PayState();
						payState.setBalance(obj.getString("balance"));
						payState.setNet_status(obj.getString("net_status"));
						payState.setIs_exist(obj.getString("is_exist"));
						payState.setCar_number(obj.getString("car_number"));
						payState.setErrmsg(obj.getString("errmsg"));
						payState.setService_name(obj.getString("service_name"));
						payState.setOrder_id(obj.getString("order_id"));
						payState.setState(obj.getInt("state"));
						payStateList.add(payState);
					} else {
						String pay_status = "{\"service_name\":\"pay_status\",\"car_number\":\""
								+ entity.getCar_number() + "\",\"order_id\":\"" + entity.getOrder_id() + "\"}";
						String result = UploadUtil.getPayStatus(pay_status);
						System.out.println("query paytype :" + result);
						// {"balance":"0","car_number":"晋AAAQAZ","errmsg":"","is_exist":0,"net_status":1,
						// "order_id":"1494230327","service_name":"pay_status","state":1}
						JSONObject obj = JSONObject.fromObject(result);
						PayState payState = new PayState();
						payState.setBalance(obj.getString("balance"));
						payState.setNet_status(obj.getString("net_status"));
						payState.setIs_exist(obj.getString("is_exist"));
						payState.setCar_number(obj.getString("car_number"));
						payState.setErrmsg(obj.getString("errmsg"));
						payState.setService_name(obj.getString("service_name"));
						payState.setOrder_id(obj.getString("order_id"));
						payState.setState(obj.getInt("state"));
						payStateList.set(index, payState);
					}

				} catch (Exception ex) {
					System.out.println(ex);
					ed_carnumber_out.setText("");
					ed_intime_out.setText("");
					ed_cartype_out.setText("");
					ed_intype_out.setText("");
					ed_orderid.setText("");
					ed_inchannel_out.setText("");
					ed_outtime.setText("");
					ed_total.setText("");
				}

			}
		});
		frame.getContentPane().add(list);

		JLabel lblNewLabel_1 = new JLabel("扫码");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, label_1);
		frame.getContentPane().add(lblNewLabel_1);

		ed_scan = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, ed_scan);
		springLayout.putConstraint(SpringLayout.WEST, ed_scan, 0, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, ed_scan, -47, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, ed_scan, 0, SpringLayout.EAST, ed_carnumber);
		frame.getContentPane().add(ed_scan);
		ed_scan.setColumns(10);

		lblNewLabel_2 = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 38, SpringLayout.EAST, ed_scan);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, ed_scan);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("扫码出场");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("点击了出场");
				CarOutEntity outentity = new CarOutEntity();
				// outentity.setService_name("pay_status");
				// outentity.setPay_type("cash");
				outentity.setCar_number(ed_carnumber_out.getText());
				outentity.setIn_time(Str2Unix(ed_intime_out.getText()));
				outentity.setOut_time(Str2Unix(ed_outtime.getText()));
				outentity.setCar_type(ed_cartype_out.getText());
				outentity.setC_type(ed_intype.getText());
				outentity.setUid(ed_uid.getText());
				String outuid = ed_uid_out.getText().equals("") ? ed_uid.getText() : ed_uid_out.getText();
				outentity.setOut_uid(outuid);
				outentity.setOrder_id(ed_orderid.getText());
				outentity.setOut_channel_id(ed_outChannelId.getText());
				outentity.setTotal(ed_total_now.getText());
				outentity.setAuth_code(ed_scan.getText());
				outentity.setPay_type("kfcpay");
				outentity.setReduce_amount(textField_3.getText());
				outentity.setTicket_id(ticket_id.getText());
				outentity.setElectronic_prepay(edit_prepay.getText());
//				outentity.setAmount_receivable(
//						new BigDecimal(FileUtil.calPrice(Str2Unix(ed_outtime.getText()) - Str2Unix(ed_intime_out.getText()))).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "");
				outentity.setAmount_receivable(ed_total.getText());
				// outentity.setFreereasons("15分钟内免费");
				carOut = outentity;
				ed_scan.setText("");
				ed_scan.requestFocus();
				// SqliteJDBC.Update("100",outentity.getOrder_id());
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, button_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 16, SpringLayout.EAST, button_1);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("电子钱包");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				lblNewLabel.setText("点击了出场");
				CarOutEntity outentity = new CarOutEntity();
				// outentity.setService_name("pay_status");
				outentity.setPay_type("wallet");
				outentity.setCar_number(ed_carnumber_out.getText());
				outentity.setIn_time(Str2Unix(ed_intime_out.getText()));
				outentity.setOut_time(Str2Unix(ed_outtime.getText()));
				outentity.setCar_type(ed_cartype_out.getText());
				outentity.setC_type(ed_intype.getText());
				outentity.setUid(ed_uid.getText());
				String outuid = ed_uid_out.getText().equals("") ? ed_uid.getText() : ed_uid_out.getText();
				outentity.setOut_uid(outuid);
				outentity.setOrder_id(ed_orderid.getText());
				outentity.setOut_channel_id(ed_outChannelId.getText());
				outentity.setTotal(ed_total_now.getText());
				outentity.setReduce_amount(textField_3.getText());
				outentity.setTicket_id(ticket_id.getText());
				outentity.setElectronic_prepay(edit_prepay.getText());
//				outentity.setAmount_receivable(
//						new BigDecimal(FileUtil.calPrice(Str2Unix(ed_outtime.getText()) - Str2Unix(ed_intime_out.getText()))).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "");
				outentity.setAmount_receivable(ed_total.getText());
				if (payStateList != null && payStateList.size() > 0) {
					for (int i = 0; i < payStateList.size(); i++) {
						if (payStateList.get(i).getOrder_id().equals(outentity.getOrder_id())) {
							double order_balance = Double.parseDouble(outentity.getTotal());
							String b = payStateList.get(i).getBalance();
							if (b == null || b.equals("")) {
								// ShowDialog("无法电子钱包支付，请选择其他支付方式");
								// return;
								b = "0";
							}
							double balance = Double.parseDouble(b);
							// if
							// (payStateList.get(i).getNet_status().equals("1")
							// && (balance - order_balance) > 0) {
							carOut = outentity;
							try {
								String msg = JSONObject.fromObject(outentity).toString();
								lblNewLabel.setText("json msg:" + msg);
								System.out.println(msg);
								lblNewLabel.setText(msg);
								String state = UploadUtil.uploadOutParkOrder(msg);
								System.out.println("点击出场:" + state);
								lblNewLabel_2.setText(state);
								if (getState(state) == 1) {
									SqliteJDBC.Delete(carOut.getOrder_id());
									// ShowDialog(ed_carnumber_out.getText() +
									// "电子钱包出场成功");
									clearOrder();
								}
							} catch (Exception e) {
								lblNewLabel.setText(e.getMessage());
							}
							// } else {
							// //
							// ShowDialog("无法电子钱包支付，请选择其他支付方式");
							// }
						}
					}
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 20, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, button_1);
		frame.getContentPane().add(btnNewButton_1);

		ed_orderId = new JTextField();
		ed_orderId.setText("A1_2C");
		springLayout.putConstraint(SpringLayout.WEST, ed_orderId, 0, SpringLayout.WEST, ed_carnumber);
		springLayout.putConstraint(SpringLayout.SOUTH, ed_orderId, 0, SpringLayout.SOUTH, label_12);
		frame.getContentPane().add(ed_orderId);
		ed_orderId.setColumns(10);

		JLabel label_15 = new JLabel("订单编号");
		springLayout.putConstraint(SpringLayout.WEST, label_15, 0, SpringLayout.WEST, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, label_15, 0, SpringLayout.SOUTH, label_12);
		frame.getContentPane().add(label_15);

		ed_emptyPlot = new JTextField();
		ed_emptyPlot.setText("20");
		springLayout.putConstraint(SpringLayout.NORTH, ed_emptyPlot, 6, SpringLayout.SOUTH, ed_orderId);
		springLayout.putConstraint(SpringLayout.WEST, ed_emptyPlot, 0, SpringLayout.WEST, ed_carnumber);
		frame.getContentPane().add(ed_emptyPlot);
		ed_emptyPlot.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("空余车位");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, label_15);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 21, SpringLayout.SOUTH, label_15);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -42, SpringLayout.WEST, ed_emptyPlot);
		frame.getContentPane().add(lblNewLabel_3);

		ed_uid = new JTextField();
		ed_uid.setText("522797");
		springLayout.putConstraint(SpringLayout.SOUTH, ed_uid, -6, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.EAST, ed_uid, 0, SpringLayout.EAST, ed_carnumber);
		frame.getContentPane().add(ed_uid);
		ed_uid.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("收费员账号");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -6, SpringLayout.NORTH, button);
		frame.getContentPane().add(lblNewLabel_4);

		ed_outChannelId = new JTextField();
		ed_outChannelId.setText("B2");
		springLayout.putConstraint(SpringLayout.SOUTH, ed_outChannelId, -6, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, ed_outChannelId, 0, SpringLayout.EAST, ed_carnumber_out);
		frame.getContentPane().add(ed_outChannelId);
		ed_outChannelId.setColumns(10);

		JLabel label_16 = new JLabel("出场通道");
		springLayout.putConstraint(SpringLayout.WEST, label_16, 0, SpringLayout.WEST, label_7);
		springLayout.putConstraint(SpringLayout.SOUTH, label_16, -6, SpringLayout.NORTH, button_1);
		frame.getContentPane().add(label_16);

		JButton btnNewButton_2 = new JButton("上传月卡会员");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 上传月卡会员
				 */
				// 上传月卡会员
				Long cardId = System.currentTimeMillis() / 1000;
				String msg = "{\"service_name\":\"upload_month_member\",\"data_target\":\"cloud\"," + "\"card_id\":\""
						+ cardId + "\",\"car_number\":\"京T654321\","
						+ "\"begin_time\":1495855254,\"price\":\"50.0\",\"end_time\":1495955254,\"operate_type\":1}";
				String monthRet = UploadUtil.uploadData(msg);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>" + monthRet + msg);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("上传车辆图片");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// /*
				// * 上传车辆图片
				// * 车场初始化成功后测试通过SDK里面的http请求上传图片
				// * */
				byte[] data = null;
				FileImageInputStream input = null;
				try {
					input = new FileImageInputStream(new File("D:/1.jpg"));
					ByteArrayOutputStream output = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					int numBytesRead = 0;
					while ((numBytesRead = input.read(buf)) != -1) {
						output.write(buf, 0, numBytesRead);
					}
					data = output.toByteArray();
					output.close();
					input.close();
				} catch (FileNotFoundException ex1) {
					ex1.printStackTrace();
				} catch (IOException ex1) {
					ex1.printStackTrace();
				}

				if (data != null) {
//					String pics = Base64.encode(data);
					String pics = Base64.getEncoder().encode(data).toString();
					
					// 上传订单图片
					String dString = "{\"upload_type\":\"http\",\"service_name\":\"upload_carpic\",\"data_target\":\"cloud\","
							+ "\"order_id\":\""+ed_orderid.getText()+"\",\"create_time\":\""+System.currentTimeMillis()/1000+"\",\"car_number\":\""+ed_carnumber_out.getText()+"\","
							+ "\"pic_type\":\"jpg\",\"park_order_type\":\"in\",\"picture_source\":\"order\",\"resume\":\"测试\",\"content\":\""
							+ pics + "\"}";
					System.out.println(">>>>>>>>>>>>>>上传数据" + dString);
					String result = UploadUtil.uploadData(dString);
					System.out.println(">>>>>>>>>>>>>>上传结果" + result);
				}

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 6, SpringLayout.EAST, btnNewButton_2);
		frame.getContentPane().add(btnNewButton_3);

		textField = new JTextField();
		textField.setText("200002");
		springLayout.putConstraint(SpringLayout.EAST, list, -74, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, label_1);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		txtEadfeefefe = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEadfeefefe, -3, SpringLayout.NORTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, txtEadfeefefe, 0, SpringLayout.WEST, textField);
		txtEadfeefefe.setText("EA2D90FEEF1E9F8E");
		frame.getContentPane().add(txtEadfeefefe);
		txtEadfeefefe.setColumns(10);

		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, label_3);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		textField_1.setText("3251");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		txteztthbbzhogf = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txteztthbbzhogf, -3, SpringLayout.NORTH, label_4);
		springLayout.putConstraint(SpringLayout.WEST, txteztthbbzhogf, 0, SpringLayout.WEST, textField);
		txteztthbbzhogf.setText("9H3YD5U5T73GITSP");
		frame.getContentPane().add(txteztthbbzhogf);
		txteztthbbzhogf.setColumns(10);

		txtBengxiakalaka = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtBengxiakalaka, -3, SpringLayout.NORTH, label_5);
		springLayout.putConstraint(SpringLayout.WEST, txtBengxiakalaka, 0, SpringLayout.WEST, textField);
		txtBengxiakalaka.setText("ewfaf");
		frame.getContentPane().add(txtBengxiakalaka);
		txtBengxiakalaka.setColumns(10);

		JButton btnNewButton_4 = new JButton("初始化");
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, btnNewButton_4);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_4, 23, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_4, -81, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String msg = "{\"union_id\":\"" + textField.getText() + "\",\"ukey\":\"" + txtEadfeefefe.getText()
						+ "\",\"park_id\":\"" + textField_1.getText() + "\",\"bport\":6789,\"cport\":6789,\"ckey\":\""
						+ txteztthbbzhogf.getText()
						+ "\",\"cloud_addr\":\""+CLOUD_ADDR+"\",\"bolink_addr\":\""+BOLINK_ADDR+"\",\"local_id\":\""
						+ LOCAL_ID + "\",\"log_show\":"+LOG_SHOW+"}";
				// 200002 21776 EA2D90FEEF1E9F8E D8G5M0U488B4A7ZD
				// 200103 21762 10EEF10020BEC31B WERRTTTTYY
				// 21779，ck: Q0RX0PQOF6ZXD4TO 泊链厂商编号：200002,UK:EA2D90FEEF1E9F8E
				// 3251，ck: 9H3YD5U5T73GITSP 泊链厂商编号：200002,UK:EA2D90FEEF1E9F8E

				// String msg =
				// "{\"union_id\":\"200002\",\"ukey\":\"EA2D90FEEF1E9F8E\",\"park_id\":\"21782\",\"bport\":6789,\"cport\":6789,\"ckey\":\"7EZT2TH6BBZHO1GF\",\"cloud_addr\":\"test.bolink.club\",\"bolink_addr\":\"s.bolink.club\",\"local_id\":\"xljumj\",\"log_show\":1}";
				String state = UploadUtil.init(msg);
				System.out.println(state);
				lblNewLabel.setText(state);
			}
		});
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("月卡");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("点击了出场");
				CarOutEntity outentity = new CarOutEntity();
				// int islocked = outentity.getIslocked();
				// System.out.println(islocked);
				// outentity.setService_name("pay_status");
				outentity.setPay_type("monthuser");
				outentity.setCar_number(ed_carnumber_out.getText());
				outentity.setIn_time(Str2Unix(ed_intime_out.getText()));
				outentity.setOut_time(Str2Unix(ed_outtime.getText()));
				outentity.setCar_type(ed_cartype_out.getText());
				outentity.setC_type(ed_intype.getText());
				outentity.setUid(ed_uid.getText());
				String outuid = ed_uid_out.getText().equals("") ? ed_uid.getText() : ed_uid_out.getText();
				outentity.setOut_uid(outuid);
				outentity.setOrder_id(ed_orderid.getText());
				outentity.setOut_channel_id(ed_outChannelId.getText());
				outentity.setTotal(ed_total_now.getText());
				outentity.setReduce_amount(textField_3.getText());
				outentity.setTicket_id(ticket_id.getText());
				outentity.setElectronic_prepay(edit_prepay.getText());
//				outentity.setAmount_receivable(
//						new BigDecimal(FileUtil.calPrice(Str2Unix(ed_outtime.getText()) - Str2Unix(ed_intime_out.getText()))).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "");
				outentity.setAmount_receivable(ed_total.getText());
				// outentity.setAmount_receivable("0.01");
				// outentity.setAuth_code(ed_scan.getText());
				// outentity.setPay_type("kfcpay");
				// outentity.setFreereasons("15分钟内免费");
				carOut = outentity;
				try {
					String msg = JSONObject.fromObject(outentity).toString();
					lblNewLabel.setText("json msg:" + msg);
					System.out.println(msg);
					lblNewLabel.setText(msg);
					String state = UploadUtil.uploadOutParkOrder(msg);
					System.out.println("点击出场:" + state);
					lblNewLabel_2.setText(state);

					if (getState(state) == 1) {
						SqliteJDBC.Delete(carOut.getOrder_id());
						ShowDialog(ed_carnumber_out.getText() + "月卡出场成功");
						clearOrder();
					}
				} catch (Exception ex) {
					lblNewLabel.setText(ex.getMessage());
				}

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_5, 0, SpringLayout.NORTH, button_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_5, 18, SpringLayout.EAST, btnNewButton_1);
		frame.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("免费");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblNewLabel.setText("点击了出场");
				CarOutEntity outentity = new CarOutEntity();
				// int islocked = outentity.getIslocked();
				// System.out.println(islocked);
				// outentity.setService_name("pay_status");
				outentity.setPay_type("free");
				outentity.setCar_number(ed_carnumber_out.getText());
				outentity.setIn_time(Str2Unix(ed_intime_out.getText()));
				outentity.setOut_time(Str2Unix(ed_outtime.getText()));
				outentity.setCar_type(ed_cartype_out.getText());
				outentity.setC_type(ed_intype.getText());
				outentity.setUid(ed_uid.getText());
				String outuid = ed_uid_out.getText().equals("") ? ed_uid.getText() : ed_uid_out.getText();
				outentity.setOut_uid(outuid);
				outentity.setOrder_id(ed_orderid.getText());
				outentity.setOut_channel_id(ed_outChannelId.getText());
				outentity.setTotal(ed_total_now.getText());
				outentity.setReduce_amount(textField_3.getText());
				outentity.setTicket_id(ticket_id.getText());
				outentity.setElectronic_prepay(edit_prepay.getText());
//				outentity.setAmount_receivable(
//						new BigDecimal(FileUtil.calPrice(Str2Unix(ed_outtime.getText()) - Str2Unix(ed_intime_out.getText()))).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()+ "");
				outentity.setAmount_receivable(ed_total.getText());
				// outentity.setAmount_receivable("0.01");
				// outentity.setAuth_code(ed_scan.getText());
				// outentity.setPay_type("kfcpay");
				// outentity.setFreereasons("15分钟内免费");
				carOut = outentity;
				try {
					String msg = JSONObject.fromObject(outentity).toString();
					lblNewLabel.setText("json msg:" + msg);
					System.out.println(msg);
					lblNewLabel.setText(msg);
					String state = UploadUtil.uploadOutParkOrder(msg);
					System.out.println("点击出场:" + state);
					lblNewLabel_2.setText(state);

					if (getState(state) == 1) {
						SqliteJDBC.Delete(carOut.getOrder_id());
						ShowDialog(ed_carnumber_out.getText() + "免费出场成功");
						clearOrder();
					}
				} catch (Exception ex) {
					lblNewLabel.setText(ex.getMessage());
				}

			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_6, 6, SpringLayout.EAST, btnNewButton_5);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_6, 0, SpringLayout.SOUTH, button_1);
		frame.getContentPane().add(btnNewButton_6);

		JButton button_2 = new JButton("上班记录");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * 上传上班记录
				 */
				// 上传上班记录
				Long ntime = System.currentTimeMillis() / 1000;
				String msg = "{\"service_name\":\"work_record\"," + "\"data_target\":\"cloud\"," + "\"user_id\":\""
						+ textField_2.getText() + "\"," + "\"start_time\":" + ntime + "," + "\"uuid\":\""
						+ Math.random() + "\","
				// + "\"end_time\":"+ntime+","
				// + "\"worksite_id\":21,"
						+ "\"state\":0}";

				long intime = System.currentTimeMillis();
				System.out.println("请求数据上班>>>>>>>>>>>>>>>>>>>>>" + msg);
				String state = UploadUtil.uploadData(msg);
				long intimeback = System.currentTimeMillis();
				System.out.println("请求数据上班返回>>>>>>>>>>>>>>>>>>>>>" + state);
				System.out.println("上班时间间隔" + (intimeback - intime));

				// System.out.println("返回数据>>>>>>>>>>>>>>>>>>>>>"+result);
				HashMap<String, Integer> map = new HashMap<>();
				Iterator it = map.entrySet().iterator();
				it.hasNext();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, button_2, 0, SpringLayout.SOUTH, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, label_7);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("下班记录");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 上传下班记录
				 */
				// 上传下班记录
				Long ntime = System.currentTimeMillis() / 1000;
				String msg = "{\"service_name\":\"work_record\"," + "\"data_target\":\"cloud\"," + "\"user_id\":\""
						+ textField_2.getText() + "\","
				// + "\"start_time\":"+ntime+","
						+ "\"uuid\":\"" + Math.random() + "\"," + "\"end_time\":" + ntime + ","
				// + "\"worksite_id\":21,"
						+ "\"state\":1}";
				long intime = System.currentTimeMillis();
				System.out.println("请求数据下班>>>>>>>>>>>>>>>>>>>>>" + msg);
				String state = UploadUtil.uploadData(msg);
				long intimeback = System.currentTimeMillis();
				System.out.println("请求数据下班返回>>>>>>>>>>>>>>>>>>>>>" + state);
				System.out.println("下班时间间隔" + (intimeback - intime));
				// System.out.println("返回数据>>>>>>>>>>>>>>>>>>>>>"+result);

			}
		});
		springLayout.putConstraint(SpringLayout.WEST, button_3, 14, SpringLayout.EAST, button_2);
		springLayout.putConstraint(SpringLayout.SOUTH, button_3, 0, SpringLayout.SOUTH, btnNewButton_2);
		frame.getContentPane().add(button_3);

		JLabel label_17 = new JLabel("收费员编号");
		springLayout.putConstraint(SpringLayout.WEST, label_17, 106, SpringLayout.EAST, ed_scan);
		springLayout.putConstraint(SpringLayout.SOUTH, label_17, 0, SpringLayout.SOUTH, ed_scan);
		frame.getContentPane().add(label_17);

		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, label_17);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("优惠金额");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, ed_outChannelId);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, btnNewButton_6);
		frame.getContentPane().add(lblNewLabel_5);

		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 0, SpringLayout.NORTH, ed_outChannelId);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 20, SpringLayout.EAST, lblNewLabel_5);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		ticket_id = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ticket_id, 44, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.WEST, ticket_id, 23, SpringLayout.EAST, textField_3);
		frame.getContentPane().add(ticket_id);
		ticket_id.setColumns(10);

		edit_prepay = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, edit_prepay, -3, SpringLayout.NORTH, label_14);
		springLayout.putConstraint(SpringLayout.WEST, edit_prepay, 106, SpringLayout.EAST, ed_total);
		frame.getContentPane().add(edit_prepay);
		edit_prepay.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("预付");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, label_14);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, -6, SpringLayout.WEST, edit_prepay);
		frame.getContentPane().add(lblNewLabel_6);

		JButton btnNewButton_7 = new JButton("待支付");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carInList.get(selectionIndex).setLock(true);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_7, 0, SpringLayout.NORTH, button_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_7, 0, SpringLayout.WEST, btnNewButton_3);
		frame.getContentPane().add(btnNewButton_7);

		ed_uid_out = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ed_uid_out, 0, SpringLayout.NORTH, ed_uid);
		springLayout.putConstraint(SpringLayout.WEST, ed_uid_out, 6, SpringLayout.EAST, ed_uid);
		frame.getContentPane().add(ed_uid_out);
		ed_uid_out.setColumns(10);
		
		ed_total_now = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ed_total_now, -3, SpringLayout.NORTH, label_14);
		springLayout.putConstraint(SpringLayout.WEST, ed_total_now, 38, SpringLayout.EAST, edit_prepay);
		frame.getContentPane().add(ed_total_now);
		ed_total_now.setColumns(10);
		ed_scan.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				// 删除时监听
				System.out.println(ed_scan.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				// 输入时监听
				scancode = ed_scan.getText();
				if (scancode != null && scancode.length() > 0) {
					if (scancode.trim().length() == 18) {
						System.out.println("  18位了发起支付");
						carOut.setAuth_code(ed_scan.getText());
						carOut.setPay_type("sweepcode");
						carOut.setElectronic_pay(ed_total.getText());

						String msg = JSONObject.fromObject(carOut).toString();
						System.out.println(msg);
						String state = UploadUtil.uploadOutParkOrder(msg);
						System.out.println("扫码付结结果：" + state);

						if (getState(state) == 1) {
							SqliteJDBC.Delete(carOut.getOrder_id());
							System.out.println("扫码付结果：" + state + "出场成功！");
							// ShowDialog(ed_carnumber_out.getText() + "出场成功！");
							lblNewLabel_2.setText(ed_carnumber_out.getText() + "出场成功！扫码支付" + ed_total.getText() + "元");
						} else {
							System.out.println("扫码付结果：" + state + "出场失败！");
							// ShowDialog(ed_carnumber_out.getText() + "出场失败！");
							lblNewLabel_2.setText(ed_carnumber_out.getText() + "出场失败！");
						}
						clearOrder();
					}
				}
				// System.out.println(" " + System.currentTimeMillis());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println(ed_scan.getText());
			}
		});
		carInList.addAll(SqliteJDBC.Select());
		if (carInList != null && carInList.size() > 0) {
			String[] arr = new String[carInList.size()];
			for (int i = 0; i < carInList.size(); i++) {
				arr[i] = carInList.get(i).getCar_number();
			}
			jListModel = new DefaultComboBoxModel(arr); // 数据模型
			list.setModel(jListModel);
		}
		
		
		// 初始化
				textField.setText(U_ID);
				txtEadfeefefe.setText(UK);
				textField_1.setText(PARK_ID);
				txteztthbbzhogf.setText(CK);
				txtBengxiakalaka.setText(LOCAL_ID);
				
				textField_4 = new JTextField();
				springLayout.putConstraint(SpringLayout.NORTH, textField_4, 34, SpringLayout.SOUTH, button_1);
				springLayout.putConstraint(SpringLayout.WEST, textField_4, 31, SpringLayout.WEST, frame.getContentPane());
				springLayout.putConstraint(SpringLayout.SOUTH, textField_4, 195, SpringLayout.SOUTH, button_1);
				springLayout.putConstraint(SpringLayout.EAST, textField_4, 1, SpringLayout.EAST, ed_uid_out);
				frame.getContentPane().add(textField_4);
				textField_4.setColumns(10);
				
				JButton btnNewButton_8 = new JButton("send");
				btnNewButton_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String msg = textField_4.getText();
//						String msg = "{\"union_id\":\"" + textField.getText() + "\",\"ukey\":\"" + txtEadfeefefe.getText()
//						+ "\",\"park_id\":\"" + textField_1.getText() + "\",\"bport\":6789,\"cport\":6789,\"ckey\":\""
//						+ txteztthbbzhogf.getText()
//						+ "\",\"cloud_addr\":\"test.bolink.club\",\"bolink_addr\":\"beta.bolink.club\",\"local_id\":\""
//						+ txtBengxiakalaka.getText() + "\",\"log_show\":1}";
						System.out.println("send发送数据>>>>>>>>>>>>>>>>>>>>>" + msg);
						String state = UploadUtil.uploadData(msg);
						System.out.println("send返回数据>>>>>>>>>>>>>>>>>>>>>" + state);
					}
				});
				springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_8, 38, SpringLayout.SOUTH, btnNewButton);
				springLayout.putConstraint(SpringLayout.WEST, btnNewButton_8, 80, SpringLayout.EAST, textField_4);
				frame.getContentPane().add(btnNewButton_8);
				
				JButton btnNewButton_9 = new JButton("New button");
				frame.getContentPane().add(btnNewButton_9);
				
				JButton anti_init = new JButton("反初始化");
				anti_init.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						UploadUtil.unInit();
					}
				});
				springLayout.putConstraint(SpringLayout.NORTH, anti_init, 0, SpringLayout.NORTH, label_12);
				springLayout.putConstraint(SpringLayout.WEST, anti_init, 0, SpringLayout.WEST, textField);
				frame.getContentPane().add(anti_init);
	}

	int count = 0;
	String scancode = "";
	CarOutEntity carOut;
	private JTextField ed_orderId;
	private JTextField ed_emptyPlot;
	public static JTextField ed_uid;
	private JTextField ed_outChannelId;
	private JTextField textField;
	private JTextField txtEadfeefefe;
	private JTextField textField_1;
	private JTextField txteztthbbzhogf;
	private JTextField txtBengxiakalaka;
	private JTextField textField_2;
	public static JTextField textField_3;// 优惠金额
	public static JTextField ticket_id;// 优惠时长
	public static JTextField edit_prepay;// 预付
	private JTextField ed_uid_out;
	public static JTextField ed_total_now;
	private JTextField textField_4;

	private String getMsg(String msg) {
		JSONObject jsonInit = JSONObject.fromObject(msg);
		return jsonInit.getString("errmsg");
	}

	public static int getState(String msg) {
		JSONObject jsonInit = JSONObject.fromObject(msg);
		return jsonInit.getInt("state");
	}

	private String Obj2Json(Object obj) {
		return JSONObject.fromObject(obj).toString();
	}

	public static void ShowDialog(String msg) {
		JOptionPane.showMessageDialog(frame, msg, null, JOptionPane.INFORMATION_MESSAGE);
	}

	// @SuppressWarnings("unused")
	// private void OptionDialog() {
	// Object[] options = { "扫码", "现金" };
	// int response = JOptionPane.showOptionDialog(frame, "选择支付方式", "支付方式",
	// JOptionPane.YES_OPTION,
	// JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	// if (response == 0) {
	// System.out.println("点击了扫码 ");
	// ed_scan.setText("");
	// ed_scan.requestFocus();
	// } else if (response == 1) {
	// ed_scan.setText("");
	// System.out.println("点击了现金 ");
	// // carOut.setAuth_code(ed_scan.getText());
	// // carOut.setPay_type("kfcpay");
	// carOut.setPay_type("cash");
	// String msg = JSONObject.fromObject(carOut).toString();
	// System.out.println(msg);
	// String state = UploadUtil.uploadOutParkOrder(msg);
	// System.out.println("现金付结果：" + state);
	// if (getState(state) == 1) {
	// System.out.println("现金付结果：" + state + "出场成功！");
	// ShowDialog(ed_carnumber_out.getText() + "出场成功！");
	// lblNewLabel_2.setText(ed_carnumber_out.getText() + "出场成功！");
	// } else {
	// System.out.println("现金付结果：" + state + "出场失败！");
	// ShowDialog(ed_carnumber_out.getText() + "出场失败！");
	// lblNewLabel_2.setText(ed_carnumber_out.getText() + "出场失败！");
	// }
	// clearOrder();
	// }
	// }

	public static void clearOrder() {
		if (carInList != null && carInList.size() > 0) {
			for (int i = 0; i < carInList.size(); i++) {
				CarInEntity entity = carInList.get(i);
				if (ed_carnumber_out.getText().equals(entity.getCar_number())) {
					carInList.remove(i);
				}
				// arr[i] = entity.getCar_number();
			}
			String[] arr = new String[carInList.size()];
			for (int i = 0; i < carInList.size(); i++) {
				CarInEntity entity = carInList.get(i);
				arr[i] = entity.getCar_number();
			}
			jListModel = new DefaultComboBoxModel(arr); // 数据模型
			list.setModel(jListModel);
		}
	}

	class myDialog extends JDialog {
		public void Alert(String args) {
			JDialog jd = new JDialog(frame, "提示", true);
			java.awt.Container con = jd.getContentPane();
			con.add(new JLabel(args));
			con.setBounds(120, 120, 100, 100);
			con.setVisible(true);
			jd.setVisible(true);
		}
	}

	private String Unix2Str(long unix, int msOrun) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(unix * msOrun));
	}

	private long Str2Unix(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return Long.parseLong(String.valueOf(sdf.parse(date).getTime() / 1000));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	class myTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ed_intime.setText(Unix2Str(System.currentTimeMillis(), 1));
			// ed_outtime.setText(Unix2Str(System.currentTimeMillis(),1));
		}
	}
}
