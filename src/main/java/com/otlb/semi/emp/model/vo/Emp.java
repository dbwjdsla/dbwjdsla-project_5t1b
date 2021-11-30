package com.otlb.semi.emp.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Emp implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int no;
	private String empName;
	private String password;
	private Date birthdate;
	private String deptCode;
	private String jobCode;
	private String empRole;
	private String gender;
	private String email;
	private String phone;
	private String quitYn;
	private String banYn;
	
	public Emp() {
		super();
	}

	public Emp(int no, String empName, String password, Date birthdate, String deptCode, String jobCode, String empRole,
			String gender, String email, String phone, String quitYn, String banYn) {
		super();
		this.no = no;
		this.empName = empName;
		this.password = password;
		this.birthdate = birthdate;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.empRole = empRole;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.quitYn = quitYn;
		this.banYn = banYn;
	}
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}

	public String getBanYn() {
		return banYn;
	}

	public void setBanYn(String banYn) {
		this.banYn = banYn;
	}

	@Override
	public String toString() {
		return "Emp [no=" + no + ", empName=" + empName + ", password=" + password + ", birthdate=" + birthdate
				+ ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", empRole=" + empRole + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + ", quitYn=" + quitYn + ", banYn=" + banYn + "]";
	}
	
	
	
}
