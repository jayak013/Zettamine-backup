package com.zettamine.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body style = background-color:cyan;>");
		out.println("<form action = form1 method = post>");
		out.println("Age: <input type=text name=age><br>");
		out.println("Gender: <input type=text name=gender><br>");
		out.println("<input type=submit value=\"S U B M I T\"><br>");
		out.println("</form>");
		out.println("</body>");
	}

}
