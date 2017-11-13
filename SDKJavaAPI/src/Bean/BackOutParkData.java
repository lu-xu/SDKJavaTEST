package Bean;

public class BackOutParkData {
	
	Integer state;
	String trade_no;
	String errmsg;
	String order_id;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	@Override
	public String toString() {
		return "BackOutParkData [state=" + state + ", trade_no=" + trade_no + ", errmsg=" + errmsg + ", order_id="
				+ order_id + "]";
	}
	
}
