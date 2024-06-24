package com.zettamine.jdbctemplate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zettamine.jdbctemplate.dto.Employee;


public interface EmpDAO {
	
	int saveEmployee(Employee emp);
	
	Employee findEmployeeById(Integer id);
	
	List<Employee> findAll();
	
}
