package Bean;

public class CarBalance {
	String service_name;
	String car_number;
	String balance;
	
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
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "CarBalance [service_name=" + service_name + ", car_number=" + car_number + ", balance=" + balance + "]";
	}
	
	
	
}
