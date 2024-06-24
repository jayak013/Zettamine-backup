package com.zettamine.ums.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.ums.configs.ConnectionFactory;
import com.zettamine.ums.dto.User;

public class UserDAOImpl implements UserDAO {
	 private Connection connection=null;

	 public UserDAOImpl() 
	 {
	  connection = ConnectionFactory.getConnection();
	 }
	 
	 public void addUser(User user) 
	 {
	  try 
	  {
	   PreparedStatement pst=connection.prepareStatement("insert into users(firstname,lastname,dob,email) values (?, ?, ?, ?)");
	   pst.setString(1, user.getFirstName());
	   pst.setString(2, user.getLastName());
	   pst.setDate(3, new java.sql.Date(user.getDob().getTime()));
	   pst.setString(4, user.getEmail());
	   pst.executeUpdate();
	  } 
	  catch (SQLException e) {e.printStackTrace();}
	 }
	 
	 public void deleteUserById(int userId) 
	 {
	  try 
	  {
	   PreparedStatement pst = connection.prepareStatement("delete from users where userid=?");
	   pst.setInt(1, userId);
	   pst.executeUpdate();
	  } 
	  catch (SQLException e) {e.printStackTrace();}
	 }
	 
	 public void updateUser(User user) 
	 {
	  try 
	  {
	   PreparedStatement pst = connection.prepareStatement("update users set firstname=?, lastname=?, dob=?, email=? where userid=?");
	   pst.setString(1, user.getFirstName());
	   pst.setString(2, user.getLastName());
	   pst.setDate(3, new java.sql.Date(user.getDob().getTime()));
	   pst.setString(4, user.getEmail());
	   pst.setInt(5, user.getUserid());
	   pst.executeUpdate();
	  } 
	  catch (SQLException e) {e.printStackTrace();}
	 }
	 
	 public List<User> getAllUsers() 
	 {
	  List<User> users = new ArrayList<User>();
	  try 
	  {
	   Statement statement = connection.createStatement();
	   ResultSet rs = statement.executeQuery("select * from users");
	   while(rs.next()) 
	   {
	    User user = new User();
	    user.setUserid(rs.getInt("userid"));
	    user.setFirstName(rs.getString("firstname"));
	    user.setLastName(rs.getString("lastname"));
	    user.setDob(rs.getDate("dob"));
	    user.setEmail(rs.getString("email"));
	    users.add(user);
	   }
	  } 
	  catch (SQLException e) {e.printStackTrace();}
	  return users;
	 }
	 
	 public User findUserById(int userId) 
	 {
	  User user = new User();
	  try 
	  {
	   PreparedStatement pst = connection.prepareStatement("select * from users where userid=?");
	   pst.setInt(1, userId);
	   ResultSet rs = pst.executeQuery();
	   if (rs.next()) {
	     user.setUserid(rs.getInt("userid"));
	     user.setFirstName(rs.getString("firstname"));
	     user.setLastName(rs.getString("lastname"));
	     user.setDob(rs.getDate("dob"));
	     user.setEmail(rs.getString("email"));
	   }
	  } 
	  catch (SQLException e) {e.printStackTrace();}
	  return user;
	 }

}
