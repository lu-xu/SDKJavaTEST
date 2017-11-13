package Bean;

public class NolicenceData {
	/**
	 * "data":{"car_number":"FD45E6A",
	 * "service_name":"nolicence_in_park",
	 * "data_target":"bolink",
	 * "state":1,
	 * "errmsg":""}
	 */
	String car_number;
	
	String service_name;
	String data_target;
	int state;
	String errmsg;
	
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
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
	@Override
	public String toString() {
		return "NolicenceData [car_number=" + car_number + ", service_name=" + service_name + ", data_target="
				+ data_target + ", state=" + state + ", errmsg=" + errmsg + "]";
	}
	
}
