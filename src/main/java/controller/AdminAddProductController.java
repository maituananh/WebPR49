package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductService;

@WebServlet("/admin-add-product")
public class AdminAddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminAddProduct.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("price"));
		System.out.println(request.getParameter("imageUrl"));
		System.out.println(request.getParameter("description"));
		
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Double.valueOf(request.getParameter("price")));
		product.setImage(request.getParameter("imageUrl"));
		product.setDescription(request.getParameter("description"));
		
		ProductService.saveProduct(product);
		
		response.sendRedirect("admin-home");
	}
}
