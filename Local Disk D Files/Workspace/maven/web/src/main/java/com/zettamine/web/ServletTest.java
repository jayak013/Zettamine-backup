package com.zettamine.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/test")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plaintext");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		for(Cookie c:cookies) {
			String value = c.getValue();
			out.println(value);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body style = \"text-align:center\">");
		out.println("<h1>Zettamine Labs Private Limited</h1>");
		out.println("<img src=\"images/Zettamine logo.png\"width = 300px style = \"box-shadow:10px 10px 10px 10px black;border-radius:10px\">");
		out.println("</body>");
		out.println("</html>");
	}

}
