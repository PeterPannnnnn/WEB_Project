package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CategoriesDAO;
import database.ProductsDAO;
import model.Categories;
import model.Products;

/**
 * Servlet implementation class SanPhamTheoDanhMuc
 */
public class SanPhamTheoDanhMuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamTheoDanhMuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		CategoriesDAO cateDao = new CategoriesDAO();
		ArrayList<Categories> categories = cateDao.selectAll();
		
		ProductsDAO pdDAO = new ProductsDAO();
		ArrayList<Products> products = pdDAO.selectByCategoryid(id);
		
		request.setAttribute("products", products);
		
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/trangchu.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
