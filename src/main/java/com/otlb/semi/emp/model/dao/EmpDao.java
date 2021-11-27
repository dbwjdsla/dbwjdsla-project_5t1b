package com.otlb.semi.emp.model.dao;

import static com.otlb.semi.common.JdbcTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EmpDao {

	private Properties prop = new Properties();
	
	public EmpDao() {
		String filepath = EmpDao.class.getResource("/emp-query.properties").getPath();
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
