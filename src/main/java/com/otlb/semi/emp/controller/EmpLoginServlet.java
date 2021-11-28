package com.otlb.semi.emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.otlb.semi.emp.model.service.EmpService;
import com.otlb.semi.emp.model.vo.Emp;

/**
 * Servlet implementation class EmpLoginServlet
 */
@WebServlet("/emp/login")
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpService();
	
	/**
	 * select * from emp where no
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자입력값처리
		int no = Integer.parseInt(request.getParameter("no"));
		String password = request.getParameter("password");
		//System.out.println(no);
		
		// 2. 업무로직
		Emp emp = empService.selectOneEmp(no);
		System.out.println("[EmpLoginServlet] emp = " + emp);
		
		HttpSession session = request.getSession();
		
		// 로그인 성공여부
		if(emp != null && password.equals(emp.getPassword())) {
			
			// 로그인객체를 session에 저장
			session.setAttribute("loginEmp", emp);
		}
		
		
		
		// 3. 응답처리
		request
			.getRequestDispatcher("/index.jsp")
			.forward(request, response);
			
	}

}
