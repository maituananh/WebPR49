package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import config.Connect;
import model.Product;

public class ProductService {
	
	public static ArrayList<Product> findAllProducts() {
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
		
		return productList;
	}
	
	public static Product findById(int id) {
		Product product = new Product();
		
		try {
			Connection conn = Connect.openConnect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select `id`, `name`, `price`, `description`, `image` from products"
					+ " where id = " + id);
			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
//				product.setPrice(rs.getString("price"));
				product.setImage(rs.getString("image"));
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return product;
	}
	
	public static void saveProduct(Product product) {
		try {
			Connection conn = Connect.openConnect();
			PreparedStatement statement = conn.prepareStatement(
					"INSERT INTO products (name, price, image, description) "
					+ "VALUES (?, ?, ?, ?)");
			
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getImage());
			statement.setString(4, product.getDescription());
			
			statement.execute();
			
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
