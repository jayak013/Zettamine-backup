package com.zettamine.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.zettamine.ems.dto.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public Integer saveEmployee(Employee emp) {
		String sql = "insert into emp values("+emp.getEmployeeNo()+",'"+emp.getEmployeeName()+"',"+emp.getEmployeeSal()+")";
		int n = jt.update(sql);
		return n;
	}

	@Override
	public Employee findById(Integer id) {
		Employee emp = null;
		String sql = "select * from emp where empno="+id;
		try {
			emp = jt.queryForObject(sql, new MyCustomEmployeeMapper());
		}
		catch(Exception ex) {
			return null;
		}
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		String sql = "select * from emp";
		List<Employee> emps = jt.query(sql, new MyCustomEmployeeMapper());
		return emps;
	}

	@Override
	public Integer updateEmployee(Integer id, Employee emp) {
		String sql = "update emp set ename='"+emp.getEmployeeName()+"',sal="+emp.getEmployeeSal()+" where empno="+id;
		int n = jt.update(sql);
		return n;
	}

	@Override
	public Integer deleteById(Integer id) {
		String sql = "delete from emp where empno="+id;
		int n = jt.update(sql);
		return n;
	}

}

class MyCustomEmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("-----> " + rowNum);
		int eno = rs.getInt(1);
		String name = rs.getString(2);
		float sal = rs.getFloat(3);

		Employee emp = new Employee(eno, name, sal);
		return emp;
	}
	
}
