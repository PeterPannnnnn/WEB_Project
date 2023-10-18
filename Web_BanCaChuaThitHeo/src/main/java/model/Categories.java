package model;

public class Categories {

	private String categoryID;
	private String nameCategory;
	public Categories(String categoryID, String nameCategory) {
		super();
		this.categoryID = categoryID;
		this.nameCategory = nameCategory;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategoryString) {
		this.nameCategory = nameCategoryString;
	}
	@Override
	public String toString() {
		return "Categories [categoryID=" + categoryID + ", nameCategory=" + nameCategory + "]";
	}
	
}
