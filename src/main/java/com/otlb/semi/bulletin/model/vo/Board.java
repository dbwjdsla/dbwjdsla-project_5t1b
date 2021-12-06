package com.otlb.semi.bulletin.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Board extends BoardEntity implements Serializable {

	private int attachCount; // 첨부 파일수
	private List<Attachment> attachments;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int no, String title, String content, Date regDate, int readCount, int likeCount, String reportYn,
			int empNo, String category, String deleteYn, String empName) {
		super(no, title, content, regDate, readCount, likeCount, reportYn, empNo, category, deleteYn, empName);
		// TODO Auto-generated constructor stub
	}
	public Board(int attachCount, List<Attachment> attachments) {
		super();
		this.attachCount = attachCount;
		this.attachments = attachments;
	}
	public int getAttachCount() {
		return attachCount;
	}
	public void setAttachCount(int attachCount) {
		this.attachCount = attachCount;
	}
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	@Override
	public String toString() {
		return super.toString() +  ", [attachCount=" + attachCount + ", attachments=" + attachments + "]";
	}

	
}
