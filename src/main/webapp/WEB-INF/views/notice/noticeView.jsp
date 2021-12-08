<%@page import="com.otlb.semi.emp.model.service.EmpService"%>
<%@page import="com.otlb.semi.bulletin.model.vo.BoardComment"%>
<%@page import="java.util.List"%>
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
	        <div class="container-fluid">
		    	<button class="btn btn-primary btn-icon-split" onclick="moveBoardList();">목록</button>
<%
	if(EmpService.ADMIN_ROLE.equals(loginEmp.getEmpRole())){
%>			
				<button class="btn btn-primary btn-icon-split" onclick="updateBoard();">수정</button>
		    	<button class="btn btn-primary btn-icon-split" onclick="deleteBoard();">삭제</button>
<%
	}
%>			
					
				<hr class="sidebar-divider my-3">
			</div>
			 <div class="container-fluid" id="titleContent">
			 	<p>공지사항</p>
		 		<h5 style="font-weight: bold;"><%= board.getTitle() %></h5>
			 	<span class="empPopover" data-toggle="popover" style="font-weight: bold;">관리자</span>
			 	<span>조회<%= board.getReadCount() %></span>
			 	<span><%= regDate %></span>
			 </div>
			 <br />
			 <div class="container-fluid" id="Content" style="margin: 10px">
			 	<span><%= content %></span>
			 </div>
			 <form 
				action="<%= request.getContextPath() %>/board/boardDelete" 
				name="boardDeleteFrm"
				method="POST">
				<input type="hidden" name="boardNo" value="<%= board.getNo() %>"/>
			</form>


<script src="<%= request.getContextPath() %>/js/empPopup.js"></script>
<script>
	setPopover("<%= request.getContextPath() %>", "게시글보기 링크", "프로필 보기 링크", "대화 링크", "쪽지 보내기 링크");
</script>
<script>
//삭제하기 버튼
function deleteBoard() {
	if(confirm("이 게시물을 정말 삭제하시겠습니까?")){
		$(document.boardDeleteFrm).submit();		
	}
}
//수정하기 버튼
function updateBoard() {
	location.href = "<%= request.getContextPath() %>/board/boardUpdate?no=<%= board.getNo() %>";
}
//게시판 리스트로 돌아가는 함수
function moveBoardList() {
	location.href = "<%= request.getContextPath()%>/board/noticeList";
}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>