package com.otlb.semi.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otlb.semi.emp.model.service.EmpService;
import com.otlb.semi.emp.model.vo.Emp;

/**
 * Servlet implementation class EmpListViewServlet
 */
@WebServlet("/emp/empInfoView")
public class EmpInfoViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			Emp emp = empService.selectOneEmp(no);
			
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/WEB-INF/views/emp/empInfoView.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		
		}
	}

}
