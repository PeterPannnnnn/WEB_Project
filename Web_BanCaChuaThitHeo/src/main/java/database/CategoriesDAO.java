package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categories;
import utils.JDBCUtil;

public class CategoriesDAO implements InterfaceDAO<Categories> {

	
	@Override
	public boolean insert(Categories t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "insert into Categories values (?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getCategoryID());
			pst.setString(2, t.getNameCategory());
			
			pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Categories t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Categories t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Categories> selectAll() {
		ArrayList<Categories> categories = new ArrayList<Categories>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from Categories";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String categoryID = rs.getNString(1);
				String name = rs.getNString(2);
				
				Categories cate = new Categories(categoryID, name);
				categories.add(cate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public ArrayList<Categories> selectByID(String id) {
		ArrayList<Categories> categories = new ArrayList<Categories>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "Select * from Categories";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String categoryID = rs.getNString(1);
				String name = rs.getNString(2);
				
				Categories cate = new Categories(categoryID, name);
				categories.add(cate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public ArrayList<Categories> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public Categories selectByCondition(String condition) {
		
		Categories category = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from categories where nameCategory = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, condition);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String id = rs.getNString(1);
				String name = rs.getNString(2);
				category = new Categories(id, name);
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return category;
	}
	public static void main(String[] args) {
//		Categories ct1 = new Categories("C03", "Thực phẩm đông lạnh");
		CategoriesDAO cd = new CategoriesDAO();
//		System.out.println(cd.insert(ct1));
		
//		ArrayList<Categories> list = cd.selectAll();
//		for (Categories categories : list) {
//			System.out.println(categories.toString());
//		}
		
		Categories c = cd.selectByCondition("Thực phẩm đông lạnh");
		System.out.println(c.toString());
	}

}
