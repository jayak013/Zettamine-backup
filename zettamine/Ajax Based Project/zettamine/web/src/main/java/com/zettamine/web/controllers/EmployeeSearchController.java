package com.zettamine.web.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.json.JSONObject;

public class EmployeeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static PreparedStatement pst = null;
	    
	    @Resource(name = "jdbc/MySQLDB")
	    DataSource ds;
	 	public void init(ServletConfig config) throws ServletException {
	 				
			try {			
				Connection con = ds.getConnection();
	            
				pst = con.prepareStatement("select ename,sal from emp where empno=?");
			}catch(Exception ex) {
				System.out.println(ex.toString());
				ex.printStackTrace();
			}
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			String eno = request.getParameter("eno");
			String responseText="";
			
			if(eno!=null || eno.length()>0)		{				
			try {
				int empno = Integer.parseInt(eno);
				pst.setInt(1, empno);
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					String name = rs.getString(1);
					float sal = rs.getFloat(2);
					
					response.setContentType("application/json");
					
					JSONObject jObj = new JSONObject();
					
					jObj.put("ename", name);
					jObj.put("esal", sal);
					
					out.println(jObj);
				}else {
					out.print(responseText);
				}
			}catch(Exception ex) {
				System.out.println(ex.toString());
				out.print(responseText);
			}
			
			}
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}


}
