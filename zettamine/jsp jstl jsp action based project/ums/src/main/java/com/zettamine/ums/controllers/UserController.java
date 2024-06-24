package com.zettamine.ums.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zettamine.ums.dao.UserDAOImpl;
import com.zettamine.ums.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usercontroller")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAOImpl dao;

	public UserController() 
	{
	 dao=new UserDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 String forward="";	 
	 String action = request.getParameter("action");	 
	 if(action==null)
	 {
	   forward = "/index.jsp";
	   request.setAttribute("users", dao.getAllUsers());
	 }
	 
	 else if(action.equalsIgnoreCase("edit"))
	 {
	  forward = "/user.jsp";
	  int userId = Integer.parseInt(request.getParameter("userId"));
	  User user = dao.findUserById(userId);
	  
	  request.setAttribute("user", user);
	  request.setAttribute("label","Update User");
	  request.setAttribute("hlabel", "Edit User");
	 }  
	 
	 else if(action.equalsIgnoreCase("delete"))
	 {
	  int userId = Integer.parseInt(request.getParameter("userId"));
	  dao.deleteUserById(userId);
	  forward = "/index.jsp";
	  request.setAttribute("users", dao.getAllUsers());    
	 }
	 else if(action.equalsIgnoreCase("insert"))
	 {
	  request.setAttribute("label","Add User");
	  request.setAttribute("hlabel", "Save User");
	  forward="/user.jsp";
	 }
	 
	 RequestDispatcher view = request.getRequestDispatcher(forward);
	 view.forward(request, response);	
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
	 User user = new User();
	 user.setFirstName(request.getParameter("firstName"));
	 user.setLastName(request.getParameter("lastName"));
	 try 
	 {
	  Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
	  user.setDob(dob);
	 } 
	 catch (Exception e) {e.printStackTrace();}
	 
	 user.setEmail(request.getParameter("email"));
	 
	 String userid = request.getParameter("userid");
	 if(userid == null || userid.isEmpty())
	 {
	  dao.addUser(user);
	 }
	 else
	 {
	  user.setUserid(Integer.parseInt(userid));
	  dao.updateUser(user);
	 }
	 RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
	 request.setAttribute("users", dao.getAllUsers());
	 view.forward(request, response);
	}
}
