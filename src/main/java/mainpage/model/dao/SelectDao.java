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
import mainpage.model.vo.Anonymous_boardVo;
import mainpage.model.vo.BoardVo;
import mainpage.model.vo.NoticeVo;

public class SelectDao {

	private static Properties prop = new Properties();

	public SelectDao() {
		File file = new File(SelectDao.class.getResource("/main-query.prop").getPath());
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
	public static Anonymous_boardVo selectAnonymous_boardContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("anonymous_boardSelect");
		ResultSet rset = null;
		Anonymous_boardVo anonymous_boardVo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				anonymous_boardVo = new Anonymous_boardVo();
				anonymous_boardVo.setTitle(rset.getString("TITLE"));
				anonymous_boardVo.setContent(rset.getString("CONTENT"));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(rset);
			close(pstmt);
		}

		return anonymous_boardVo;
	}

}
