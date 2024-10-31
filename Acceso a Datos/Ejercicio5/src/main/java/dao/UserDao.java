package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.User;


public class UserDao {

	public Long insert(Connection conn, User user) throws SQLException {

		String sql = "INSERT INTO users (username, password, user_email, created_at, last_login_at) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, user.getUsername());
	        stmt.setString(2, user.getPassword());
	        stmt.setString(3, user.getUserEmail());
	        stmt.setDate(4, Date.valueOf(user.getCreatedAt()));
	        stmt.setDate(5, Date.valueOf(user.getLastLoginAt()));
	        stmt.executeUpdate();  
	        
	        try (ResultSet rs = stmt.getGeneratedKeys()) {
	            if (rs.next()) {
	                return rs.getLong(1);
	            } else {
	                return null; 
	            }
	        }
	    }
	}
	
	
	public User consultEmail(Connection conn, String userEmail) throws SQLException {
	    String sql = "SELECT * FROM users WHERE user_email = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, userEmail);  
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {  
	            User user = new User();
	            user.setUserId(rs.getLong("user_id"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setUserEmail(rs.getString("user_email"));
	            user.setCreatedAt(rs.getDate("created_at").toLocalDate());
	            user.setLastLoginAt(rs.getDate("last_login_at").toLocalDate());
	            return user;
	        } else {
	            return null; 
	        }
	    }
	}
	
	public User consultId(Connection conn, Long userId) throws SQLException {
	    String sql = "SELECT * FROM users WHERE user_id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)){
	        stmt.setLong(1, userId); 
	        ResultSet rs = stmt.executeQuery();
	        User user = new User();
	        if(rs.next()) {    
	            user.setUserId(rs.getLong("user_id"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setUserEmail(rs.getString("user_email"));
	            user.setCreatedAt(rs.getDate("created_at").toLocalDate());
	            user.setLastLoginAt(rs.getDate("last_login_at").toLocalDate());
	            return user;
	        } else {
	            return null;
	        }
	    }
	}

	
	public User consultUsername(Connection conn, String username) throws SQLException {
	    String sql = "SELECT * FROM users WHERE username = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, username);  
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {  
	            User user = new User();
	            user.setUserId(rs.getLong("user_id"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setUserEmail(rs.getString("user_email"));
	            user.setCreatedAt(rs.getDate("created_at").toLocalDate());
	            user.setLastLoginAt(rs.getDate("last_login_at").toLocalDate());
	            return user;
	        } else {
	            return null; 
	        }
	    }
	}
	
	public void update(Connection conn, User user) throws SQLException{
		String sql = "UPDATE users SET username = ?, password = ?, user_email = ?, created_at = ?, last_login_at = ? WHERE user_id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, user.getUsername());
	        stmt.setString(2, user.getPassword());
	        stmt.setString(3, user.getUserEmail());
	        stmt.setDate(4, Date.valueOf(user.getCreatedAt()));
	        stmt.setDate(5, Date.valueOf(user.getLastLoginAt()));
	        stmt.setLong(6, user.getUserId());
	        stmt.executeUpdate();
		} 
	}
	
}