package com.otlb.semi.mainpage.model.service;

import java.sql.Connection;
import java.util.List;

import com.otlb.semi.mainpage.model.dao.SelectDao;
import com.otlb.semi.mainpage.model.vo.AnonymousBoardVo;
import com.otlb.semi.mainpage.model.vo.BoardVo;
import com.otlb.semi.mainpage.model.vo.FoodMenuVo;
import com.otlb.semi.mainpage.model.vo.LikeContentVo;
import com.otlb.semi.mainpage.model.vo.NoticeVo;

import static com.otlb.semi.common.JdbcTemplate.getConnection;
import static com.otlb.semi.common.JdbcTemplate.close;


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
