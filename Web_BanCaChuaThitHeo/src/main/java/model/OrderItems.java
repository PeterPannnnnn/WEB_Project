package model;

public class OrderItems {
	private String orderItemID;
	private Ordes orderID;
	private Products productID;
	private int quantity;
	public OrderItems(String orderItemID, Ordes orderID, Products productID, int quantity) {
		super();
		this.orderItemID = orderItemID;
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
	}
	public String getOrderItemID() {
		return orderItemID;
	}
	public void setOrderItemID(String orderItemID) {
		this.orderItemID = orderItemID;
	}
	public Ordes getOrderID() {
		return orderID;
	}
	public void setOrderID(Ordes orderID) {
		this.orderID = orderID;
	}
	public Products getProductID() {
		return productID;
	}
	public void setProductID(Products productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
