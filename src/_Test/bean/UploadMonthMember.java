package _Test.bean;

public class UploadMonthMember {
	/**
	 * member_id	编号	String	10093	是
create_time	新建时间	Number	1490875218	否
update_time	修改时间	Number	1490879218	否
pid	月卡套餐编号	number	50	否
name	车主姓名	String	张三	否
car_number	车牌	String	京GH0093	是
price	价格	String	200.00	是
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
