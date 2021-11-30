<%@page import="com.otlb.semi.emp.model.vo.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>5T1b - Mypage</title>

<!-- Custom fonts for this template-->
<link
	href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.js"></script>

</head>

<body class="mypage" id="mypage">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="p-5">
							<div class="text-center">
								<br /> <br />
								<h1 class="h4 text-gray-900 mb-4">회원정보</h1>
							</div>
							<div class="row">
								<div class="col-lg-6 d-none d-lg-block bg-mypage-image">
									<p>
										프사프사 넣을예정 <br /> <br /> <br /> <br /> <br /> <br />
									</p>
									<input type="button" class="btn btn-primary btn-user btn-block"
										onclick="updateProfileimg();" value="사진변경" />
								</div>
								<div class="col-lg-6">
									<form id="empUpdateFrm"
										atcion="<%=request.getContextPath()%>/emp/empView"
										method="POST">
										<div class="form-group">
											<p>
												사원명 :
												<%=loginEmp.getEmpName()%></p>
										</div>
										<div class="form-group">
											<p>
												사원번호 :
												<%=loginEmp.getNo()%></p>
										</div>
										<div class="form-group">
											<p>
												비밀번호 :<input type="password" name="password"
													class="form-control form-control-user"
													value="<%=loginEmp.getPassword()%>" required>
											</p>
										</div>
										<div class="form-group">
											<p>
												전화번호 :<input type="tel" placeholder="(-없이)01012345678"
													name="phone" maxlength="11"
													class="form-control form-control-user"
													value="<%=loginEmp.getPhone()%>" required>
											</p>
										</div>
										<div class="form-group">
											<p>
												이메일 :<input type="email" placeholder="abc@5t1b.com"
													name="email" class="form-control form-control-user"
													value="<%=loginEmp.getEmail()%>" required>
											</p>
										</div>
										<div class="form-group">
											<p>
												생년월일 :
												<%=loginEmp.getBirthdate()%></p>
										</div>
										<div class="form-group">
											<input type="radio" name="gender" id="gender0" value="M"
												<%="M".equals(loginEmp.getGender()) ? "checked" : ""%>
												readonly> <label for="gender0">남</label> <input
												type="radio" name="gender" id="gender1" value="F"
												<%="F".equals(loginEmp.getGender()) ? "checked" : ""%>
												readonly> <label for="gender1">여</label>
										</div>
										<div class="form-group">
											<p>
												부서 :<%=loginEmp.getDeptName()%></p>
										</div>
										<div class="form-group">
											<p>
												직급 :<%=loginEmp.getJobName()%></p>
										</div>
										<input type="button"
											class="btn btn-primary btn-user btn-block"
											onclick="updatePassword();" value="비밀번호변경" /> 
										<input type="button" 
											class="btn btn-primary btn-user btn-block"
											onclick="updateEmp();" value="정보수정" />
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

<script>
const updateEmp = () => {
	$(empUpdateFrm)
		.attr("action", "<%=request.getContextPath()%>/emp/empUpdate")
		.submit();
};

/**
 * 유효성검사
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

</body>
</html>