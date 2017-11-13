package Bean;

public class LoginData{
	String union_id;
	String park_id;
	String local_id;
	
	
	@Override
	public String toString() {
		return "LoginData [union_id=" + union_id + ", park_id=" + park_id + ", local_id=" + local_id + "]";
	}
	public String getUnion_id() {
		return union_id;
	}
	public void setUnion_id(String union_id) {
		this.union_id = union_id;
	}
	public String getPark_id() {
		return park_id;
	}
	public void setPark_id(String park_id) {
		this.park_id = park_id;
	}
	public String getLocal_id() {
		return local_id;
	}
	public void setLocal_id(String local_id) {
		this.local_id = local_id;
	}
	
}