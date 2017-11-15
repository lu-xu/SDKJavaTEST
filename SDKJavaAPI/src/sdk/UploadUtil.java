package sdk;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Bean.*;
import http.HttpProxy;
import http.MD5Utils;

public class UploadUtil {
	// static {
	// Environment.LoadDll();
	// }
	// 本地
	// public static final String URL = "http://192.168.199.122/bpd/upload.do";
	// public static final String URL_INTETAL =
	// "http://192.168.199.122/bpd/download.do";

	// beta地址
	// public static final String URL =
	// "http://beta.bolink.club/unionapi/upload.do";
	// public static final String URL_INTETAL =
	// "http://beta.bolink.club/unionapi/download.do";
	public static final String URL = "http://120.25.207.105/bpd/upload.do";
	public static final String URL_INTETAL = "http://120.25.207.105/bpd/download.do";

	// 姚经理地址
	// public static final String URL = "http://192.168.199.122/bpd/upload.do";
	// public static final String URL_INTETAL =
	// "http://192.168.199.122/bpd/download.do";

	public static InterfacePark intefaces;
	public static String token;
	public static String ukey;
	public static String park_id;

	public static List<CarBalance> balanceList = new ArrayList<CarBalance>();

	/**
	 * @brief 初始化停车场SDK，必须在调用下面的方法之前调用。
	 * @param [IN]
	 *            strJsonData 初始化需要的Json格式字符串
	 * @return 初始化结果的Json格式字符串(使用完须释放空间)
	 */
	public static String init(String strJsonData) {
		System.out.println("初始化=>" + strJsonData);
		JsonObject o = new JsonParser().parse(strJsonData).getAsJsonObject();
		LoginData data = new LoginData();
		data.setLocal_id(o.get("local_id").getAsString());
		data.setPark_id(o.get("park_id").getAsString());
		data.setUnion_id(o.get("union_id").getAsString());
		ukey = o.get("ukey").getAsString();
		park_id = o.get("park_id").getAsString();
		return RequetData("login", data);
		// return HttpProxy.doHeadPost(URL,null,requetstr);
		// return UploadUtilNative.jni_Init(strJsonData);
	}

	/**
	 * @brief 发送车辆进场订单
	 * @param [IN]
	 *            strJsonData 发送给停车场SDK的Json格式字符串
	 * @return 车辆进场结果的Json格式字符串(使用完须释放空间)
	 */
	public static String uploadInParkOrder(String strJsonData) {
		Gson gson = new Gson();
		RequestEntity entity = new RequestEntity();

		InparkData data = new InparkData();
		JsonObject o = new JsonParser().parse(strJsonData).getAsJsonObject();
		data.setCar_number(o.get("car_number").getAsString());
		data.setEmpty_plot(o.get("empty_plot").getAsLong());
		data.setIn_time(o.get("in_time").getAsLong());
		data.setOrder_id(o.get("order_id").getAsString());
		// data.setPark_id(o.get("park_id").getAsString());
		data.setPark_id(park_id);
		data.setDdd("ddd");
		data.setCar_type("aa-A_中型车");
		System.out.println("inpark upload msg:" + data.toString());
		return RequetData("inpark", data);
		// return UploadUtilNative.jni_UploadInParkOrder(strJsonData);
	}

	/**
	 * @brief 发送车辆出场订单
	 * @param [IN]
	 *            strJsonData 发送给停车场SDK的Json格式字符串
	 * @return 车辆出场结果的Json格式字符串(使用完须释放空间)
	 */
	public static String uploadOutParkOrder(String strJsonData) {
		OutparkData data = new OutparkData();
		JsonObject o = new JsonParser().parse(strJsonData).getAsJsonObject();
		data.setCar_number(o.get("car_number").getAsString());
		data.setEmpty_plot(o.get("empty_plot").getAsLong());
		data.setIn_time(o.get("in_time").getAsLong());
		data.setOrder_id(o.get("order_id").getAsString());
		// data.setPark_id(o.get("park_id").getAsString());
		data.setPark_id(park_id);

		data.setAuth_code(o.get("auth_code").getAsString());
		data.setOut_time(o.get("out_time").getAsLong());
		data.setPay_type(o.get("pay_type").getAsString());
		data.setTotal(o.get("total").getAsString());

		System.out.println("outpark upload msg:" + data.toString());

		return RequetData("outpark", data);
		// return HttpProxy.doHeadPost(URL,null,gson.toJson(entity));
		// return UploadUtilNative.jni_UploadOutParkOrder(strJsonData);
	}

