package com.zettamine.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class ZettamineFilter extends HttpFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String uid = request.getParameter("txt_uid");
		String pass = request.getParameter("txt_pwd");
		if(uid.equals("admin") && pass.equals("123"))
			chain.doFilter(request, response);
		else {
			response.setContentType("text/html");				
			PrintWriter out = response.getWriter();
			out.println("<p style=color:red;text-align:center;font-size:18px>Authentication Failed!!! Invalid Username/ Password</p>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
