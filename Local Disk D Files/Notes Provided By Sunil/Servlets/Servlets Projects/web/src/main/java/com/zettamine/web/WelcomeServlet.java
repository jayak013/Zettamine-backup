package com.zettamine.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<body style=\"text-align:center;background:linear-gradient(to right, orange, white, green)\">");
			out.println("<h1 style=\"text-shadow:0 0 10px blue\">ZETTAMINE LABS PRIVATE LIMITED</h1>");
			out.println("<img src=images/zetta.jpg width=400px style=\"box-shadow: 0px 0px 20px black; border-radius:20px\">");
			out.println("<hr>");
			out.println("<p style=text-align:left>Hello <ins>" + request.getParameter("txt_uid") + "</ins></p>");
			out.println("</body>");
			out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
