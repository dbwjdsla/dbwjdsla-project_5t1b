package mainpage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainpage.model.service.SelectService;
import mainpage.model.vo.NoticeVo;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/mainpage/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) 공지사항 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeVo noticeVo = selectService.selectContent();
		

		request.setAttribute("noticeVo", noticeVo);
		request.getRequestDispatcher("/WEB-INF/views/common/index.jsp").forward(request, response);

	}

}
