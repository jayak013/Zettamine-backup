package com.zettamine.sms.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zettamine.sms.dto.Student;

public class StudentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void studentBatchInsertion(List<Student> students) {
		String sql = "insert into student_details values(?, ?)";

		int[] n = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Student st = students.get(i);
				ps.setInt(1, st.getStudentId());
				ps.setString(2, st.getStudentName());
				System.out.println(st);
			}

			@Override
			public int getBatchSize() {				
				//return 100;
				return students.size();
			}
			
		});
		
		System.out.println(Arrays.toString(n));
	}
}	
