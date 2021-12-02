package com.otlb.semi.message.model.dao;

import static com.otlb.semi.common.JdbcTemplate.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.otlb.semi.emp.model.vo.Emp;
import com.otlb.semi.message.model.exception.MessageException;
import com.otlb.semi.message.model.vo.Message;

public class MessageDao {
	
	private Properties prop = new Properties();
	
	public MessageDao() {
		File file = new File(MessageDao.class.getResource("/message-query.properties").getPath());
		
		try {
			prop.load(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Message> selectAllReceivedMessage(Connection conn, int empNo) {
		PreparedStatement pstmt = null;
		List<Message> list = new ArrayList<>();
		String sql = prop.getProperty("selectAllReceivedMessage");
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Message message = new Message();
				message.setNo(rset.getInt("no"));
				message.setContent(rset.getString("content"));
				message.setSenderEmpNo(rset.getInt("sender_emp_no"));
				message.setReceiverEmpNo(rset.getInt("receiver_emp_no"));
				message.setSentDate(rset.getDate("sent_date"));
				message.setReadDate(rset.getDate("read_date"));
				message.setSenderDelYn(rset.getString("sender_del_yn"));
				message.setReceiverDelYn(rset.getString("receiver_del_yn"));
				
				Emp emp = new Emp();
				emp.setEmpName(rset.getString("sender_emp_name"));
				
				message.setEmp(emp);
				
				list.add(message);
			}
		} catch (SQLException e) {
			throw new MessageException("받은 쪽지 데이터 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Message> selectAllSentMessage(Connection conn, int no) {
		PreparedStatement pstmt = null;
		List<Message> list = new ArrayList<>();
		String sql = prop.getProperty("selectAllSentMessage");
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Message message = new Message();
				message.setNo(rset.getInt("no"));
				message.setContent(rset.getString("content"));
				message.setSenderEmpNo(rset.getInt("sender_emp_no"));
				message.setReceiverEmpNo(rset.getInt("receiver_emp_no"));
				message.setSentDate(rset.getDate("sent_date"));
				message.setReadDate(rset.getDate("read_date"));
				message.setSenderDelYn(rset.getString("sender_del_yn"));
				message.setReceiverDelYn(rset.getString("receiver_del_yn"));
				
				Emp emp = new Emp();
				emp.setEmpName(rset.getString("receiver_emp_name"));
				
				message.setEmp(emp);
				
				list.add(message);
			}
		} catch (SQLException e) {
			throw new MessageException("보낸 쪽지 데이터 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Message selectOneReceivedMessage(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOneReceivedMessage");
		Message message = new Message();
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				message.setSentDate(rset.getDate("sent_date"));
				message.setContent(rset.getString("content"));
				
				Emp emp = new Emp();
				emp.setEmpName(rset.getString("sender_emp_name"));
				message.setEmp(emp);
			}
		} catch (SQLException e) {
			throw new MessageException("받은상세쪽지 조회 요류");
		} finally {
			close(rset);
			close(pstmt);
		}
		return message;
	}

	public Message selectOneSentMessage(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOneSentMessage");
		Message message = new Message();
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				message.setSentDate(rset.getDate("sent_date"));
				message.setContent(rset.getString("content"));
				
				Emp emp = new Emp();
				emp.setEmpName(rset.getString("receiver_emp_name"));
				message.setEmp(emp);
			}
		} catch (SQLException e) {
			throw new MessageException("보낸상세쪽지 조회 요류");
		} finally {
			close(rset);
			close(pstmt);
		}
		return message;
	}
}







