package _Test.bean;

import java.io.Serializable;

public class CarInEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String car_number;
	private long in_time;
	private String car_type;
	private String c_type;
	private String uid;
	private String order_id;
	private int empty_plot;
	private String in_channel_id;
	private String prepay;
	private String prepay_cash;
	//�Ż�ȯ ������ Сʱ����Ľ��
	private String coupon;
	private String coupon_type;
	private String couponid;
	//����״̬���Ƿ�����
	private boolean isLock;
	
	
	public String getPrepay_cash() {
		return prepay_cash;
	}
	public void setPrepay_cash(String prepay_cash) {
		this.prepay_cash = prepay_cash;
	}
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
				+ in_channel_id + ", prepay=" + prepay + ", prepay_cash=" + prepay_cash + ", coupon=" + coupon
				+ ", coupon_type=" + coupon_type + ", couponid=" + couponid + ", isLock=" + isLock + "]";
	}
	
	
}
