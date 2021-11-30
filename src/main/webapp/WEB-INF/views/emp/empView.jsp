<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/navbar.jsp" %>
<section id=enroll-container>
	<h2>회원 정보</h2>
	<form id="memberUpdateFrm" method="post">
		<table>
			<tr>
				<th>사원명</th>
				<td>
					<input type="text" name="empName" id="empName" value="<%= loginEmp.getEmpName() %>" readonly>
				</td>
			</tr>
			<tr>
				<th>사원번호</th>
				<td>
					<input type="text" name="empNo" id="empNo" value="<%= loginEmp.getNo() %>" readonly>
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
					<input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%= loginEmp.getEmail() %>"><br>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>	
				<input type="text" name="birthday" id="birthday" value="<%= loginEmp.getBirthdate() %>"><br>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>	
				<input type="text" name="gender" id="gender" value="<%= loginEmp.getGender() %>"><br>
				</td>
			</tr>
			<tr>
				<th>부서</th>
				<td>	
				<input type="text" name="department" id="department" value="<%= loginEmp.getDeptCode() %>"><br>
				</td>
			</tr>
			<tr>
				<th>직급</th>
				<td>	
				<input type="text" name="rank" id="rank" value="<%= loginEmp.getJobCode() %>"><br>
				</td>
			</tr>
		</table>
        <input type="button" onclick="updateProfileimg();" value="사진변경"/>
        <input type="button" onclick="updateMember();" value="정보수정"/>
        <input type="button" onclick="updatePassword();" value="비밀번호변경"/>
	</form>
</section>

<%@ include file="/WEB-INF/views/common/navbar.jsp" %>

