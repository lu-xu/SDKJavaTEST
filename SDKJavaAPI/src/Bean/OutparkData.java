package Bean;

public class OutparkData {
	/**
	 * "data":{"car_number":"¹ðFTL788",
	 * "in_time":1505794952,
	 * "out_time":1505795179,
	 * "total":"0.00",
	 * "order_id":"170919122231_101",
	 * "empty_plot":0,
	 * "park_id":"21827",
	 * "pay_type":"cash",
	 * "auth_code":""}
	 */
	String car_number;
	long in_time;
	long out_time;
	String total;
	String order_id;
	long empty_plot;
	String park_id;
	String pay_type;
	String auth_code;
	
	
	@Override
	public String toString() {
		return "OutparkData [car_number=" + car_number + ", in_time=" + in_time + ", out_time=" + out_time + ", total="
				+ total + ", order_id=" + order_id + ", empty_plot=" + empty_plot + ", park_id=" + park_id
				+ ", pay_type=" + pay_type + ", auth_code=" + auth_code + "]";
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	public long getIn_time() {
		return in_time;
	}
	public void setIn_time(long in_time) {
		this.in_time = in_time;
	}
	public long getOut_time() {
		return out_time;
	}
	public void setOut_time(long out_time) {
		this.out_time = out_time;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public long getEmpty_plot() {
		return empty_plot;
	}
	public void setEmpty_plot(long empty_plot) {
		this.empty_plot = empty_plot;
	}
	public String getPark_id() {
		return park_id;
	}
	public void setPark_id(String park_id) {
		this.park_id = park_id;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	
	
}
