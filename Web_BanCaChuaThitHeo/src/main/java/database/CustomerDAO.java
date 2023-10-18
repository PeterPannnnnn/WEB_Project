package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customers;
import utils.JDBCUtil;

public class CustomerDAO implements InterfaceDAO<Customers>{

	@Override
	public boolean insert(Customers t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "insert into Customers values (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getNameCustomer());
			pst.setString(4, t.getNumberPhone());
			pst.setString(5, t.getEmail());
			pst.setString(6, t.getAddress());
			
			int i = pst.executeUpdate();
			if(i > 0)
				return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean update(Customers t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customers t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Customers> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customers> selectByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customers> selectByConditon(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public Customers checkUsernamePassword(String username) {
		Customers c = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from Customers Where username=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
		
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String user_name = rs.getString(1);
				String password_ = rs.getString(2);
				String nameCustomer_ = rs.getString(3);
				String numberPhone_ = rs.getString(4);
				String email = rs.getString(5);
				String address = rs.getString(6);
				
				c = new Customers(username, password_, nameCustomer_, numberPhone_, email, address);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	public Customers checkLogin(String username, String password) {
		Customers c = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from Customers Where username=? and password=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
		
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String user_name = rs.getString(1);
				String password_ = rs.getString(2);
				String nameCustomer_ = rs.getString(3);
				String numberPhone_ = rs.getString(4);
				String email = rs.getString(5);
				String address = rs.getString(6);
				
				c = new Customers(username, password_, nameCustomer_, numberPhone_, email, address);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	public static void main(String[] args) {
//		Customers c = new Customers("tuanphan123", "123321", "Phan Hai", "0345721233", "hoaciu@gmai.com", "HCM");
		CustomerDAO cd = new CustomerDAO();
//		System.out.println(cd.insert(c));
		System.out.println(cd.checkUsernamePassword("tuanphan123").toString());
		System.out.println(cd.checkLogin("tuanphan123", "123321").toString());
	}
	
}
