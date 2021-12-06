package com.otlb.semi.bulletin.model.vo;

import java.io.Serializable;
import java.sql.Date;

	/**
	 *	VO 클래스 상속 관계도  
	 *	Bulletin
	 *  	|_ NoticeEntity
	 *  	|	|_ Notice
	 *  	|_ BoardEntity
	 *  		|_ Board
	 * 삭제 							|_ AnonymousBoard
	 */
abstract public class Bulletin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int no;
	private String title;
	private String content;
	private Date regDate;
	private int readCount;
	private int empNo;
	private String deleteYn;
	private String empName;
	
	public Bulletin() {
		super();
	}

	public Bulletin(int no, String title, String content, Date regDate, int readCount, int empNo, String deleteYn, String empName) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.readCount = readCount;
		this.empNo = empNo;
		this.deleteYn = deleteYn;
		this.empName = empName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Bulletin [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", readCount=" + readCount + ", empNo=" + empNo + ", deleteYn=" + deleteYn + ", empName=" + "]";
	}
	
}
