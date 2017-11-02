package com.softech.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softech.usermanagement.model.User;

@WebServlet("/UserView")
public class UserView extends HttpServlet{
	
	UserDAO userdao = null;
	
	public void init() throws ServletException{
		userdao = new UserDAO();
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<User> dataList = userdao.userView();
		
		request.setAttribute("data", dataList);
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
		
		
	}
	
protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<User> dataList = userdao.userView();
		
		request.setAttribute("data", dataList);
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
		
		
	}
}
