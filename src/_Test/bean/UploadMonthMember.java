package _Test.bean;

public class UploadMonthMember {
	/**
	 * member_id	���	String	10093	��
create_time	�½�ʱ��	Number	1490875218	��
update_time	�޸�ʱ��	Number	1490879218	��
pid	�¿��ײͱ��	number	50	��
name	��������	String	����	��
car_number	����	String	��GH0093	��
price	�۸�	String	200.00	��
	 */
	String member_id;
	long create_time;
	long update_time;
	int pid;
	String name;
	String car_number;
	double price;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "UploadMonthMember [member_id=" + member_id + ", create_time=" + create_time + ", update_time="
				+ update_time + ", pid=" + pid + ", name=" + name + ", car_number=" + car_number + ", price=" + price
				+ "]";
	}
	
}
