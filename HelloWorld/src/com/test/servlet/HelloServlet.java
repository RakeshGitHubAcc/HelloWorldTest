package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request,response);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/hello.jsp");
		rd.forward(request, response);
	}
	private void doService(HttpServletRequest request, HttpServletResponse response){
		System.out.println("UserName: "+request.getParameter("userName"));
		request.setAttribute("userName",request.getParameter("userName"));
	}
}
