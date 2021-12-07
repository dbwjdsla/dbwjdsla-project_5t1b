package com.otlb.semi.mainpage.model.service;

import java.sql.Connection;
import java.util.List;

import com.otlb.semi.mainpage.model.dao.SelectDao;
import com.otlb.semi.bulletin.model.vo.Board;
import com.otlb.semi.bulletin.model.vo.Notice;
import com.otlb.semi.foodMenu.model.vo.FoodMenu;
import com.otlb.semi.mainpage.model.vo.AnonymousBoard;
import com.otlb.semi.bulletin.model.vo.*;

import static com.otlb.semi.common.JdbcTemplate.getConnection;
import static com.otlb.semi.common.JdbcTemplate.close;

public class SelectService {
	SelectDao selectDao = new SelectDao();

	// 공지사항 조회
	public List<Notice> selectNoticeContent() {
		Connection conn = getConnection();
		List<Notice> noticeList = selectDao.selectNoticeContent(conn);
		close(conn);
		return noticeList;
	}

	// 자유게시판 조회
	public List<Board> selectBoardContent() {
		Connection conn = getConnection();
		List<Board> boardList = SelectDao.selectBoardContent(conn);
		close(conn);
		return boardList;
	}

	// 익명 게시판 조회
	public List<AnonymousBoard> selectAnonymousBoardContent() {
		Connection conn = getConnection();
		List<AnonymousBoard> anonymousBoardList = SelectDao.selectAnonymousBoardContent(conn);
		close(conn);
		return anonymousBoardList;
	}

	// 인기 게시글 조회
	public List<BoardEntity> selectLikeContent() {
		Connection conn = getConnection();
		List<BoardEntity> likeContentList = SelectDao.selectLikeContent(conn);
		close(conn);
		return likeContentList;
	}

	// 오늘의 메뉴 조회
	public FoodMenu selectFoodMenu() {
		Connection conn = getConnection();
		FoodMenu foodMenu = SelectDao.selectFoodMenu(conn);
		close(conn);
		return foodMenu;
	}

}