	/**
	 * @brief 获取订单支付状态信息
	 * @param [IN]
	 *            strJsonData 发送给停车场SDK的Json格式字符串
	 * @return 车辆订单状态信息结果的Json格式字符串(使用完须释放空间)
	 */
	public static String getPayStatus(String strJsonData) {
		CarBalanceResult result = new CarBalanceResult();
		JsonObject o = new JsonParser().parse(strJsonData).getAsJsonObject();
		// {"balance":"0","car_number":"晋AAAQAZ","errmsg":"","is_exist":0,"net_status":1,
		// "order_id":"1494230327","service_name":"pay_status","state":1}
		String car_number = o.get("car_number").getAsString();
		result.setBalance("0");
		result.setState(0);
		result.setIs_exist(0);
		if(balanceList.size()>0){
			for(CarBalance c:balanceList){
				if(car_number.equals(c.getCar_number())){
					result.setBalance(c.getBalance());
					result.setState(1);
					result.setIs_exist(1);
				}
			}
		}
		result.setCar_number(car_number);
		result.setErrmsg("API 返回的查询余额结果");
		result.setNet_status(1);
		result.setOrder_id(o.get("order_id").getAsString());
		result.setService_name("service_name");
		return new Gson().toJson(result);
//		return UploadUtilNative.jni_GetPayStatus(strJsonData);
	}

	/**
	 * @brief 注册获取SDK发送到停车场消息的接口类型实例
	 * @param [IN]
	 *            interfacePark 接口类型实例
	 * @exception 设置的实例需要保证在使用期间不被释放
	 */
	public static void setInterfacePark(final InterfacePark interfacePark) {
		intefaces = interfacePark;
	}

