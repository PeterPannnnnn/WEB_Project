package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.Categories;
import model.Products;
import utils.JDBCUtil;

public class ProductsDAO implements InterfaceDAO<Products>{

	@Override
	public boolean insert(Products t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Insert into Products values (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, t.getProductID());
			pst.setString(2, t.getNameProductString());
			pst.setString(3, t.getDesriptionString());
			pst.setString(4, String.valueOf(t.getPrice()));
			pst.setString(5, t.getImageURL());
			pst.setString(6, t.getCategoryID().getCategoryID());
			
			pst.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Products t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Products t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Products> selectAll() {
		ArrayList<Products> products = new ArrayList<Products>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from Products";
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			CategoriesDAO cado = new CategoriesDAO();
			while(rs.next()) {
				String id = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);
				
				Categories c = cado.selectByCondition(cateID);
				
				Products p = new Products(id, name, description, price, img, c);
				
				products.add(p);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ArrayList<Products> selectByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Products> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Products> selectByCategoryid(String idCate) {
		ArrayList<Products> products = new ArrayList<Products>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from Products where categoryID =?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, idCate);
			ResultSet rs = pst.executeQuery();
			
			CategoriesDAO cado = new CategoriesDAO();
			while(rs.next()) {
				String id = rs.getNString(1);
				String name = rs.getNString(2);
				String description = rs.getNString(3);
				double price = rs.getFloat(4);
				String img = rs.getNString(5);
				String cateID = rs.getNString(6);
				
				Categories c = cado.selectByCondition(cateID);
				
				Products p = new Products(id, name, description, price, img, c);
				
				products.add(p);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	public static void main(String[] args) {
//		Categories ct1 = new Categories("C03", "Thực phẩm đông lạnh");
//		Products pd = new Products("c1", "ca chua", " ca chua rat ngon", 3000, "hinhanh/a", ct1);
		ProductsDAO pda = new ProductsDAO();
//		System.out.println(pda.insert(pd));
//		
//		ArrayList<Products> p = pda.selectAll();
//		for (Products product
//				: p) {
//			System.out.println(product.toString());
//		}
		ArrayList<Products> p = pda.selectByCategoryid("C01");
		for (Products product
				: p) {
			System.out.println(product.toString());
		}
		
	}

}
