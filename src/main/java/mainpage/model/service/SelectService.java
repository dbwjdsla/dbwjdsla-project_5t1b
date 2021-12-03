package mainpage.model.service;

import java.sql.Connection;
import java.util.List;
import static com.otlb.semi.common.JdbcTemplate.getConnection;
import static com.otlb.semi.common.JdbcTemplate.close;

import mainpage.controller.Board;
import mainpage.model.dao.SelectDao;
import mainpage.model.vo.Anonymous_boardVo;
import mainpage.model.vo.BoardVo;
import mainpage.model.vo.NoticeVo;

public class SelectService {
	SelectDao selectDao = new SelectDao();

	// 공지사항 조회
	public NoticeVo selectContent() {
		Connection conn = getConnection();
		NoticeVo noticeVo = selectDao.selectNoticeContent(conn);
		close(conn);
		return noticeVo;
	}

	// 자유게시판 조회
	public BoardVo selectBoardContent() {
		Connection conn = getConnection();
		BoardVo boardVo = SelectDao.selectBoardContent(conn);
		close(conn);
		return boardVo;
	}

	// 익명 게시판 조회 
	public Anonymous_boardVo selectAnonymous_boardContent() {
		Connection conn = getConnection();
		Anonymous_boardVo anonymous_boardVo = SelectDao.selectAnonymous_boardContent(conn);
		close(conn);
		return anonymous_boardVo;
	}

}
