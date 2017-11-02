package com.softech.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softech.usermanagement.model.User;

@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	
	UserDAO userdao =null;
	
	public void init() throws ServletException {
		
		userdao = new UserDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setFullname(fullname);
		user.setPassword(password);
		
		int status = userdao.createUser(user);
		
		if(status>0) {
			
			request.getRequestDispatcher("index.jsp").include(request,response); 
			
		}
		
		else {
			request.getRequestDispatcher("404.jsp").forward(request, response);
			
		}
		
		
		
	}
	
	public void destroy() {
		
	}
	
	

}
