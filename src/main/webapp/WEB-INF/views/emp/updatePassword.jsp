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
								<h1 class="h4 text-gray-900 mb-4">비밀번호 변경</h1>
							<!-- <div class="row">
								<div class="col-lg-6 d-none d-lg-block bg-mypage-image">
									<p>
										프사프사 넣을예정 <br /> <br /> <br /> <br /> <br /> <br />
									</p>
									<input type="button" class="btn btn-primary btn-user btn-block"
										onclick="updateProfileimg();" value="사진변경" />
								</div> -->
								<div class="col-lg-pp">
									<form id="updatePwdFrm"
										atcion="<%=request.getContextPath()%>/emp/updatePassword"
										method="POST">
										<div class="form-group">
											<p>
												현재 비밀번호 :<input type="password" name="oldpassword"
													class="form-control form-control-user" required>
											</p>
										</div>
										<div class="form-group">
											<p>
												새로운 비밀번호 :<input type="password" name="newpassword"
													class="form-control form-control-user" required>
											</p>
										</div>
										<!-- <input type="button"
											class="btn btn-primary btn-user btn-block"
											onclick="updatePassword();" value="비밀번호변경" /> --> 
										<input type="button" 
											class="btn btn-primary btn-user btn-block"
											onclick="updatePassword();" value="변경" />
									</form>
							</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

</body>
</html>