package Bean;

public class CodeUrlData {
	String service_name;
	int type;
	String channel_id;
	String data_target;
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getData_target() {
		return data_target;
	}
	public void setData_target(String data_target) {
		this.data_target = data_target;
	}
	@Override
	public String toString() {
		return "CodeUrlData [service_name=" + service_name + ", type=" + type + ", channel_id=" + channel_id
				+ ", data_target=" + data_target + "]";
	}
	
	
}
