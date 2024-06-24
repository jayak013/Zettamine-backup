package com.zettamine.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login1")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static PreparedStatement pst = null;
    
    //@Resource(name = "jdbc/MySQLDB")
    //static DataSource ds;
 	public void init(ServletConfig config) throws ServletException {
 				
		try {			
			Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/MySQLDB");
            Connection con = ds.getConnection();
            
			pst = con.prepareStatement("select * from users where username=? and password=?");
		}catch(Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the form data (txt_uid, txt_pwd)
		String user = request.getParameter("txt_uid");
		String pass = request.getParameter("txt_pwd");
		
		try {
			pst.setString(1, user);
			pst.setString(2, pass);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("login", 1);
				
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				rd.forward(request, response);
			}else {
				response.setContentType("text/html");				
				PrintWriter out = response.getWriter();
				out.println("<p style=color:red;text-align:center;font-size:18px>Authentication Failed!!! Invalid Username/ Password</p>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
