package com.exple.food.data;

public class foodType {
	private String name;
	private String price;
	
	public foodType(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getTitle() {
		return name;
	}
	public void setTitle(String title) {
		this.name = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "foodType [title=" + name + ", price=" + price + "]";
	}
	
	
}
