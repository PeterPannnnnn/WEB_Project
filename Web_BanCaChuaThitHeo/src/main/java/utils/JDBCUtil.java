package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	private final static String server ="DESKTOP-RRE6GOE\\SQLEXPRESS";
	private final static String port = "1433";
	private final static String databaseName = "KetNoiCSDL";
	private final static String username = "sa";
	private final static String password = "123456";
	
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=WebBanHang;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true";
			
			
			
			try {
				c = DriverManager.getConnection(url,username, password);
				System.out.println("ket noi thanh cong");
			} catch (SQLException e) {
				System.out.println("That BAi");
				e.printStackTrace();
			}
			
			
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return c;
	}
	public static void closeConnection(Connection c) {
		
			try {
				if(c!=null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		JDBCUtil jd = new JDBCUtil();
		jd.getConnection();
	}
}
