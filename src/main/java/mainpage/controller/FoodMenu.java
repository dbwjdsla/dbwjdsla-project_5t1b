package mainpage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainpage.model.service.SelectService;
import mainpage.model.vo.FoodMenuVo;

/**
 * Servlet implementation class FoodMenu
 */
@WebServlet("/mainpage/FoodMenu")
public class FoodMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();
	
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 오늘의 메뉴 조회 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 FoodMenuVo foodMenuVo = selectService.selectFoodMenu();
		 
		 request.setAttribute("foodMenuVo", foodMenuVo);
		 request.getRequestDispatcher("/WEB-INF/views/common/index.jsp").forward(request, response);
	}

	

}
