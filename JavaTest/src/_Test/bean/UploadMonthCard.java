package _Test.bean;

public class UploadMonthCard {
	/**
	 * card_id	���	String	10093	��
create_time	�½�ʱ��	Number	1490875218	��
update_time	�޸�ʱ��	Number	1490879218	��
describe	�¿��ײ�����˵��	String	�¿��۸�400Ԫ����ʼʱ��8��...	��
price	�¿��۸�	number	200.00	��
name	�¿�����	String	�����ײ�һ	��
operate_type	�ϴ�����	number	1��ʾ��ӣ�2��ʾ���£�3��ʾɾ��	��
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
