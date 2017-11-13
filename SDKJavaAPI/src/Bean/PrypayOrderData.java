package Bean;

public class PrypayOrderData {
	/**
	 * "data":{"prepay":"5",
	 * "order_id":"170915144221_101",
	 * "park_id":"21823",
	 * "service_name":"prepay_order",
	 * "data_target":"bolink",
	 * "state":1,
	 * "errmsg":"success"}
	 */
	int state;
	String errmsg;
	String service_name;
	String data_target;
	Double prepay;
	String car_number;
	
	String order_id;
	String park_id;
	
	@Override
	public String toString() {
		return "PrypayOrderData [state=" + state + ", errmsg=" + errmsg + ", service_name=" + service_name
				+ ", data_target=" + data_target + ", prepay=" + prepay + ", car_number=" + car_number + ", order_id="
				+ order_id + ", park_id=" + park_id + "]";
	}
	public Double getPrepay() {
		return prepay;
	}
	public void setPrepay(Double prepay) {
		this.prepay = prepay;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getData_target() {
		return data_target;
	}
	public void setData_target(String data_target) {
		this.data_target = data_target;
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getPark_id() {
		return park_id;
	}
	public void setPark_id(String park_id) {
		this.park_id = park_id;
	}
	
	
}
