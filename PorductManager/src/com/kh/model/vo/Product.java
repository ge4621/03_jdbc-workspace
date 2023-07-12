package com.kh.model.vo;

public class Product {

	private String productId;
	private String productName;
	private int price;
	private String address;
	private int stock;
	
	public Product() {}

	public Product(String productId, String productName, int price, String address, int stock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.address = address;
		this.stock = stock;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", address="
				+ address + ", stock=" + stock + "]";
	}
	
	

}
