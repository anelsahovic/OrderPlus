package application;

public class Orders {

	int id;
	String customer, phone, imei, date;
	Float price, expences;
	public Orders(int id, String customer, String phone, String imei, String date, Float price, Float expences) {
		super();
		this.id = id;
		this.customer = customer;
		this.phone = phone;
		this.imei = imei;
		this.date = date;
		this.price = price;
		this.expences = expences;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getExpences() {
		return expences;
	}
	public void setExpences(Float expences) {
		this.expences = expences;
	}
	
	
	
}
