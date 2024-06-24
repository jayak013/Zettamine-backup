package com.zettamine.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Register1
 */
public class Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init executed");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("executed");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() executed");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String test = request.getParameter("test");
//		
//		response.setContentType("text/html");
//		out.println("<body>");
//		out.println("<h1>"+user+" - "+pass+" - "+test+"<h1>");
//		out.println("<form>");
//		out.println("<input type = submit value = test>");
//		out.println("</form>");
//		out.println("</body>");

		
		Cookie cookie = new Cookie("user", user);
		Cookie cookie1 = new Cookie("pass", pass);
		Cookie cookie2 = new Cookie("test", test);
		
		response.addCookie(cookie);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		RequestDispatcher rd = request.getRequestDispatcher("test");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post");
	}
	

}