	public static void getDataFromServer(final InterfacePark interfacePark) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("开始查询消息");
				while (true) {
					String result = RequetDataInteval();
					if (result != null && result.contains("service_name")) {
						//如果是更新余额，就在这里处理放入缓存list，getPayStatus的时候返回
						if (result.contains("update_balance")) {
							CarBalance carBalance = new Gson().fromJson(result, CarBalance.class);
							if (balanceList.size() > 0) {
								for (int i = 0; i < balanceList.size(); i++) {
									CarBalance b = balanceList.get(i);
									if (b.getCar_number().equals(carBalance.getCar_number())) {
										// 如果车牌号相同，则更新余额
										balanceList.set(i, carBalance);
									}
								}
							} else {
								balanceList.add(carBalance);
							}
						} else {
							interfacePark.receive(result);
						}

					}
					System.out.println("一次查询结束");
				}
			}
		}).start();
	}

	/**
	 * @brief 回调函数中处理SDK消息后需要返回给SDK消息时的调用方法
	 * @param [IN]
	 *            strJsonData 发送给停车场SDK的Json格式字符串
	 * @return 返回给停车场的Json格式字符串(使用完须释放空间)
	 */
	public static String uploadData(String strJsonData) {
		JsonObject o = new JsonParser().parse(strJsonData).getAsJsonObject();
		String service_name = o.get("service_name").getAsString();
		if ("nolicence_in_park".equals(service_name)) {
			NolicenceData data = new NolicenceData();

			data.setData_target(o.get("data_target").getAsString());
			data.setErrmsg(o.get("errmsg").getAsString());
			data.setService_name(service_name);
			data.setState(o.get("state").getAsInt());

			data.setCar_number(o.get("car_number").getAsString());

			System.out.println("upload nolicence_in_park:" + data.toString());

			return RequetData(service_name, data);
		} else if ("prepay_order".equals(service_name)) {
			PrypayOrderData data = new PrypayOrderData();
			data.setData_target(o.get("data_target").getAsString());
			data.setErrmsg(o.get("errmsg").getAsString());
			data.setService_name(service_name);
			data.setPrepay(o.get("prepay").getAsDouble());
			data.setState(o.get("state").getAsInt());
			data.setOrder_id(o.get("order_id").getAsString());
			// data.setPark_id(o.get("park_id").getAsString());
			data.setPark_id(park_id);

			System.out.println("upload prepay_order:" + data.toString());

			return RequetData(service_name, data);
		} else if ("monthcard_pay".equals(service_name)) {
			MonthCardData data = new MonthCardData();
			data.setData_target(o.get("data_target").getAsString());
			data.setErrmsg(o.get("errmsg").getAsString());
			data.setService_name(service_name);
			data.setState(o.get("state").getAsInt());
			data.setPark_id(park_id);
			data.setTrade_no(o.get("trade_no").getAsString());
			data.setPay_money(o.get("pay_money").getAsString());

			System.out.println("upload monthcard_pay:" + data.toString());

			return RequetData(service_name, data);
		} else if ("query_price".equals(service_name)) {
			QueryPriceData data = new QueryPriceData();
			data.setData_target(o.get("data_target").getAsString());
			if (o.has("errmsg")) {
				System.out.println(">>" + o.get("errmsg") + "<<");
				String errmsg = "" + o.get("errmsg");
				if (!errmsg.equals("null"))
					data.setErrmsg(o.get("errmsg").getAsString());
				else
					data.setErrmsg("");
			}
			data.setService_name(service_name);
			data.setState(o.get("state").getAsInt());

			data.setOrder_id(o.get("order_id").getAsString());
			data.setPark_id(park_id);
			if (o.has("derate_duration")) {
				data.setDerate_duration(o.get("derate_duration").getAsString());
			}
			if (o.has("derate_money")) {
				data.setDerate_money(o.get("derate_money").getAsString());
			}
			data.setDuration(o.get("duration").getAsLong());
			if (o.has("free_out_time")) {
				data.setFree_out_time(o.get("free_out_time").getAsLong());
			}
			data.setPrice(o.get("price").getAsString());
			if (o.has("query_order_no")) {
				data.setQuery_order_no(o.get("query_order_no").getAsString());
			}
			if (o.has("query_time")) {
				data.setQuery_time(o.get("query_time").getAsLong());
			}
			if (o.has("total")) {
				data.setTotal(o.get("total").getAsString());
			}

			System.out.println("upload query_price:" + data.toString());

			return RequetData(service_name, data);
		} else if ("outpark".equals(service_name)) {
			BackOutParkData data = new BackOutParkData();
			data.setState(1);
			data.setTrade_no(o.get("trade_no").getAsString());
			data.setOrder_id(o.get("order_id").getAsString());
			data.setErrmsg("收到出场直付支付结果");

			System.out.println("upload outpark:" + data.toString());

			return RequetData(service_name, data);
		} else {
			System.out.println("noneeeeeeeee:");

			return "{\"state\":0,\"errmsg\":\"没有这个接口，别试了，具体有什么问权浩\"}";
		}

		// return HttpProxy.doHeadPost(URL,null,gson.toJson(entity));
		// return UploadUtilNative.jni_UploadData(strJsonData);
	}

	public static <T> String RequetData(String service_name, T data) {
		Gson gson = new Gson();
		RequestEntity entity = new RequestEntity();
		try {
			entity.setService_name(service_name);
			entity.setToken(token);
			entity.setData(data);
			entity.setSign(MD5Utils.MD5(gson.toJson(data) + "key=" + ukey).toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result = HttpProxy.doHeadPost(URL, null, gson.toJson(entity));
		System.out.println(">>>>获取到同步下行数据>>>>" + result);
		if (result != null && !"".equals(result)) {
			JsonObject retData = new JsonParser().parse(result).getAsJsonObject();
			if ("login".equals(service_name)) {
				if (retData.get("state").getAsInt() == 1) {
					token = retData.get("token").getAsString();
					// 开启循环获取车场下行数据的线程
					getDataFromServer(intefaces);
				} else {
					System.out.println("登录失败=>" + retData.get("errmsg").getAsString());
				}
			}
		}
		return result;
	}

	public static <T> String RequetDataInteval() {
		String result = HttpProxy.doHeadPost(URL_INTETAL, null, "{\"token\":\"" + token + "\"}");
		if ("500".equals(result)) {
			result = "暂无下行消息";
		}
		System.out.println(">>>>获取到异步下行数据>>>>" + result);
		return result;
	}

	public static void unInit() {

	}
}
