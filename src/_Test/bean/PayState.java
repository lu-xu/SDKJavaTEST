package _Test.bean;

public class PayState {
/**
 * {"balance":"0","car_number":"½úAAAQAZ","errmsg":"",
 * "is_exist":0,"net_status":1,"order_id":"1494230327","service_name":"pay_status","state":1}
 */
	String balance;
	String car_number;
	String errmsg;
	String is_exist;
	String net_status;
	String service_name;
	int state;
	String order_id;
	
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getIs_exist() {
		return is_exist;
	}
	public void setIs_exist(String is_exist) {
		this.is_exist = is_exist;
	}
	public String getNet_status() {
		return net_status;
	}
	public void setNet_status(String net_status) {
		this.net_status = net_status;
	}

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "PayState [balance=" + balance + ", car_number=" + car_number + ", errmsg=" + errmsg + ", is_exist="
				+ is_exist + ", net_status=" + net_status + ", service_name=" + service_name + ", state=" + state
				+ ", order_id=" + order_id + "]";
	}
	
}
