package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDAO;
import model.Customers;

/**
 * Servlet implementation class DangKiTaiKhoan
 */
public class DangKiTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKiTaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm-password");
		String fullName = request.getParameter("full-name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("confirm-password", confirmPassword);
		request.setAttribute("fullName", fullName);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("address", address);
		
		String url = "";

		CustomerDAO cd = new CustomerDAO();
		Customers customer = cd.checkUsernamePassword(username);
		boolean error = false;
		if (customer != null) {
			if (username.equals(customer.getUsername())) {
				request.setAttribute("err_username", "Ten dang nhap da ton tai, vui long chon ten khac");
				url = "/dangkitaikhoan.jsp";
				error = true;
			}

		}
		if (!password.equals(confirmPassword)) {
			request.setAttribute("err_password", "Nhap Mat Khau Khong Khop");
			url = "/dangkitaikhoan.jsp";
			error = true;
		}
		if (!error) {
			Customers cus = new Customers(username, password, fullName, phone, email, address);
			cd.insert(cus);
			url = "/dangkithanhcong.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
