package _Test.bean;

public class UploadMonthCard {
	/**
	 * card_id	编号	String	10093	是
create_time	新建时间	Number	1490875218	否
update_time	修改时间	Number	1490879218	否
describe	月卡套餐描述说明	String	月卡价格400元，开始时间8点...	否
price	月卡价格	number	200.00	是
name	月卡名称	String	包月套餐一	否
operate_type	上传类型	number	1表示添加，2表示更新，3表示删除	是
	 */
	String card_id;
	long create_time;
	long update_time;
	String describe;
	double price;
	String name;
	int operate_type;
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
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
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOperate_type() {
		return operate_type;
	}
	public void setOperate_type(int operate_type) {
		this.operate_type = operate_type;
	}
	@Override
	public String toString() {
		return "UploadMonthCard [card_id=" + card_id + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", describe=" + describe + ", price=" + price + ", name=" + name + ", operate_type=" + operate_type
				+ "]";
	}
	
}
