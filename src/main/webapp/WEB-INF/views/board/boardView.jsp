<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<body id="page-top">

<%@ include file="/WEB-INF/views/common/navbar.jsp"%>


 		<!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
	        <div class="container">
		    	<button class="btn btn-primary btn-icon-split" onclick="moveBoardList();">목록</button>
				<hr class="sidebar-divider my-3">
			</div>
			 <div class="container-fluid" id="titleContent">
			 	<span>자유게시판</span>
			 	<br />
			 	<span></span>
			 </div>
<script>
function moveList() {
	location.href = "<%= request.getContextPath()%>/board/moveBoardList";
}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>