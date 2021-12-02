package com.otlb.semi.emp.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Emp extends EmpEntity implements Serializable{


	private String deptName;
	private String jobName;
	
	public Emp() {
		super();
	}

	public Emp(int empNo, String empName, String password, Date birthdate, String deptCode, String jobCode,
			String empRole, String gender, String email, String phone, String quitYn, String banYn) {
		super(empNo, empName, password, birthdate, deptCode, jobCode, empRole, gender, email, phone, quitYn, banYn);
		// TODO Auto-generated constructor stub
	}
	
	public Emp(int empNo, String empName, String password, Date birthdate, String deptCode, String jobCode, String empRole,
		String gender, String email, String phone, String quitYn, String banYn, String deptName, String jobName) {
	super(empNo, empName, password, birthdate, deptCode, jobCode, empRole, gender, email, phone, quitYn, banYn);
	this.deptName = deptName;
	this.jobName = jobName;	
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	@Override
	public String toString() {
		return "Emp [" + super.toString()
				+ "deptName=" + deptName 
				+ ", jobName=" + jobName + "]";
	}


}
