package com.otlb.semi.message.model.service;

import java.sql.Connection;
import java.util.List;
import static com.otlb.semi.common.JdbcTemplate.*;

import com.otlb.semi.message.model.dao.MessageDao;
import com.otlb.semi.message.model.vo.Message;

public class MessageService {
	private MessageDao messageDao = new MessageDao();

	public List<Message> selectAllReceivedMessage(int no) {
		Connection conn = getConnection();
		List<Message> list = messageDao.selectAllMessage(conn, no);
		close(conn);
		
		return list;
	}

	public List<Message> selectAllSentMessage(int no) {
		Connection conn = getConnection();
		List<Message> list = messageDao.selectAllSentMessage(conn, no);
		close(conn);
		
		return list;
	}

	public Message selectOneReceivedMessage(int no) {
		Connection conn = getConnection();
		Message message = messageDao.selectOneReceivedMessage(conn, no);
		close(conn);
		
		return message;
	}

	public Message selectOneSentMessage(int no) {
		Connection conn = getConnection();
		Message message = messageDao.selectOneSentMessage(conn, no);
		close(conn);
		
		return message;
	}
}
