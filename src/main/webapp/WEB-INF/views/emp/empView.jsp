<%@page import="com.otlb.semi.emp.model.vo.Department" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/navbar.jsp" %>
<section id=enroll-container>
	<h2>회원 정보</h2>
	<form id="empUpdateFrm" method="post">
		<table>
			<tr>
				<th>사원명</th>
				<td>
					<%= loginEmp.getEmpName() %>
				</td>
			</tr>
			<tr>
				<th>사원번호</th>
				<td>
					<%= loginEmp.getNo() %>
				</td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password" id="password" value="<%= loginEmp.getPassword() %>" required>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%= loginEmp.getPhone() %>" required><br>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%= loginEmp.getEmail() %>" required><br>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>	
				<%= loginEmp.getBirthdate() %>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<input type="radio" name="gender" id="gender0" value="M" <%= "M".equals(loginEmp.getGender()) ? "checked" : "" %> readonly>
				<label for="gender0">남</label>
				<input type="radio" name="gender" id="gender1" value="F" <%= "F".equals(loginEmp.getGender()) ? "checked" : "" %> readonly>
				<label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				<th>부서</th>
				<td>	
				<%= loginEmp.getDeptName()%>
				</td>
			</tr>
		 	<tr>
				<th>직급</th>
				<td>	
				<%= loginEmp.getJobName() %>
				</td>
			</tr>
		</table>
        <input type="button" onclick="updateProfileimg();" value="사진변경"/>
        <input type="button" onclick="updateEmp();" value="정보수정"/>
        <input type="button" onclick="updatePassword();" value="비밀번호변경"/>
	</form>
</section>

<script>
const updateEmp = () => {
	// 폼의 action값을 할당후 제출!
	$(empUpdateFrm)
		.attr("action", "<%= request.getContextPath() %>/emp/empUpdate")
		.submit();
};

/**
 * #memberUpdateFrm 유효성검사
 * - 비번 영문자/숫자 4글자이상
 * - 이름 한글 2글자 이상
 * - 전화번호 숫자확인
 */
$(empUpdateFrm).submit((e) => {
	
	/* password
	const $password = $(password);
	const $passwordCheck = $(passwordCheck);
	
	if(!/^[a-zA-Z0-9!@#$]{4,}$/.test($password.val())){
		alert("유효한 패스워드를 입력하세요.");
		return false;
	}
	if($password.val() != $passwordCheck.val()){
		alert("패스워드가 일치하지 않습니다.");
		return false;
	} */
	
	//phone
	const $phone = $(phone);
	if(!/^010[0-9]{8}$/.test($phone.val())){
		alert("유효한 전화번호가 아닙니다.");
		return false;
	}
	return true;
});

</script>
<%@ include file="/WEB-INF/views/common/navbar.jsp" %>
