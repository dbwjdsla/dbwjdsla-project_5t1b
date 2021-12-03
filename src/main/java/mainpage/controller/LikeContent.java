package mainpage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainpage.model.service.SelectService;
import mainpage.model.vo.LikeContentVo;

/**
 * Servlet implementation class LikeContent
 */
@WebServlet("/mainpage/likeContent")
public class LikeContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 인기 게시글 조회 
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LikeContentVo likeContentVo = selectService.selectLikeContent();
		
		request.setAttribute("likeContentVo", likeContentVo);
		request.getRequestDispatcher("/WEB-INF/views/common/index.jsp").forward(request, response);
	}

}
