package com.zettamine.jdbctemplate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.zettamine.jdbctemplate.dto.Employee;

public class EmpDAOImpl implements EmpDAO {

	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int saveEmployee(Employee emp) {
		String sql = "INSERT INTO EMP VALUES(" + emp.getEmp_id() + ",'" + emp.getEmp_name() + "','" + emp.getEmp_email() + "',"
				+ emp.getSal() + ")";
		int update = jt.update(sql);
		return update;
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		String sql = "select * from emp where emp_id = "+id;
		Employee emp =null;
		/*
		 * emp = jt.queryForObject(sql, new RowMapper<Employee>() {
		 * 
		 * @Override public Employee mapRow(ResultSet rs, int rowNum) throws
		 * SQLException { String name = rs.getString(2); String email = rs.getString(3);
		 * double sal = rs.getDouble(4); return new Employee(id,name,email,sal); }
		 * 
		 * });
		 */
		
		
		/*
		 * emp = jt.queryForObject(sql, (rs,rowNum)->{ String name = rs.getString(2);
		 * String email = rs.getString(3); double sal = rs.getDouble(4); return new
		 * Employee(id,name,email,sal); }); return emp;
		 */
		
		emp = jt.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
		 
	}
	
	public List<Employee> findAll(){
		String sql = "select * from emp";
		List<Employee> emps = jt.query(sql, new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> empList = new ArrayList<>();
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String email = rs.getString(3);
					 double sal = rs.getDouble(4);
					empList.add(new Employee(id,name,email,sal));
				}
				return empList;
			}
			
		});
		return emps;
	}

}
