package Bean;

public class  RequestEntity<T> {
	/**
	 * {"service_name":"login",
	 * "sign":"9A69C828BD5EDB4F945DF6C7DAE14D9F",
	 * "data":{
	 * 		"union_id":"200159",
	 * 		"park_id":"21787",
	 * 		"local_id":"c48e8f750e19_1001_guyue_achannels_B1_B2_A3_A1"}}
	 */
	String service_name;
	String sign;
	T data;
	String token;
	
	
	
	@Override
	public String toString() {
		return "RequestEntity [service_name=" + service_name + ", sign=" + sign + ", data=" + data + ", token=" + token
				+ "]";
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}



	
}
