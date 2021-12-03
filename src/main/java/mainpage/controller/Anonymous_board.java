package mainpage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainpage.model.service.SelectService;
import mainpage.model.vo.Anonymous_boardVo;

/**
 * Servlet implementation class Anonymous_board
 */
@WebServlet("/mainpage/Anonymous_board")
public class Anonymous_board extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 익명게시판 조회
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Anonymous_boardVo anonymous_boardVo = selectService.selectAnonymous_boardContent();
		
		request.setAttribute("anonymous_boardVo", anonymous_boardVo);
		request.getRequestDispatcher("WEB-INF/views/common/index.jsp").forward(request, response);
	}

}
