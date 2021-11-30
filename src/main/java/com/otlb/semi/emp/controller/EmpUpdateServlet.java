package com.otlb.semi.emp.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.otlb.semi.emp.model.service.EmpService;
import com.otlb.semi.emp.model.vo.Department;
import com.otlb.semi.emp.model.vo.Emp;
import com.otlb.semi.emp.model.vo.Job;

/**
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet("/emp/empUpdate")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpService();
	
	/**
	 * 회원정보 수정쿼리
	 *  
	 * update emp
	 * set password = ?, phone = ?, email = ?
	 * where no = ?
	 * 
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.인코딩처리
		request.setCharacterEncoding("utf-8");
		
		// 2.사용자입력값 처리 사용자입력값 -> Member VO객체 생성
		int no = Integer.parseInt(request.getParameter("no"));
		String empName = request.getParameter("empName");
		String password = request.getParameter("password");
		String _birthdate = request.getParameter("birthdate"); 
		String deptCode = request.getParameter("deptCode");
		String jobCode = request.getParameter("jobCode");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		
		Date birthdate = null;
		if(!"".equals(_birthdate))
			birthdate = Date.valueOf(_birthdate);
		
		Emp emp = 
				new Emp(no, empName, password, birthdate, deptCode, jobCode, null, gender, email, phone, null, null);
		System.out.println("emp@servlet = " + emp);
		
		// 3.업무로직 요청 : 서비스객체의 updateMember호출 & Member객체 전달
		int result = empService.updateEmp(emp);
		String msg = (result > 0) ? "회원정보 수정 성공!" : "회원정보 수정 실패!";
		
		// 4.리다이렉트처리 및 사용자메세지 준비
		HttpSession session = request.getSession();
		session.setAttribute("msg", msg);
		
		String location = request.getContextPath() + "/emp/empView";
		response.sendRedirect(location);
		
	
	}

}

