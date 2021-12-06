package com.otlb.semi.bulletin.model.vo;

import java.io.Serializable;
import java.util.List;

public class Notice extends NoticeEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int attachCount; // 첨부 파일수
	private List<Attachment> attachments;
	
	public Notice() {
		super();
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
