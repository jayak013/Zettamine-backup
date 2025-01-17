package com.zettamine.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("id").equals("1")) {
			Account account = new Account(101, "jaya krishna", "9666410798");
			request.setAttribute("id", account.accountNo);
			request.setAttribute("name", account.name);
			request.setAttribute("mobile", account.mobile);
			RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("id").equals("2")) out.println("this is SUBMIT ANCHOR TAG");
		if(request.getParameter("id").equals("3")) out.println("this is REGISTER ANCHOR TAG");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
