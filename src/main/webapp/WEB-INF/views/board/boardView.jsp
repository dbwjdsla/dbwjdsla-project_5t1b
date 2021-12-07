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
				<hr class="sidebar-divider my-3">
			</div>
			 <div class="container-fluid" id="titleContent">
			 	<p>자유게시판</p>
		 		<h5 style="font-weight: bold;">[<%= board.getCategory() %>] <%= board.getTitle() %></h5>
			 	<span class="empPopover" data-toggle="popover" ><%= board.getEmp().getEmpName() %>(<%= board.getEmp().getDeptName() %>)</span>
			 	<span>추천수<%= board.getLikeCount() %></span>
			 	<span>조회<%= board.getReadCount() %></span>
			 	<span><%= regDate %></span>
			 </div>
			 <br />
			 <div class="container-fluid" id="Content">
			 	<span><%= content %></span>
			 </div>
			  <div class="container-fluid" id="commentContent">
			 	<span>댓글 <%= board.getCommentCount() %></span>
			 	<hr class="sidebar-divider my-3">
<% 
	List<BoardComment> commentList = (List<BoardComment>) request.getAttribute("boardCommentList");
	List<String> commentListContent = (List<String>) request.getAttribute("commentListContent");
	List<String> commentListDate = (List<String>) request.getAttribute("commentListDate");
	if(commentList != null && !commentList.isEmpty()){
%>
				<table>
<%
		for(int i = 0; i < commentList.size(); i++){
		//for(BoardComment bc : commentList){
			BoardComment bc = commentList.get(i);
			String commentDate = commentListDate.get(i);
			String commentContent = commentListContent.get(i);
			
			if(bc.getCommentLevel() == 1){
%>				
					<tr class="level1">
						<td>
							<sub class="comment-writer"><%= bc.getEmp().getEmpName() %>(<%= bc.getEmp().getDeptName() %>)</sub>
							<sub class="comment-date"><%= commentDate %></sub>
							<br />
							<!-- 댓글내용 -->
							<%= commentContent %>
						</td>
						<td>
							<button class="btn btn-primary btn-icon-split" id="btn-reply" value="<%= bc.getNo()%>">답글</button>
						</td>
					</tr>
<%
			} else{
%>
					<tr class="level2">
						<td>
							<sub class="comment-writer"><%= bc.getEmp().getEmpName() %>(<%= bc.getEmp().getDeptName() %>)</sub>
							<sub class="comment-date"><%= commentDate %></sub>
							<br />
							<!-- 댓글내용 -->
							<%= commentContent %>
						</td>
					</tr>

<% 
			}
		}
%>
			

				</table>
<%
	}
%>
			 </div>
			 

<script src="<%= request.getContextPath() %>/js/empPopup.js">
</script>
<script>
setPopover("<%= request.getContextPath() %>", "게시글보기 링크", "프로필 보기 링크", "대화 링크", "쪽지 보내기 링크");

//게시판 리스트로 돌아가는 함수
function moveBoardList() {
	location.href = "<%= request.getContextPath()%>/board/boardList";
}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>