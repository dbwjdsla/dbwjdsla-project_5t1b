package com.otlb.semi.bulletin.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class BoardEntity extends Bulletin implements Serializable {

	private static final long serialVersionUID = 1L;

	private int likeCount;
	private String reportYn;
	private String category;

	public BoardEntity() {
		super();
	}

	public BoardEntity(int no, String title, String content, Date regDate, int readCount, int likeCount, String reportYn, int empNo, String category, String deleteYn) {
		super(no, title, content, regDate, readCount, empNo, deleteYn);
		this.likeCount = likeCount;
		this.reportYn = reportYn;
		this.category = category;
	}
	
	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getReportYn() {
		return reportYn;
	}

	public void setReportYn(String reportYn) {
		this.reportYn = reportYn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return super.toString() + "BoardEntity [likeCount=" + likeCount + ", reportYn=" + reportYn + ", category=" + category + "]";
	}

	
	
}
