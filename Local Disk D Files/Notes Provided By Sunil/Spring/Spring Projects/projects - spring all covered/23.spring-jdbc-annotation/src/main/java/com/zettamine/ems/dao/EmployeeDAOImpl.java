package com.zettamine.ems.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zettamine.ems.dto.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private JdbcTemplate jt;
	
	/*
	@Autowired
	public EmployeeDAOImpl(DataSource ds) {		
		this.jt = new JdbcTemplate(ds);
	}
	*/
	
	@Override
	public Integer saveEmployee(Employee emp) {
		String sql = "insert into emp values(?, ?, ?)";
		int n = jt.update(sql, emp.getEmployeeNo(), emp.getEmployeeName(), emp.getEmployeeSal());
		return n;
	}

	@Override
	public Integer updateEmployee(int empno, Employee emp) {
		String sql = "update emp set ename=?, sal=? where empno=?";
		int n = jt.update(sql, new Object[] {emp.getEmployeeName(), emp.getEmployeeSal(), empno});
		return n;
	}

	@Override
	public Integer deleteEmployeeByNo(int eno) {
		String sql = "delete from emp where empno=?";
		int n = jt.update(sql, eno);
		return n;
	}

	@Override
	public Employee findEmployeeByNo(int eno) {
		String sql = "select * from emp where empno = ?";
		Employee emp = null;
		try {
			emp = jt.queryForObject(sql, new CustomEmployeeMapper(), new Object[] {eno});
		}catch(Exception ex) {}
		
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		String sql = "select * from emp";		
		List<Employee> emps = jt.query(sql, new CustomEmployeeMapper());
		
		sql = "select ename from emp where empno = ?";
		String name = jt.queryForObject(sql, String.class, new Object[] {101});
		System.out.println("employee name = " + name);
		return emps;
	}
}


class CustomEmployeeMapper implements RowMapper<Employee>{
	
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		int eno = rs.getInt(1);
		String name = rs.getString(2);
		float sal = rs.getFloat(3);

		Employee emp = new Employee(eno, name, sal);
		return emp;
	}	
}
