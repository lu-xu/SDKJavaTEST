package _Test.bean;

import java.io.Serializable;

public class CarOutEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String service_name;
	private String car_number;
	private long in_time;
	private String car_type;
	private String c_type;
	private String uid;
	private String out_uid;
	private String order_id;
	private int empty_plot;
	private String in_channel_id;
	private long out_time;
	private int duration;
	private String pay_type;
	private String auth_code;
	private String total;
	private String freereasons;
	private String out_channel_id;
	private String amount_receivable;
//	private String electronic_prepay;
//	private String 
	private String reduce_amount;
	private String ticket_id;
	private String electronic_pay;
	private String electronic_prepay;//����Ԥ��
	private String cash_prepay;//�ֽ�Ԥ֧��
	private String data_target;
	
	private String cash_pay;

	
	public String getCash_pay() {
		return cash_pay;
	}
	public void setCash_pay(String cash_pay) {
		this.cash_pay = cash_pay;
	}
	public String getCash_prepay() {
		return cash_prepay;
	}
	public void setCash_prepay(String cash_prepay) {
		this.cash_prepay = cash_prepay;
	}
	public String getData_target() {
		return data_target;
	}
	public void setData_target(String data_target) {
		this.data_target = data_target;
	}
	public String getElectronic_pay() {
		return electronic_pay;
	}
	public void setElectronic_pay(String electronic_pay) {
		this.electronic_pay = electronic_pay;
	}
	public String getElectronic_prepay() {
		return electronic_prepay;
	}
	public void setElectronic_prepay(String electronic_prepay) {
		this.electronic_prepay = electronic_prepay;
	}
	public String getReduce_amount() {
		return reduce_amount;
	}
	public void setReduce_amount(String reduce_amount) {
		this.reduce_amount = reduce_amount;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getOut_uid() {
		return out_uid;
	}
	public String getAmount_receivable() {
		return amount_receivable;
	}
	public void setAmount_receivable(String amount_receivable) {
		this.amount_receivable = amount_receivable;
	}
	public void setOut_uid(String out_uid) {
		this.out_uid = out_uid;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
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
	public long getOut_time() {
		return out_time;
	}
	public void setOut_time(long out_time) {
		this.out_time = out_time;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getFreereasons() {
		return freereasons;
	}
	public void setFreereasons(String freereasons) {
		this.freereasons = freereasons;
	}
	public String getOut_channel_id() {
		return out_channel_id;
	}
	public void setOut_channel_id(String out_channel_id) {
		this.out_channel_id = out_channel_id;
	}
	
	@Override
	public String toString() {
		return "CarOutEntity [service_name=" + service_name + ", car_number=" + car_number + ", in_time=" + in_time
				+ ", car_type=" + car_type + ", c_type=" + c_type + ", uid=" + uid + ", out_uid=" + out_uid
				+ ", order_id=" + order_id + ", empty_plot=" + empty_plot + ", in_channel_id=" + in_channel_id
				+ ", out_time=" + out_time + ", duration=" + duration + ", pay_type=" + pay_type + ", auth_code="
				+ auth_code + ", total=" + total + ", freereasons=" + freereasons + ", out_channel_id=" + out_channel_id
				+ ", amount_receivable=" + amount_receivable + ", reduce_amount=" + reduce_amount + ", ticket_id="
				+ ticket_id + ", electronic_pay=" + electronic_pay + ", electronic_prepay=" + electronic_prepay
				+ ", cash_prepay=" + cash_prepay + ", data_target=" + data_target + ", cash_pay=" + cash_pay + "]";
	}
	
	
}
