package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import database.CategoriesDAO;
import database.CustomerDAO;
import database.ProductsDAO;
import model.Categories;
import model.Customers;
import model.Products;

/**
 * Servlet implementation class ThemSanPham
 */
@MultipartConfig
public class ThemSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoriesDAO cateDao = new CategoriesDAO();
		ArrayList<Categories> categories = cateDao.selectAll();

		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/themsanpham.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String fileName = "";
		try {

			Part part = request.getPart("img");

			String realPath = request.getServletContext().getRealPath("/images");
			fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));

			}

			part.write(realPath + "/" + fileName);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		String productID = request.getParameter("productID");
		String nameProduct = request.getParameter("productName");
		String description = request.getParameter("description");
		String pricePara = request.getParameter("price");
		String image = "images/" + fileName;
		String[] category = request.getParameterValues("category");
		String categoryName = category[0];
		
		System.out.println(categoryName.toString());

		double price = Double.parseDouble(pricePara);

		CategoriesDAO cad = new CategoriesDAO();
		Categories cate = cad.selectByCondition(categoryName);
		ProductsDAO pd = new ProductsDAO();
		Products product = new Products(productID, nameProduct, description, price, image, cate);
		pd.insert(product);

		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}
	

}
