package com.softech.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softech.usermanagement.validator.Validator;

import javax.servlet.RequestDispatcher;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet{
	
	UserDAO userdao = null;
	Validator validator = null;
	
	public void init() throws ServletException{
		
		userdao = new UserDAO();
		validator = new Validator();
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		int status = 0;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//// REgex validation() ////
		
		if(validator.validateAlphabet(username)) {
			status = userdao.loginUser(username, password);
			
			if(status>=1) {
				request.getRequestDispatcher("/UserView").forward(request,response);
			}
			
			else {
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
		}
		
		else {
			
			request.setAttribute("data","Username must only consists of alphabets");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
		
	}
	
	
	public void destroy() {
		
	}
}
