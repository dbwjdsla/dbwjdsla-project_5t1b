package com.otlb.semi.emp.model.service;

import static com.otlb.semi.common.JdbcTemplate.*;

import com.otlb.semi.emp.model.dao.EmpDao;

public class EmpService {

	public static final String EMP_ROLE = "U";
	public static final String ADMIN_ROLE = "A";
	private EmpDao empDao = new EmpDao();
}
