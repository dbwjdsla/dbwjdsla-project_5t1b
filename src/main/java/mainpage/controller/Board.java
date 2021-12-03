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
import mainpage.model.vo.BoardVo;

/**
 * Servlet implementation class Board
 */
@WebServlet("/mainpage/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();
//	List<Board> board = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) 자유게시판 글 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardVo boardVo = selectService.selectBoardContent();

		request.setAttribute("boardVo", boardVo);
		request.getRequestDispatcher("/WEB-INF/views/common/index.jsp").forward(request, response);
	}

}
