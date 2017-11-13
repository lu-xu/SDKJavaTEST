package Bean;

public class InparkData {
	/**
	 * "data":{"car_number":"¹ðA73K48",
	 * "in_time":1505792411,
	 * "order_id":"170919114010_101",
	 * "empty_plot":0,
	 * "park_id":"21827"}
	 */
	String car_number;
	String ddd;
	String car_type;
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	long in_time;
	String order_id;
	long empty_plot;
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	String park_id;
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
	@Override
	public String toString() {
		return "InparkData [car_number=" + car_number + ", in_time=" + in_time + ", order_id=" + order_id
				+ ", empty_plot=" + empty_plot + ", park_id=" + park_id + "]";
	}
	
}
