<%@page import="com.otlb.semi.bulletin.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<body id="page-top">

<%@ include file="/WEB-INF/views/common/navbar.jsp"%>
<%
	Board board  = (Board) request.getAttribute("board");
	String regDate = (String) request.getAttribute("regDate");
	String content = (String) request.getAttribute("content");	
%>

 		<!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
	        <div class="container">
		    	<button class="btn btn-primary btn-icon-split" onclick="moveBoardList();">목록</button>
				<hr class="sidebar-divider my-3">
			</div>
			 <div class="container-fluid" id="titleContent">
			 	<p>자유게시판</p>
		 		<h5 style="font-weight: bold;">[<%= board.getCategory() %>] <%= board.getTitle() %></h5>
			 	<span><%= board.getEmp().getEmpName() %>(<%= board.getEmp().getDeptName() %>)</span>
			 	<span>추천수<%= board.getLikeCount() %></span>
			 	<span>조회<%= board.getReadCount() %></span>
			 	<span><%= regDate %></span>
			 </div>
			 <br />
			 <div class="container-fluid" id="Content">
			 	<span><%= content %></span>
			 </div>
			  <div class="container-fluid" id="commentContent">
			 	<span>댓글</span>
			 </div>
<script>
function moveList() {
	location.href = "<%= request.getContextPath()%>/board/moveBoardList";
}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>