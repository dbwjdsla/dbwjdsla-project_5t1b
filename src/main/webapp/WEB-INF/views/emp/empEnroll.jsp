<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>5T1B - 회원가입</title>

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

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">회원가입</h1>
							</div>
							<form 
								class="user" 
								action="<%= request.getContextPath() %>/emp/empEnroll" 
								method="POST">
								<div class="form-group">	
									<input value="202103" type="text" name="no" class="form-control form-control-user"
										id="exampleFirstName" placeholder="사원번호" autocomplete="off">									
								</div>
								<div class="form-group">	
									<input value="홍길동" type="text" name="empName" class="form-control form-control-user"
										id="" placeholder="이름" autocomplete="off">									
								</div>
								<div class="form-group">
									<input value="hong@naver.com" type="email" name="email" class="form-control form-control-user"
										id="exampleInputEmail" placeholder="이메일" autocomplete="off">
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input value="1234" type="password" name="password" class="form-control form-control-user"
											id="exampleInputPassword" placeholder="비밀번호" autocomplete="off">
									</div>
									<div class="col-sm-6">
										<input value="1234" type="password" name="passwordCheck" class="form-control form-control-user"
											id="" placeholder="비밀번호 확인" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<input value="01022223333" type="text" name="phone" class="form-control form-control-user"
										id="" placeholder="전화번호" autocomplete="off">
								</div>
								<div class="form-group">
									<select name="jobCode" id="jobCode" class="form-control rounded-pill" style="height:49px; font-size: .8rem;">
										<option value="" disabled hidden>직급</option>
										<option value="J8" selected>인턴</option>
										<option value="J7">사원</option>
										<option value="J6">대리</option>
										<option value="J5">과장</option>
										<option value="J4">차장</option>
										<option value="J3">부장</option>
										<option value="J2">부사장</option>
										<option value="J1">사장</option>
									</select>
								</div>
								<div class="form-group">
									<select name="deptCode" id="deptCode" class="form-control rounded-pill" style="height:49px; font-size: .8rem;">
										<option value="" disabled hidden>부서명</option>
										<option value="SL" selected>영업부</option>
										<option value="DV">개발부</option>
										<option value="HR">인사부</option>
										<option value="GA">총무부</option>
									</select>
								</div>
								<div class="form-group">
									<select name="gender" id="gender" class="form-control rounded-pill" style="height:49px; font-size: .8rem;">
										<option value=""  disabled hidden>성별</option>
										<option value="F" selected>여자</option>
										<option value="M">남자</option>
									</select>
								</div>
								
								<label for="year">생일</label>
								<div class="form-group">
									<div class="row">
										<div class="col">
											<select name="birthdayYear" id="year" class="form-control rounded-pill" style="height:49px; font-size: .8rem;">
											<option value=""  disabled hidden>년</option>
											<option value="2021" selected>2021</option>
											<option value="2020">2020</option>
											<option value="2019">2019</option>
											<option value="2018">2018</option>
											<option value="2017">2017</option>
											<option value="2016">2016</option>
											<option value="2015">2015</option>
											<option value="2014">2014</option>
											<option value="2013">2013</option>
											<option value="2012">2012</option>
											<option value="2011">2011</option>
											<option value="2010">2010</option>
											<option value="2009">2009</option>
											<option value="2008">2008</option>
											<option value="2007">2007</option>
											<option value="2006">2006</option>
											<option value="2005">2005</option>
											<option value="2004">2004</option>
											<option value="2003">2003</option>
											<option value="2002">2002</option>
											<option value="2001">2001</option>
											<option value="2000">2000</option>
											<option value="1999">1999</option>
											<option value="1998">1998</option>
											<option value="1997">1997</option>
											<option value="1996">1996</option>
											<option value="1995">1995</option>
											<option value="1994">1994</option>
											<option value="1993">1993</option>
											<option value="1992">1992</option>
											<option value="1991">1991</option>
											<option value="1990">1990</option>
											<option value="1989">1989</option>
											<option value="1988">1988</option>
											<option value="1987">1987</option>
											<option value="1986">1986</option>
											<option value="1985">1985</option>
											<option value="1984">1984</option>
											<option value="1983">1983</option>
											<option value="1982">1982</option>
											<option value="1981">1981</option>
											<option value="1980">1980</option>
											<option value="1979">1979</option>
											<option value="1978">1978</option>
											<option value="1977">1977</option>
											<option value="1976">1976</option>
											<option value="1975">1975</option>
											<option value="1974">1974</option>
											<option value="1973">1973</option>
											<option value="1972">1972</option>
											<option value="1971">1971</option>
											<option value="1970">1970</option>
											<option value="1969">1969</option>
											<option value="1968">1968</option>
											<option value="1967">1967</option>
											<option value="1966">1966</option>
											<option value="1965">1965</option>
											<option value="1964">1964</option>
											<option value="1963">1963</option>
											<option value="1962">1962</option>
											<option value="1961">1961</option>
											<option value="1960">1960</option>
											<option value="1959">1959</option>
											<option value="1958">1958</option>
											<option value="1957">1957</option>
											<option value="1956">1956</option>
											<option value="1955">1955</option>
											<option value="1954">1954</option>
											<option value="1953">1953</option>
											<option value="1952">1952</option>
											<option value="1951">1951</option>
											<option value="1950">1950</option>
											<option value="1949">1949</option>
											<option value="1948">1948</option>
											<option value="1947">1947</option>
											<option value="1946">1946</option>
											<option value="1945">1945</option>
											<option value="1944">1944</option>
											<option value="1943">1943</option>
											<option value="1942">1942</option>
											<option value="1941">1941</option>
											<option value="1940">1940</option>
											<option value="1939">1939</option>
											<option value="1938">1938</option>
											<option value="1937">1937</option>
											<option value="1936">1936</option>
											<option value="1935">1935</option>
											<option value="1934">1934</option>
											<option value="1933">1933</option>
											<option value="1932">1932</option>
											<option value="1931">1931</option>
											<option value="1930">1930</option>
											<option value="1929">1929</option>
											<option value="1928">1928</option>
											<option value="1927">1927</option>
											<option value="1926">1926</option>
											<option value="1925">1925</option>
											<option value="1924">1924</option>
											<option value="1923">1923</option>
											<option value="1922">1922</option>
											<option value="1921">1921</option>
											<option value="1920">1920</option>
											<option value="1919">1919</option>
											<option value="1918">1918</option>
											<option value="1917">1917</option>
											<option value="1916">1916</option>
											<option value="1915">1915</option>
											<option value="1914">1914</option>
											<option value="1913">1913</option>
											<option value="1912">1912</option>
											<option value="1911">1911</option>
											<option value="1910">1910</option>
											<option value="1909">1909</option>
											<option value="1908">1908</option>
											<option value="1907">1907</option>
											<option value="1906">1906</option>
											<option value="1905">1905</option>
										</select> 
										</div>
										<div class="col">
											<select name="birthdayMonth" id="month" class="form-control rounded-pill" style="height:49px; font-size: .8rem;">
											<option value=""  disabled hidden>월</option>
											<option value="1" selected>1월</option>
											<option value="2">2월</option>
											<option value="3">3월</option>
											<option value="4">4월</option>
											<option value="5">5월</option>
											<option value="6">6월</option>
											<option value="7">7월</option>
											<option value="8">8월</option>
											<option value="9">9월</option>
											<option value="10">10월</option>
											<option value="11">11월</option>
											<option value="12">12월</option>
										</select> 
										</div>
										<div class="col">
											<select name="birthdayDay" id="day" class="form-control rounded-pill" style="height:49px; font-size: .8rem;">
											<option value=""  disabled hidden>일</option>
											<option value="1" selected>1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
											<option value="31">31</option>
										</select>
										</div>
									</div>
								</div>
								

								<input type="submit" value="가입하기" class="btn btn-primary btn-user btn-block" />
								
								<!-- 
								 <hr>
								<a href="index.html" class="btn btn-google btn-user btn-block">
									<i class="fab fa-google fa-fw"></i> Register with Google
								</a> <a href="index.html"
									class="btn btn-facebook btn-user btn-block"> <i
									class="fab fa-facebook-f fa-fw"></i> Register with Facebook
								</a>
								 -->
							</form>
							<hr>
							<!-- 
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                             -->
							<div class="text-center">
								<a class="small" href="<%= request.getContextPath() %>/emp/login">로그인</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%
	String messageType = null;
	String messageContent = null;
	if(session.getAttribute("messageType") != null 
			&& session.getAttribute("messageContent") != null){
		messageType = (String) session.getAttribute("messageType");
		messageContent = (String) session.getAttribute("messageContent");
	}
	if(messageType != null) {
%>
	<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" >
		<div class="vertical-alignment-helper">
			<div class="modal-dialog vertical-align-center">
			
			
			</div>
		</div>
	</div>
<%
	}
%>
	
	
	
	

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

</body>

</html>