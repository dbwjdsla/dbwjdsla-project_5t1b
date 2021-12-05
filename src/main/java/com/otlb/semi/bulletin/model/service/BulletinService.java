package com.otlb.semi.bulletin.model.service;

import static com.otlb.semi.common.JdbcTemplate.close;
import static com.otlb.semi.common.JdbcTemplate.commit;
import static com.otlb.semi.common.JdbcTemplate.getConnection;
import static com.otlb.semi.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.otlb.semi.bulletin.model.dao.BulletinDao;
import com.otlb.semi.bulletin.model.vo.Board;
import com.otlb.semi.bulletin.model.vo.Board;

public class BulletinService {

	public static final String hasDeleted = "Y";
	public static final String hasNotDeleted = "N";
	public static final String isReported = "Y";
	public static final String isNotReported = "N";
	
	private BulletinDao bulletinDao = new BulletinDao();

	public int insertBoard(Board board) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = bulletinDao.insertBoard(conn, board);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}

	public List<Board> selectAllBoard() {
		Connection conn = getConnection();
		List<Board> list = bulletinDao.selectAllBoard(conn);
		close(conn);
		return list;
	}
}
