package mainpage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class BoardVo  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int no;
	private String title;
	private String content;
	private Date reg_date;
	private int read_count;
	private int like_count; //추천수
	private int user_no;
	
	
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoardVo(int no, String title, String content, Date reg_date, int read_count, int like_count, int user_no) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.read_count = read_count;
		this.like_count = like_count;
		this.user_no = user_no;
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


	public Date getReg_date() {
		return reg_date;
	}


	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}


	public int getRead_count() {
		return read_count;
	}


	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}


	public int getLike_count() {
		return like_count;
	}


	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}


	public int getUser_no() {
		return user_no;
	}


	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content=" + content + ", reg_date=" + reg_date
				+ ", read_count=" + read_count + ", like_count=" + like_count + ", user_no=" + user_no + "]";
	}
	
	
	

}
