<%@page import="java.util.List"%>
<%@page import="com.otlb.semi.bulletin.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	List<Board> list = (List<Board>) request.getAttribute("list"); 
	String searchType = request.getParameter("searchType");
	String searchKeyword = request.getParameter("searchKeyword");
%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/navbar.jsp"%>

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css"
	rel="stylesheet">

<!-- Custom styles for this page -->
<link href="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

<style>
div#search-container {margin:0 0 10px 0; padding:3px; width:100%; text-align:center;}
div#search-title {display: <%= searchType == null || "title".equals(searchType) ? "inline-block" : "none" %>;}
</style>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">공지사항</h1>
	<div>
		<a class="btn btn-light btn-icon-split"
			href="<%=request.getContextPath()%>/board/noticeForm">
			<span>
			<i class="fas fa-envelope fa-fw"></i>글쓰기</span>
		</a>
		<p class="mb-4">공지사항 입니다.</p>

		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
					<%
						for (Board board : list) {
					%>
						<tr>
							<td><%= board.getNo()%></td>
							<td><a href="<%= request.getContextPath()%>/board/noticeView?no=<%= board.getNo()%>">
								<%= board.getTitle()%></a>
							</td>
							<td><%= board.getEmp().getEmpName() %></td>
							<td><%= board.getRegDate() %></td>
							<td><%= board.getReadCount() %></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
				<div id="search-container">
		        <select id="searchType">
		            <option value="title" <%= "title".equals(searchType) ? "selected" : "" %>>제목</option>		
		        </select>
		        <div id="search-title" class="search-type">
		            <form action="<%=request.getContextPath()%>/board/noticeFinder">
		                <input type="hidden" name="searchType" value="title"/>
		                <input type="text" name="searchKeyword" value="<%= "title".equals(searchType) ? searchKeyword : "" %>" size="25" placeholder="검색할 제목을 입력하세요."/>
		                <button type="submit" class="btn btn-light btn-icon-split">검색
		                <i class="fa fa-search" aria-hidden="true"></i></button>			
		            </form>	
		        </div>
				<div id="pageBar"><%= request.getAttribute("pagebar") %></div>
			</div>
		</div>
	</div>
</div>
<!-- </div>
</div>
</div> -->


<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready
				to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="login.html">Logout</a>
			</div>
		</div>
	</div>
</div>


<!-- Bootstrap core JavaScript-->
<script
	src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script
	src="<%=request.getContextPath()%>/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script
	src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script
	src="<%=request.getContextPath()%>/resources/vendor/datatables/jquery.dataTables.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script
	src="<%=request.getContextPath()%>/resources/js/demo/datatables-demo.js"></script>

</body>

</html>
