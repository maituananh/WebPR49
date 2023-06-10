package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.Connect;
import model.User;

public class UserService {
	public static User findByUsernameAndPassword(String username, String password) {
		try {
			Connection conn = Connect.openConnect();
			PreparedStatement stmt = conn.prepareStatement("select `id`, `username`, `password` from users"
					+ " where `username` = ? and `password` = ?");
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				
				return user;
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
