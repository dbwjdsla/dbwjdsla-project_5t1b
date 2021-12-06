package com.otlb.semi.mainpage.model.service;

import java.sql.Connection;


import com.otlb.semi.mainpage.model.dao.SelectDao;
import com.otlb.semi.mainpage.model.vo.AnonymousBoard;
import com.otlb.semi.mainpage.model.vo.Board;
import com.otlb.semi.mainpage.model.vo.FoodMenu;
import com.otlb.semi.mainpage.model.vo.LikeContent;
import com.otlb.semi.mainpage.model.vo.Notice;

import static com.otlb.semi.common.JdbcTemplate.getConnection;
import static com.otlb.semi.common.JdbcTemplate.close;


public class SelectService {
	SelectDao selectDao = new SelectDao();


	// 공지사항 조회
	public Notice selectNoticeContent() {
		Connection conn = getConnection();
		Notice notice = selectDao.selectNoticeContent(conn);
		close(conn);
		return notice;
	}

	// 자유게시판 조회
	public Board selectBoardContent() {
		Connection conn = getConnection();
		Board board = SelectDao.selectBoardContent(conn);
		close(conn);
		return board;
	}

	// 익명 게시판 조회 
	public AnonymousBoard selectAnonymousBoardContent() {
		Connection conn = getConnection();
		AnonymousBoard anonymousBoard = SelectDao.selectAnonymousBoardContent(conn);
		close(conn);
		return anonymousBoard;
	}

	// 인기 게시글 조회 
	public LikeContent selectLikeContent() {
		Connection conn = getConnection();
		LikeContent likeContent = SelectDao.selectLikeContent(conn);
		close(conn);
		return likeContent;
	}

	// 오늘의 메뉴 조회
	public FoodMenu selectFoodMenu() {
		Connection conn = getConnection();
		FoodMenu foodMenu = SelectDao.selectFoodMenu(conn);
		close(conn);
		return foodMenu;
	}

}
