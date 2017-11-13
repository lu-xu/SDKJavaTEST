package _Test.bean;

public class UpLoadTickets {
/**
 * ticket_id	编号	String	10022	是
create_time	新建时间	Number	1490879218	是
limit_day	有效期	Number	1490879218	是
operate_user	收费员	String	张三	否
money	金额	String	5.5	否
state	状态	String	已使用	否
car_number	车牌	String	京GH0093	是
use_time	使用时间	Number	1490879218	否
type	类型	String	购物优惠券	否
order_id	订单编号	String	9880	是
pay_money	使用金额	String	3.0	否
remark	备注	String	两小时内免3元	否
 */
	String ticket_id;
	long create_time;
	long limit_day;
	String operate_user;
	double money;
	String state;
	String car_number;
	long use_time;
	String type;
	String order_id;
	String pay_money;
	String remark;
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public long getLimit_day() {
		return limit_day;
	}
	public void setLimit_day(long limit_day) {
		this.limit_day = limit_day;
	}
	public String getOperate_user() {
		return operate_user;
	}
	public void setOperate_user(String operate_user) {
		this.operate_user = operate_user;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	public long getUse_time() {
		return use_time;
	}
	public void setUse_time(long use_time) {
		this.use_time = use_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getPay_money() {
		return pay_money;
	}
	public void setPay_money(String pay_money) {
		this.pay_money = pay_money;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "UpLoadTickets [ticket_id=" + ticket_id + ", create_time=" + create_time + ", limit_day=" + limit_day
				+ ", operate_user=" + operate_user + ", money=" + money + ", state=" + state + ", car_number="
				+ car_number + ", use_time=" + use_time + ", type=" + type + ", order_id=" + order_id + ", pay_money="
				+ pay_money + ", remark=" + remark + "]";
	}
	
}
