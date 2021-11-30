package com.otlb.semi.emp.model.vo;

import java.io.Serializable;

public class Job implements Serializable{

	private static final long serialVersionUID = 1L;

	private String jobCode;
	private String jobName;
	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(String jobCode, String jobName) {
		super();
		this.jobCode = jobCode;
		this.jobName = jobName;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "Job [jobCode=" + jobCode + ", jobName=" + jobName + "]";
	}
	
	
}
