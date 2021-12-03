package mainpage.model.service;

import java.sql.Connection;
import java.util.List;
import static com.otlb.semi.common.JdbcTemplate.getConnection;
import static com.otlb.semi.common.JdbcTemplate.close;

import mainpage.controller.Board;
import mainpage.model.dao.SelectDao;
import mainpage.model.vo.AnonymousBoardVo;
import mainpage.model.vo.BoardVo;
import mainpage.model.vo.FoodMenuVo;
import mainpage.model.vo.LikeContentVo;
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
	public AnonymousBoardVo selectAnonymousBoardContent() {
		Connection conn = getConnection();
		AnonymousBoardVo anonymousBoardVo = SelectDao.selectAnonymousBoardContent(conn);
		close(conn);
		return anonymousBoardVo;
	}

	// 인기 게시글 조회 
	public LikeContentVo selectLikeContent() {
		Connection conn = getConnection();
		LikeContentVo likeContentVo = SelectDao.selectLikeContent(conn);
		close(conn);
		return likeContentVo;
	}

	// 오늘의 메뉴 조회
	public FoodMenuVo selectFoodMenu() {
		Connection conn = getConnection();
		FoodMenuVo foodMenuVo = SelectDao.selectFoodMenu(conn);
		close(conn);
		return foodMenuVo;
	}

}
