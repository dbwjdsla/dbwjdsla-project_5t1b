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
	 * set password = ?, gender = ?, phone = ?, email = ?
	 * where no = ?
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = request.getContextPath();
		String msg = null;
		int result = 0;
		
		HttpSession session = request.getSession();
		Emp loginEmp = (Emp) session.getAttribute("loginEmp");
		
		// 사용자입력값 처리
		int no = loginEmp.getEmpNo();
		String oldPassword = request.getParameter("oldpassword");
		String newPassword = request.getParameter("newpassword");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		// 기존 비밀번호 비교		
		if(oldPassword.equals(loginEmp.getPassword())) {
			
			//업무로직
			loginEmp.setPassword(newPassword);
			loginEmp.setGender(gender);
			loginEmp.setPhone(phone);
			loginEmp.setEmail(email);
			result = empService.updateEmp(loginEmp);
			msg = (result > 0) ? "회원정보 수정 성공!" : "회원정보 수정 실패!";
		}
		else {
			msg = "비밀번호가 일치하지 않습니다.";
		}
		// 리다이렉트처리
		session.setAttribute("msg", msg);
		
		location = request.getContextPath() + "/emp/empView";
		response.sendRedirect(location);	
	
	}

}

