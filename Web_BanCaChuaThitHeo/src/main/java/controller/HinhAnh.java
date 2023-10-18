package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class HinhAnh
 */
@MultipartConfig
public class HinhAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HinhAnh() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			String name = request.getParameter("tenAnh");
			Part part = request.getPart("img");
			
			String realPath = request.getServletContext().getRealPath("/images");
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
				
			}
			part.write(realPath+"/"+fileName);
			try(PrintWriter out = response.getWriter()) {
				out.print("<h2>name: "+ name +"</h2>");
				out.print("<img src='images/"+fileName+"'>");
			} catch (Exception e) {
				System.out.println("Thai bai 1");
			}
		} catch (Exception e) {
			System.out.println("That bai 2");
		}
	}

}
