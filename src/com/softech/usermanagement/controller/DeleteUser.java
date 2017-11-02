package com.softech.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet{
	
	UserDAO userdao = null;
	
	public void init() throws ServletException{
		
		userdao = new UserDAO();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("id");
		
		
		int id = Integer.parseInt(sid);
		
		int status = userdao.deleteUser(id);
		
		if(status>0) {
		request.getRequestDispatcher("/UserView").forward(request, response);
		}
		
		else {
			response.sendRedirect("404.jsp");
		}
		
	}
	
	public void destroy() {
		
	}

}
