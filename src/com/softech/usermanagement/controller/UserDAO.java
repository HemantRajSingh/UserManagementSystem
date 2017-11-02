package com.softech.usermanagement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softech.usermanagement.model.User;

public class UserDAO {

	
	public Connection getConnection() {
		
		
		Connection con = null;
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/user","root","root");
			
			System.out.println("Database Conected");
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			e.getMessage();
		}
		
		return con;
	}
	
	public int loginUser(String username, String password) {
		int status = 0;
		UserDAO userdao = new UserDAO();
		try {
			
			Connection con = userdao.getConnection();
			String query = "select * from user where username='"+username+"' and password='"+password+"' ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				status = 1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return status;
	}
	
	public int createUser(User user) {
		
		int status = 0;
		UserDAO userdao = new UserDAO();
		
		try {
			
			Connection con = userdao.getConnection();
			
			
			String query = "insert into user(username,fullname,password) values(?,?,?) ";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPassword());
			
			status = ps.executeUpdate();
			
			con.close();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return status;
		
	}
	
	public int updateUser(User user) {
		
		int status = 0;
		UserDAO userdao = new UserDAO();
		
		try {
			Connection con = userdao.getConnection();
			String query = "update user set username=?, fullname=?, password=? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
		
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());
			
			status = ps.executeUpdate();
			
			con.close();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return status;
	}
	
	
	public int deleteUser(int id) {
		
		
		UserDAO userdao = new UserDAO();
		int status = 0;
		try {
			Connection con = userdao.getConnection();
			String query = "delete from user where id = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
			con.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return status;
		
	}
	
	
	public User selectUser(int id) {
		
		User user = new User();
		UserDAO userdao = new UserDAO();
		try {
			Connection con = userdao.getConnection();
			String query = "select * from user where id = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				
			}
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		return user;
	}

	
	public List<User> userView(){
		
		List<User> dataList = new ArrayList<User>();
		UserDAO userdao = new UserDAO();
		try {
			Connection con = userdao.getConnection();
			
			String query = "select * from user";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				dataList.add(user);
			}
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return dataList;
	}
	
}
