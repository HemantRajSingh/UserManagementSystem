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

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	
	UserDAO userdao = null;
	User user = null;
	
	public void init() throws ServletException{
		userdao = new UserDAO();
		user = new User();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int status = 0;
		String uid = request.getParameter("id");
		int id = Integer.parseInt(uid);
		String  username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		user.setId(id);
		user.setFullname(fullname);
		user.setUsername(username);
		user.setPassword(password);
		
		
		status = userdao.updateUser(user);
		
		if(status>0)
		{
			request.getRequestDispatcher("UserView").forward(request, response);
			
		}
		else
		{
			response.sendRedirect("404.jsp");
		}
	
	}
}
