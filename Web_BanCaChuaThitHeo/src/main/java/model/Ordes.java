package model;

import java.sql.Date;

public class Ordes {
	private String orderID;
	private Customers customerID;
	private Date orderDate;
	private double totalAmount;
	public Ordes(String orderID, Customers customerID, Date orderDate, double totalAmount) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Customers getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Customers customerID) {
		this.customerID = customerID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
