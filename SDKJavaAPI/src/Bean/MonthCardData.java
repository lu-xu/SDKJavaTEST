package Bean;

public class MonthCardData {
	/**
	 * "data":{"service_name":"monthcard_pay",
	 * "data_target":"bolink",
	 * "state":1,
	 * "trade_no":"20170919133619846921787",
	 * "errmsg":"月卡续费成功",
	 * "park_id":"21787",
	 * "pay_money":"0.01"}
	 */
	String service_name;
	String data_target;
	int state;
	String errmsg;
	
	String trade_no;
	String park_id;
	String pay_money;
	
	
	
	@Override
	public String toString() {
		return "MonthCardData [service_name=" + service_name + ", data_target=" + data_target + ", state=" + state
				+ ", errmsg=" + errmsg + ", trade_no=" + trade_no + ", park_id=" + park_id + ", pay_money=" + pay_money
				+ "]";
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
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getPark_id() {
		return park_id;
	}
	public void setPark_id(String park_id) {
		this.park_id = park_id;
	}
	public String getPay_money() {
		return pay_money;
	}
	public void setPay_money(String pay_money) {
		this.pay_money = pay_money;
	}
	
	
}
