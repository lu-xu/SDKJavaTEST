package _Test.bean;

import java.io.Serializable;

public class CarInEntity implements Serializable{
	/**
	 * 
	 * car_number	车牌	String	京GH0093
in_time	进场时间	Number	1490875218
car_type	车型	String	小型车
c_type	进场类型（月卡..）	String	普通入场或月卡等
uid	收费员	Number	880099
order_id	订单记录号	String	20033
empty_plot	空闲车位数	Number	20
in_channel_id	进场通道	String	A1

返回
名称	说明	类型	示例
state	状态 	Numuber	0失败1成功
errmsg	错误提示	String	
	 */
	private String car_number;
	private long in_time;
	private String car_type;
	private String c_type;
	private String uid;
	private String order_id;
	private int empty_plot;
	private String in_channel_id;
	private String prepay;
	//优惠券 金额或者 小时折算的金额
	private String coupon;
	private String coupon_type;
	private String couponid;
	//结算状态，是否锁定
	private boolean isLock;
	
	
	public boolean isLock() {
		return isLock;
	}
	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}
	public String getCouponid() {
		return couponid;
	}
	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}
	public String getCoupon_type() {
		return coupon_type;
	}
	public void setCoupon_type(String coupon_type) {
		this.coupon_type = coupon_type;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getPrepay() {
		return prepay;
	}
	public void setPrepay(String prepay) {
		this.prepay = prepay;
	}
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
	
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getEmpty_plot() {
		return empty_plot;
	}
	public void setEmpty_plot(int empty_plot) {
		this.empty_plot = empty_plot;
	}
	public String getIn_channel_id() {
		return in_channel_id;
	}
	public void setIn_channel_id(String in_channel_id) {
		this.in_channel_id = in_channel_id;
	}
	@Override
	public String toString() {
		return "CarInEntity [car_number=" + car_number + ", in_time=" + in_time + ", car_type=" + car_type + ", c_type="
				+ c_type + ", uid=" + uid + ", order_id=" + order_id + ", empty_plot=" + empty_plot + ", in_channel_id="
				+ in_channel_id + ", prepay=" + prepay + ", coupon=" + coupon + ", coupon_type=" + coupon_type + "]";
	}
	
	
}
