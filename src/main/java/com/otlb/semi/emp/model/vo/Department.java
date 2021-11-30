package com.otlb.semi.emp.model.vo;

import java.io.Serializable;

public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String deptCode;
	private String deptName;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String deptCode, String deptName) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptCode=" + deptCode + ", deptName=" + deptName + "]";
	}

	
}
