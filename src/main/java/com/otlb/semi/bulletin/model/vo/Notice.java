package com.otlb.semi.bulletin.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Notice extends Bulletin implements Serializable {

	private int attachCount; // 첨부 파일수
	private List<Attachment> attachments;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Notice(int no, String title, String content, Date regDate, int readCount, int empNo, String deleteYn,
			String empName, int attachCount) {
		super(no, title, content, regDate, readCount, empNo, deleteYn, empName);
	}

	public Notice(int attachCount, List<Attachment> attachments) {
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
		return "Notice [attachCount=" + attachCount + ", attachments=" + attachments + "]";
	}
	
}
