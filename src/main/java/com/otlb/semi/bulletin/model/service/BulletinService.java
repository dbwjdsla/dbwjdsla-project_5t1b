package com.otlb.semi.bulletin.model.service;

import static com.otlb.semi.common.JdbcTemplate.close;
import static com.otlb.semi.common.JdbcTemplate.commit;
import static com.otlb.semi.common.JdbcTemplate.getConnection;
import static com.otlb.semi.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.otlb.semi.bulletin.model.dao.BulletinDao;
import com.otlb.semi.bulletin.model.vo.Attachment;
import com.otlb.semi.bulletin.model.vo.Board;
import com.otlb.semi.bulletin.model.vo.Notice;

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
			
			// 방금 insert된 boardNo 조회 : select seq_board_no.currval from dual
			int boardNo = bulletinDao.selectLastBoardNo(conn);
			System.out.println("[bulletinService] boardNo = " + boardNo);
			
			List<Attachment> attachments = board.getAttachments();
			if(attachments != null) {
				// insert into attachment values(seq_attachment_no.nextval, ?, ?, default, 0)
				for(Attachment attach : attachments) {
					attach.setBoardNo(boardNo); // FK컬럼값 설정(중요)
					result = bulletinDao.insertAttachment(conn, attach);
				}
			}
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		return result;
	}

	public int deleteBoard(int no) {
		Connection conn = null;
		int result = 0;
		try {
			conn = getConnection();
			result = bulletinDao.deleteBoard(conn, no);
			commit(conn);
			
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public Board selectOneBoard(int no) {
		Connection conn = getConnection();
		Board board = bulletinDao.selectOneBoard(conn, no);
		List<Attachment> attachments = bulletinDao.selectAttachmentByBoardNo(conn, no);
		board.setAttachments(attachments);
		close(conn);
		return board;
	}

	public int updateBoard(Board board) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = bulletinDao.updateBoard(conn, board);
			
			List<Attachment> attachments = board.getAttachments();
			if(attachments != null && !attachments.isEmpty()) {
				for(Attachment attach : attachments) {
					result = bulletinDao.insertAttachment(conn, attach);
				}
			}
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
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
	
	public int selectTotalBoardCount() {
		Connection conn = getConnection();
		int totalCount = bulletinDao.selectTotalBoardCount(conn);
		close(conn);
		return totalCount;
	}


	public Attachment selectOneAttachment(int no) {
		Connection conn = getConnection();
		Attachment attach = bulletinDao.selectOneAttachment(conn, no);
		close(conn);
		return attach;

	}

	public int deleteAttachment(int delFileNo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = bulletinDao.deleteAttachment(conn, delFileNo);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}
	
	public List<Notice> selectAllNotice() {
		Connection conn = getConnection();
		List<Notice> list = bulletinDao.selectAllNotice(conn);
		close(conn);
		return null;
	}
	
}
