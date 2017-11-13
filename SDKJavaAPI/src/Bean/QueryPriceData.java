package Bean;

public class QueryPriceData {
	/**
	 * "data":{"service_name":"query_price",
	 * "data_target":"bolink",
	 * "errmsg":"success",
	 * "state":1,
	 * "park_id":"3251",
	 * "order_id":"A1_2C1505800583",
	 * "price":"0.01",
	 * "duration":1,
	 * "free_out_time":100,
	 * "query_time":1505800598,
	 * "derate_money":"0.0",
	 * "derate_duration":"0.0",
	 * "total":"0.01",
	 * "query_order_no":"325120170919135855-367"}
	 */
	String service_name;
	String data_target;
	int state;
	String errmsg;
	
	String order_id;
	String park_id;
	String price;
	long duration;
	String total;
	long free_out_time;
	long query_time;
	String derate_money;
	String derate_duration;
	String query_order_no;
	
	
	
	@Override
	public String toString() {
		return "QueryPriceData [service_name=" + service_name + ", data_target=" + data_target + ", state=" + state
				+ ", errmsg=" + errmsg + ", order_id=" + order_id + ", park_id=" + park_id + ", price=" + price
				+ ", duration=" + duration + ", total=" + total + ", free_out_time=" + free_out_time + ", query_time="
				+ query_time + ", derate_money=" + derate_money + ", derate_duration=" + derate_duration
				+ ", query_order_no=" + query_order_no + "]";
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public long getFree_out_time() {
		return free_out_time;
	}
	public void setFree_out_time(long free_out_time) {
		this.free_out_time = free_out_time;
	}
	public long getQuery_time() {
		return query_time;
	}
	public void setQuery_time(long query_time) {
		this.query_time = query_time;
	}
	public String getDerate_money() {
		return derate_money;
	}
	public void setDerate_money(String derate_money) {
		this.derate_money = derate_money;
	}
	public String getDerate_duration() {
		return derate_duration;
	}
	public void setDerate_duration(String derate_duration) {
		this.derate_duration = derate_duration;
	}
	public String getQuery_order_no() {
		return query_order_no;
	}
	public void setQuery_order_no(String query_order_no) {
		this.query_order_no = query_order_no;
	}
	
	
}
