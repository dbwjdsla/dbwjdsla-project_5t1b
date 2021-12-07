<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%@ page import="com.otlb.semi.bulletin.model.vo.*"%>
<%@ page import="com.otlb.semi.foodMenu.model.vo.FoodMenu"%>
<%@ page import="com.otlb.semi.mainpage.model.vo.AnonymousBoard"%>
<%@ page import="com.otlb.semi.emp.controller.*"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/navbar.jsp"%>


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
						List<Notice> noticeList = (List<Notice>) session.getAttribute("noticeList");
						%>
						<div class="card-body">
							<!-- 공지사항 내용 띄울 부분 -->
							<%
							for (Notice notice : noticeList) {
							%>
							<p>
								<a href="<%=request.getContextPath()%>/notice/noticeview %>" onclick="check()">[<%= notice.getTitle() %>] : <%= notice.getContent() %></a>
							</p>
							<hr>
							<%
							}
							%>


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
						List<Board> boardList = (List<Board>) session.getAttribute("boardList");
						
						%>

						<div class="card-body">
							<!-- 자유게시판 내용 띄울 부분 -->
							<%
							for (Board board : boardList) {
							%>
							<p>
								<a href="<%=request.getContextPath() %>/board/boardView?no=<%= board.getNo() %>" onclick="check()">[<%= board.getTitle() %>] : <%= board.getContent() %></a>

							</p>
							<hr>
							<%
							}
							%>
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
						List<BoardEntity> likeContentList = (List<BoardEntity>) session.getAttribute("likeContentList");
						%>

						<div class="card-body">
							<!-- 인기게시글 내용 띄울 부분 -->
							<%
							for (BoardEntity likeContent : likeContentList) {
							%>
							<p>
								<a href="<%=request.getContextPath()%>/board/boardList" onclick="check()">[<%= likeContent.getTitle() %>]
									: <%= likeContent.getContent() %></a>
							</p>
							<hr>
							<%
							}
							%>
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
						List<AnonymousBoard> anonymousBoardList = (List<AnonymousBoard>) session.getAttribute("anonymousBoardList");
						%>

						<div class="card-body">
							<!-- 익명 게시판 내용 띄울 부분 -->
							<%
							for (AnonymousBoard anonymousBoard : anonymousBoardList) {
							%>
							<p>
								<a href="<%=request.getContextPath()%>/anonymousBoard/anonymousBoardList" onclick="check()">[<%= anonymousBoard.getTitle() %>]
									: <%= anonymousBoard.getContent() %></a>
							</p>
							<hr>
							<%
							}
							%>
						</div>
					</div>
				</div>
				<!-- 캘린더 & 오늘의 메뉴 부분-->
				<div class="col-lg-6 mb-4">

					<!-- 캘린더 부분 			
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								캘린더 <i class="far fa-calendar-check"></i>
							</h6>
						</div>
						<div class="card-body">
						</div>
					</div>
				 -->

					<!-- 오늘의 메뉴 부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								오늘의 메뉴 <i class="fas fa-utensils"></i>

							</h6>
						</div>
						<%
						FoodMenu foodMenu = (FoodMenu) session.getAttribute("foodMenu");
						%>
						<div class="card-body">

							<p style="list-style-type: none; text-align: center;">[밥]</p>
							<p style="text-align: center;"><%=foodMenu.getMain() %></p>
							<p style="list-style-type: none; text-align: center;">[국]</p>
							<p style="text-align: center;"><%=foodMenu.getSoup() %></p>
							<p style="list-style-type: none; text-align: center;">[반찬]</p>
							<p style="text-align: center;"><%=foodMenu.getSide1() %></p>
							<p style="text-align: center;"><%=foodMenu.getSide2() %></p>
							<p style="text-align: center;"><%=foodMenu.getSide3() %></p>
							<p style="list-style-type: none; text-align: center;">[디저트]</p>
							<p style="text-align: center;"><%=foodMenu.getDessert() %></p>


						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</div>
	</div>


<!-- 로그인 안하고 게시글 클릭시 alert 창    -->
	<%
	Emp emp = (Emp) session.getAttribute("loginEmp");
	%>
	<script>
		function check() {
	<%if (emp == null) {%>
		alert('로그인 후 이용해주세요');
	<%}%>
	
		};
	</script>



	<!--Endof Main Content -->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>