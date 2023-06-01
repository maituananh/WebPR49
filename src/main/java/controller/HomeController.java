package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Connect;
import model.Product;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			Connection conn = Connect.openConnect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select `id`, `name`, `price`, `description`, `image` from products");
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
//				product.setPrice(rs.getString("price"));
				product.setImage(rs.getString("image"));
				
				productList.add(product);
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		request.setAttribute("ProductList", productList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}
}
