package com.otlb.semi.mainpage.model.dao;

import static com.otlb.semi.common.JdbcTemplate.close;

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

import com.otlb.semi.mainpage.model.vo.AnonymousBoard;
import com.otlb.semi.mainpage.model.vo.Board;
import com.otlb.semi.mainpage.model.vo.FoodMenu;
import com.otlb.semi.mainpage.model.vo.LikeContent;
import com.otlb.semi.mainpage.model.vo.Notice;



public class SelectDao {

	private static Properties prop = new Properties();

	public SelectDao() {
		File file = new File(SelectDao.class.getResource("/main-query.properties").getPath());
		try {
			prop.load(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 공지사항 조회
	public List<Notice> selectNoticeContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("noticeSelect");
		ResultSet rset = null;
		List<Notice> noticeList = new ArrayList<>();
		Notice notice = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				notice= new Notice();
				notice.setTitle(rset.getString("TITLE"));
				notice.setContent(rset.getString("CONTENT"));
				
				noticeList.add(notice);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return noticeList;
	}


	// 자유게시판 조회
	public static List<Board> selectBoardContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("boardSelect");
		ResultSet rset = null;
		List<Board> boardList = new ArrayList<>();
		Board board = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				board = new Board();
				board.setTitle(rset.getString("TITLE"));
				board.setContent(rset.getString("CONTENT"));
				boardList.add(board);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}

		return boardList;
	}

	// 익명 게시판 조회
	public static List<AnonymousBoard> selectAnonymousBoardContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("anonymousBoardSelect");
		ResultSet rset = null;
		List<AnonymousBoard> anonymousBoardList = new ArrayList<>();
		AnonymousBoard anonymousBoard = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				anonymousBoard = new AnonymousBoard();
				anonymousBoard.setTitle(rset.getString("TITLE"));
				anonymousBoard.setContent(rset.getString("CONTENT"));
				anonymousBoardList.add(anonymousBoard);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(rset);
			close(pstmt);
		}

		return anonymousBoardList;
	}

	// 인기 게시글
	public static List<LikeContent> selectLikeContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("likeContentSelect");
		ResultSet rset = null;
		List<LikeContent> likeContentList = new ArrayList<>();
		LikeContent likeContent = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				likeContent= new LikeContent();
				likeContent.setTitle(rset.getString("TITLE"));
				likeContent.setContent(rset.getString("CONTENT"));
				likeContentList.add(likeContent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return likeContentList;
	}
	
    // 오늘의 메뉴 조회 
	public static FoodMenu selectFoodMenu(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("foodMenuSelect");
		ResultSet rset = null;
		FoodMenu foodMenu = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				foodMenu = new FoodMenu();
				foodMenu.setMain(rset.getString("MAIN"));
				foodMenu.setSoup(rset.getString("SOUP"));
				foodMenu.setSide1(rset.getString("SIDE1"));
				foodMenu.setSide2(rset.getString("SIDE2"));
				foodMenu.setSide3(rset.getString("SIDE3"));
				foodMenu.setDessert(rset.getString("DESSERT"));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return foodMenu;
	}

}
