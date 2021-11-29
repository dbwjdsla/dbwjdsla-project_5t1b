package com.otlb.semi.message.model.service;

import java.sql.Connection;
import java.util.List;
import static com.otlb.semi.common.JdbcTemplate.*;

import com.otlb.semi.message.model.dao.MessageDao;
import com.otlb.semi.message.model.vo.Message;

public class MessageService {
	private MessageDao messageDao = new MessageDao();

	public List<Message> selectAllMessage(int no) {
		Connection conn = getConnection();
		List<Message> list = messageDao.selectAllMessage(conn, no);
		close(conn);
		
		return list;
	}
}
