package com.otlb.semi.bulletin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.otlb.semi.bulletin.model.service.BulletinService;
import com.otlb.semi.bulletin.model.vo.Attachment;
import com.otlb.semi.bulletin.model.vo.Board;
import com.otlb.semi.common.AttachFileRenamePolicy;
import com.otlb.semi.common.EmpUtils;

/**
 * Servlet implementation class BoardEnrollServlet
 */
@WebServlet("/board/noticeEnroll")
public class NoticeEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BulletinService bulletinService = new BulletinService();

	/**
	 * insert into notice(no, title, content) values(?, ?, ?)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// A. server computer에 사용자 업로드파일 저장
			String saveDirectory = getServletContext().getRealPath("/upload/board"); // 여기서 /는 webroot 디렉토리
			System.out.println("[BoardEnrollServlet] saveDirectory = " + saveDirectory);
			
			int maxPostSize = 1024 * 1024 * 10; // 10MB //바이트 단위
			String encoding = "utf-8";
			
			// 파일명 재지정 정책 객체
			// DefaultFileRenamePolicy : 동일한 이름의 파일은 numbering을 통해 overwrite을 방지
//			FileRenamePolicy policy = new DefaultFileRenamePolicy();
			FileRenamePolicy policy = new AttachFileRenamePolicy();
			
			MultipartRequest multipartRequest = 
					new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
			
			
			// B. 업로드한 파일 정보를 db에 저장 : attachment테이블 하나당 1행 저장
			
			
			
			// 1. 사용자입력값 처리
			// MultipartRequest객체 생성하는 경우, 기존 request가 아닌 MultipartRequest객체에서 값을 가져와야 한다.
			//String category = multipartRequest.getParameter("category");
			String title = multipartRequest.getParameter("title");
			String content = multipartRequest.getParameter("content");
			int empNo = Integer.parseInt(multipartRequest.getParameter("empNo"));
			
			Board board = new Board();
			//board.setCategory(category);
			board.setTitle(title);
			board.setContent(content);
			board.setEmpNo(empNo);
			
			System.out.println("[BoardEnrollServlet] board = " + board);
			
			// 2. 업무로직
			int result = bulletinService.insertNotice(board);
			String msg = result > 0 ? "게시물 등록 성공" : "게시물 등록 실패";
			
			// 3. 응답요청
			request.getSession().setAttribute("msg", msg);
			String location = request.getContextPath() + "/notice/noticeView?no=" + board.getNo();
			response.sendRedirect(location);
		} catch (NumberFormatException | IOException e) {
			throw e;
		}
	}

}
