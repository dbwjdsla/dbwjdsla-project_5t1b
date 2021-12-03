package mainpage.model.dao;

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

import mainpage.controller.Board;
import mainpage.model.vo.AnonymousBoardVo;
import mainpage.model.vo.BoardVo;
import mainpage.model.vo.FoodMenuVo;
import mainpage.model.vo.LikeContentVo;
import mainpage.model.vo.NoticeVo;

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
	public NoticeVo selectNoticeContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("noticeSelect");
		ResultSet rset = null;
		NoticeVo noticeVo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				noticeVo = new NoticeVo();
				noticeVo.setTitle(rset.getString("TITLE"));
				noticeVo.setContent(rset.getString("CONTENT"));
				System.out.println("DAO 확인 " + noticeVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return noticeVo;
	}

	// 자유게시판 조회
	public static BoardVo selectBoardContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("boardSelect");
		ResultSet rset = null;
		BoardVo boardVo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				boardVo = new BoardVo();
				boardVo.setTitle(rset.getString("TITLE"));
				boardVo.setContent(rset.getString("CONTENT"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return boardVo;
	}

	// 익명 게시판 조회
	public static AnonymousBoardVo selectAnonymousBoardContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("anonymousBoardSelect");
		ResultSet rset = null;
		AnonymousBoardVo anonymousBoardVo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				anonymousBoardVo = new AnonymousBoardVo();
				anonymousBoardVo.setTitle(rset.getString("TITLE"));
				anonymousBoardVo.setContent(rset.getString("CONTENT"));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(rset);
			close(pstmt);
		}

		return anonymousBoardVo;
	}

	// 인기 게시글
	public static LikeContentVo selectLikeContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("likeContentSelect");
		ResultSet rset = null;
		LikeContentVo likeContentVo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				likeContentVo = new LikeContentVo();
				likeContentVo.setTitle(rset.getString("TITLE"));
				likeContentVo.setContent(rset.getString("CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return likeContentVo;
	}
	
    // 오늘의 메뉴 조회 
	public static FoodMenuVo selectFoodMenu(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("foodMenuSelect");
		ResultSet rset = null;
		FoodMenuVo foodMenuVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				foodMenuVo = new FoodMenuVo();
				foodMenuVo.setMain(rset.getString("MAIN"));
				foodMenuVo.setSoup(rset.getString("SOUP"));
				foodMenuVo.setSide1(rset.getString("SIDE1"));
				foodMenuVo.setSide2(rset.getString("SIDE2"));
				foodMenuVo.setSide3(rset.getString("SIDE3"));
				foodMenuVo.setDessert(rset.getString("DESSERT"));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return foodMenuVo;
	}

}
