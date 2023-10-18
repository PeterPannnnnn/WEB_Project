package model;

public class Products {
	private String productID;
	private String nameProductString;
	private String desriptionString;
	private double price;
	private String imageURL;
	private Categories categoryID;
	public Products(String productID, String nameProductString, String desriptionString, double price, String imageURL,
			Categories categoryID) {
		super();
		this.productID = productID;
		this.nameProductString = nameProductString;
		this.desriptionString = desriptionString;
		this.price = price;
		this.imageURL = imageURL;
		this.categoryID = categoryID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getNameProductString() {
		return nameProductString;
	}
	public void setNameProductString(String nameProductString) {
		this.nameProductString = nameProductString;
	}
	public String getDesriptionString() {
		return desriptionString;
	}
	public void setDesriptionString(String desriptionString) {
		this.desriptionString = desriptionString;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Categories getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Categories categoryID) {
		this.categoryID = categoryID;
	}
	@Override
	public String toString() {
		return "Products [productID=" + productID + ", nameProductString=" + nameProductString + ", desriptionString="
				+ desriptionString + ", price=" + price + ", imageURL=" + imageURL + ", categoryID=" + categoryID + "]";
	}
	
	
}
