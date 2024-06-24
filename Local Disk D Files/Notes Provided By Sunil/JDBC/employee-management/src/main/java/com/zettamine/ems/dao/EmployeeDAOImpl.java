package com.zettamine.ems.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.ems.configs.ConnectionFactory;
import com.zettamine.ems.dto.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Statement st = null;
	
	public EmployeeDAOImpl() {
	 try {	
		Connection con = ConnectionFactory.getDBConnection();
		st = con.createStatement();
	 }catch(Exception ex) {
		 ex.printStackTrace();
	 }
	}

	@Override
	public Integer saveEmployee(Employee emp) {
		String sql = "insert into emp values("+emp.getEmployeeNo()+",'"+emp.getEmployeeName()+"',"+emp.getEmployeeSal()+")";
		try {
			int n = st.executeUpdate(sql);
			return n;
		}catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public Employee findById(Integer id) {
		Employee emp = null;
		String sql = "select ename, sal from emp where empno = "+ id;
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				String name = rs.getString(1);
				float sal = rs.getFloat(2);
				emp = new Employee(id,name,sal);
			}			
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> emps = new ArrayList<Employee>();
		
		String sql = "select * from emp";
		try {
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int eno = rs.getInt(1);
				String name = rs.getString(2);
				float sal = rs.getFloat(3);
				
				Employee emp = new Employee(eno, name, sal);
				emps.add(emp);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return emps;
	}

	@Override
	public Integer updateEmployee(Integer id, Employee emp) {
		String sql = "update emp set ename='"+emp.getEmployeeName()+"',sal="+emp.getEmployeeSal()+" where empno="+id;
		try {
			return st.executeUpdate(sql);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer deleteById(Integer id) {
		String sql = "delete from emp where empno="+id;
		int n = 0;
		try {
			n = st.executeUpdate(sql);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return n;
	}

}
