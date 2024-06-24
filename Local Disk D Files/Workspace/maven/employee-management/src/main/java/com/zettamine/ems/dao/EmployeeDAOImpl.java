package com.zettamine.ems.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.ems.configs.ConnectionFactory;
import com.zettamine.ems.dto.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static Statement st = null;
	private static Connection con = null;
	

	public EmployeeDAOImpl() {
		super();
		try {
			con = ConnectionFactory.getConnection();
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public Integer saveEmployee(Employee emp) {
		int rowsUpdated = 0;
		String query = "insert into emp values("+emp.getId()+",'"+emp.getName()+"',"+emp.getSalary()+")";
		try {
			rowsUpdated = st.executeUpdate(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

	@Override
	public Integer updateById(Integer id, Employee emp) {
		int rowsUpdated = 0;
		String query = "update emp set ename = '"+emp.getName()+"',sal = "+emp.getSalary()
							+" where empno = "+id;
		try {
			rowsUpdated = st.executeUpdate(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

	@Override
	public Integer deleteById(Integer id) {
		int rowsDeleted = 0;
		String query = "delete from emp where empno = "+id;
		try {
			rowsDeleted = st.executeUpdate(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	@Override
	public Employee findById(Integer id) {
		Employee emp = null;
		String query = "select ename,sal from emp where empno = "+id;
		try {
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				String name = rs.getString(1);
				float sal = rs.getFloat(2);
				emp = new Employee(id,name,sal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> emps =  new ArrayList<Employee>();
		String query = "select * from emp";
		try {
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				float sal = rs.getFloat(3);
				Employee emp = new Employee(id,name,sal);
				emps.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emps;
	}

	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void terminateConnections() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isExists(Integer id) {
		Employee emp = findById(id);
		return emp!=null;
	}
}
