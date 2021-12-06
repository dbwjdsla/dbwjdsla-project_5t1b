package com.otlb.semi.bulletin.model.dao;

import static com.otlb.semi.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.otlb.semi.bulletin.model.exception.BulletinException;
import com.otlb.semi.bulletin.model.vo.Attachment;
import com.otlb.semi.bulletin.model.vo.Board;
import com.otlb.semi.bulletin.model.vo.Notice;

public class BulletinDao {

	private Properties prop = new Properties();
	
	public BulletinDao() {
		String filepath = BulletinDao.class.getResource("/bulletin-query.properties").getPath();
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getCategory());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getEmpNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new BulletinException("게시글 등록 실패", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int selectLastBoardNo(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectLastBoardNo");
		ResultSet rset = null;
		int boardNo = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next())
				boardNo = rset.getInt(1);
		} catch (SQLException e) {
			throw new BulletinException("최근 게시글 번호 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return boardNo;
	}

	public int insertAttachment(Connection conn, Attachment attach) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, attach.getOriginalFilename());
			pstmt.setString(2, attach.getRenamedFilename());
			pstmt.setInt(3, attach.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new BulletinException("첨부파일 등록 오류", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Board> selectAllBoard(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectAllBoard");
		ResultSet rset = null;
		List<Board> list = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board board = new Board();
				
				board.setNo(rset.getInt("no"));
				board.setCategory(rset.getString("category"));
				board.setTitle(rset.getString("title"));
				board.setContent(rset.getString("content"));
				board.setEmpName(rset.getString("emp_name"));
				board.setRegDate(rset.getDate("reg_date"));
				board.setLikeCount(rset.getInt("like_count"));
				board.setReadCount(rset.getInt("read_count"));
				
//				board.setCommentCount(rset.getInt("comment_count"));
				board.setAttachCount(rset.getInt("attach_count"));
				list.add(board);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int selectTotalBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectTotalBoardCount");
		ResultSet rset = null;
		int totalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalCount;
	}

	public List<Notice> selectAllNotice(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectAllNotice");
		ResultSet rset = null;
		List<Notice> list = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice notice = new Notice();
				
				notice.setNo(rset.getInt("no"));
				notice.setTitle(rset.getString("title"));
				notice.setContent(rset.getString("content"));
				notice.setEmpName(rset.getString("emp_name"));
				notice.setRegDate(rset.getDate("reg_date"));
				notice.setReadCount(rset.getInt("read_count"));
				
//				board.setCommentCount(rset.getInt("comment_count"));
//				notice.setAttachCount(rset.getInt("attach_count"));
				list.add(notice);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
}
