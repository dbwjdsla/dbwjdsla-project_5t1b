<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.otlb.semi.mainpage.model.vo.*" %>
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
						//Notice notice = (Notice) request.getAttribute("notice");
						Notice notice = new Notice();
						notice.setTitle("testdate");
						%>
						<div class="card-body">
							<!-- 공지사항 내용 띄울 부분 -->
							<ul>
							<li><%= notice.getTitle()%><%= notice.getContent() %></li>
							<li><%= notice.getTitle()%><%= notice.getContent() %></li>
							<li><%= notice.getTitle()%><%= notice.getContent() %></li>
							<li><%= notice.getTitle()%><%= notice.getContent() %></li>
							<li><%= notice.getTitle()%><%= notice.getContent() %></li>
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
						//Board board = (Board) request.getAttribute("board");
						Board board = new Board();
						board.setTitle("testdate");
						%>
						
						<div class="card-body" <a href="<%= request.getContextPath() %>/mainpage/Board"></a>>
							<!-- 자유게시판 내용 띄울 부분 -->
							
							< <ul>
							<li><%= board.getTitle() %><%= board.getContent() %></li>
							<li><%= board.getTitle() %><%= board.getContent() %></li>
							<li><%= board.getTitle() %><%= board.getContent() %></li>
							<li><%= board.getTitle() %><%= board.getContent() %></li>
							<li><%= board.getTitle() %><%= board.getContent() %></li>
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
						//LikeContent likeContent = (LikeContent) request.getAttribute("likeContent");
						LikeContent likeContent = new LikeContent();
						likeContent.setTitle("testdata");
						%>

						<div class="card-body" <a href="<%= request.getContextPath() %>/mainpage/likeContent"></a>>
							<!-- 인기게시글 내용 띄울 부분 -->
							<ul>
							<li><%= likeContent.getTitle()%><%= likeContent.getContent() %></li>
							<li><%= likeContent.getTitle()%><%= likeContent.getContent() %></li>
							<li><%= likeContent.getTitle()%><%= likeContent.getContent() %></li>
							<li><%= likeContent.getTitle()%><%= likeContent.getContent() %></li>
							<li><%= likeContent.getTitle()%><%= likeContent.getContent() %></li>
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
						//AnonymousBoard anonymousBoard = (AnonymousBoard) request.getAttribute("anonymousBoard");
						AnonymousBoard anonymousBoard = new AnonymousBoard();
						anonymousBoard.setTitle("testdata");
						%>
						<div class="card-body" <a href="<%= request.getContextPath() %>/mainpage/Anonymous_board"></a>>
							<!-- 익명 게시판 내용 띄울 부분 -->
							<ul>
							<li><%= anonymousBoard.getTitle()%><%= anonymousBoard.getContent()%></li>
							<li><%= anonymousBoard.getTitle()%><%= anonymousBoard.getContent()%></li>
							<li><%= anonymousBoard.getTitle()%><%= anonymousBoard.getContent()%></li>
							<li><%= anonymousBoard.getTitle()%><%= anonymousBoard.getContent()%></li>
							<li><%= anonymousBoard.getTitle()%><%= anonymousBoard.getContent()%></li>
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
						//FoodMenu foodMenu = (FoodMenu)request.getAttribute("foodMenu");
						
						%>
						<div class="card-body" <a href="<%= request.getContextPath() %>/mainpage/FoodMenu"></a>>
							
						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</div>
	</div>
	
	<script>
	// li 태그(게시물) 클릭시 로그인이 안되어있다면 경고창 후 로그인 으로 포커스
	$( 'li' ).click( function() {
  if(loginEmp = null){
	  alert('로그인 후 이용 해주세요');
	  $('.btn btn-sm btn-primary shadow-sm').focus();
  }
} );
	
	</script>
	<!-- End of Main Content -->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>