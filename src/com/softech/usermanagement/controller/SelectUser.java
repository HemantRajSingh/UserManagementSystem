package com.softech.usermanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softech.usermanagement.model.User;

@WebServlet("/SelectUser")
public class SelectUser extends HttpServlet {

	UserDAO userdao = null;
	public void init() throws ServletException{
		
		userdao = new UserDAO();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		User dataList = userdao.selectUser(id);
		System.out.println("id"+dataList.getId());
		
		request.setAttribute("id", dataList.getId());
		request.setAttribute("username", dataList.getUsername());
		request.setAttribute("fullname", dataList.getFullname());
		request.setAttribute("password", dataList.getPassword());
		request.getRequestDispatcher("useredit.jsp").forward(request, response);
		
		
	}
	
}
