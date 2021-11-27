package com.otlb.semi.bulletin.model.vo;

import java.io.Serializable;
import java.sql.Date;

	/**
	 *	VO 클래스 상속 관계도  
	 *	Bulletin
	 *  	|_ noticeEntity
	 *  	|_ BoardEntity
	 *  		|_ Board
	 *  		|_ AnonymousBoard
	 */
abstract public class Bulletin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int no;
	private String title;
	private String content;
	private Date regDate;
	private int readCount;
	private int userNo;
	private String deleteYn;
	
	public Bulletin() {
		super();
	}

	public Bulletin(int no, String title, String content, Date regDate, int readCount, int userNo, String deleteYn) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.readCount = readCount;
		this.userNo = userNo;
		this.deleteYn = deleteYn;
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

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	@Override
	public String toString() {
		return "Bulletin [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", readCount=" + readCount + ", userNo=" + userNo + ", deleteYn=" + deleteYn + "]";
	}
	
}
