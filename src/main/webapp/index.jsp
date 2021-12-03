<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/navbar.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="mainpage.model.vo.*" %>



<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

	<!-- Main Content -->
	<div id="content">

		<!-- Begin Page Content -->
		<div class="container-fluid">


			<div class="row" style="flex-wrap: nowrap; margin-right: 22.8rem;">


				<!-- 공지사항 & 자유 게시판 부분  -->
				<div class="col-lg-6 mb-4">

					<!-- 공지사항 부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								공지사항 <i class="fas fa-thumbtack"></i>
							</h6>
						</div>
						<%
						NoticeVo noticeVo = (NoticeVo) request.getAttribute("noticeVo");
						%>
						<div class="card-body">
					    <a href="<%= request.getContextPath() %>/mainpage/Notice"></a>
							<!-- 공지사항 내용 띄울 부분 -->
							<ul>
							<li><%= noticeVo.getTitle()%>:<%= noticeVo.getContent() %></li>
							<li><%= noticeVo.getTitle()%>:<%= noticeVo.getContent() %></li>
							<li><%= noticeVo.getTitle()%>:<%= noticeVo.getContent() %></li>
							<li><%= noticeVo.getTitle()%>:<%= noticeVo.getContent() %></li>
							<li><%= noticeVo.getTitle()%>:<%= noticeVo.getContent() %></li>
							</ul>
						</div>
					</div>

					<!-- 자유게시판 부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								자유게시판 <i class="fas fa-users"></i>
							</h6>
						</div>
						<%
						BoardVo boardVo = (BoardVo) request.getAttribute("boardVo");
						%>
						<div class="card-body">
						<a href="<%= request.getContextPath() %>/mainpage/Board"></a>
							<!-- 자유게시판 내용 띄울 부분 -->
							<ul>
							<li><%= boardVo.getTitle() %>:<%= boardVo.getContent() %></li>
							<li><%= boardVo.getTitle() %>:<%= boardVo.getContent() %></li>
							<li><%= boardVo.getTitle() %>:<%= boardVo.getContent() %></li>
							<li><%= boardVo.getTitle() %>:<%= boardVo.getContent() %></li>
							<li><%= boardVo.getTitle() %>:<%= boardVo.getContent() %></li>
							</ul>
						</div>
					</div>
				</div>


				<!-- 인기게시글 & 익명 게시판 부분  -->
				<div class="col-lg-6 mb-4">

					<!-- 인기게시글 부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								인기게시글 <i class="far fa-thumbs-up"></i>
							</h6>
						</div>
						<%
						LikeContentVo likeContentVo = (LikeContentVo) request.getAttribute("likeContentVo");
						%>
						<div class="card-body">
						<a href="<%= request.getContextPath() %>/mainpage/likeContent"></a>
							<!-- 인기게시글 내용 띄울 부분 -->
							<ul>
							<li><%= likeContentVo.getTitle()%>:<%= likeContentVo.getContent() %></li>
							<li><%= likeContentVo.getTitle()%>:<%= likeContentVo.getContent() %></li>
							<li><%= likeContentVo.getTitle()%>:<%= likeContentVo.getContent() %></li>
							<li><%= likeContentVo.getTitle()%>:<%= likeContentVo.getContent() %></li>
							<li><%= likeContentVo.getTitle()%>:<%= likeContentVo.getContent() %></li>
							</ul>
						</div>
					</div>

					<!-- 익명게시판부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								익명게시판 <i class="fas fa-user-secret"></i>
							</h6>
						</div>
						<%
						AnonymousBoardVo anonymousBoardVo = (AnonymousBoardVo) request.getAttribute("anonymousBoardVo");
						%>
						<div class="card-body">
						<a href="<%= request.getContextPath() %>/mainpage/Anonymous_board"></a>
							<!-- 익명 게시판 내용 띄울 부분 -->
							<ul>
							<li><%= anonymousBoardVo.getTitle()%>:<%= anonymousBoardVo.getContent()%></li>
							<li><%= anonymousBoardVo.getTitle()%>:<%= anonymousBoardVo.getContent()%></li>
							<li><%= anonymousBoardVo.getTitle()%>:<%= anonymousBoardVo.getContent()%></li>
							<li><%= anonymousBoardVo.getTitle()%>:<%= anonymousBoardVo.getContent()%></li>
							<li><%= anonymousBoardVo.getTitle()%>:<%= anonymousBoardVo.getContent()%></li>
							</ul>
						</div>
					</div>

				</div>
				<!-- 캘린더 & 오늘의 메뉴 부분-->
				<div class="col-lg-6 mb-4">

					<!-- 캘린더 부분  -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								캘린더 <i class="far fa-calendar-check"></i>
							</h6>
						</div>
						<div class="card-body">


						</div>
					</div>

					<!-- 오늘의 메뉴 부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								오늘의 메뉴 <i class="fas fa-utensils"></i>
							</h6>
						</div>
						<%
						FoodMenuVo foodMenuVo = (FoodMenuVo)request.getAttribute("foodMenuVo");
						%>
						<div class="card-body">
						<a href="<%= request.getContextPath() %>/mainpage/FoodMenu"></a>
							<ul>
							<li><%= foodMenuVo.getMain() %></li>
							<li><%= foodMenuVo.getSoup() %></li>
							<li><%= foodMenuVo.getSide1() %></li>
							<li><%= foodMenuVo.getSide2() %></li>
							<li><%= foodMenuVo.getSide3() %></li>
							<li><%= foodMenuVo.getDessert() %></li>							
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

		</div>

	</div>
	<!-- End of Main Content -->

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>