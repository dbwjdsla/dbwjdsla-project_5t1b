package com.otlb.semi.mainpage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.mainpage.model.service.SelectService;
import com.otlb.semi.mainpage.model.vo.FoodMenu;



/**
 * Servlet implementation class FoodMenu
 */
@WebServlet("/mainpage/FoodMenu")
public class FoodMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectService selectService = new SelectService();
	
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 오늘의 메뉴 조회 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 FoodMenu foodMenu = selectService.selectFoodMenu();
		 
		 request.setAttribute("foodMenu", foodMenu);
		 request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	

}
