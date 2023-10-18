package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CustomerDAO;
import model.Customers;

/**
 * Servlet implementation class DangNhap
 */
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		CustomerDAO cd = new CustomerDAO();
		Customers cus = cd.checkLogin(username, password);
		
		String url = "/TrangChu";
		boolean error = false;
//		if(username.equals(null) || password.equals(null)) {
//			error = true;
//			request.setAttribute("error_null", "Vui long nhap ten dang nhap va mat khau");
//		}
		if(cus != null) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", cus);
			
		}else {
			error = true;
			request.setAttribute("error_login", "Ten Dang Nhap Hoac Mat Khau Khong Dung");
		}
		if(error) {
			url="/dangnhap.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	}

}
