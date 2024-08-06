package application;

public class Inventory {

	int id;
	String Manufactor, Model, Color, Battery, imei, storage, date, availability;
	float price;
	public Inventory(int id, String manufactor, String model, String color, String battery, String imei, String storage,
			float price, String date, String availability) {
		
		this.id = id;
		Manufactor = manufactor;
		Model = model;
		Color = color;
		Battery = battery;
		this.imei = imei;
		this.storage = storage;
		this.date = date;
		this.availability = availability;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManufactor() {
		return Manufactor;
	}
	public void setManufactor(String manufactor) {
		Manufactor = manufactor;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getBattery() {
		return Battery;
	}
	public void setBattery(String battery) {
		Battery = battery;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String ime) {
		this.imei = ime;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
