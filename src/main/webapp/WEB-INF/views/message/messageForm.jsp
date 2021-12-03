<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

			<div class="my-2"></div>
			
            <!-- 쪽지보내기 버튼 -->
            <a class="btn btn-light btn-icon-split" href="<%=request.getContextPath()%>/message/messageForm">            
                <span class="text"><i class="fas fa-envelope fa-fw"></i>쪽지쓰기</span>
               </a>
           	<div class="my-2"></div>
            

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

           

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/message/messageList" >
                    <i class="fa fa-envelope-open"></i>
                    <span>받은쪽지함</span>
                </a>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/message/sentMessageList" >
                    <i class="fa fa-paper-plane"></i>
                    <span>보낸쪽지함</span>
                </a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

        </ul>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
	        <form 
	        	action="<%= request.getContextPath() %>/message/messageEnroll"
	        	method="POST">
	        	<div class="container">
					<input type="submit" value="보내기" class="btn btn-primary btn-icon-split"/>
				</div>
			 	<hr class="sidebar-divider my-3">
	            <!-- Main Content -->
	            <div id="content">
		 		
	                <!-- Begin Page Content -->
	                <div class="container">
						<span class="text">받는사람</span>
						<input type="text" class="form-control form-control-sm" name="sender"/>
	                    <textarea 
	                    	name="content" id="textContent" cols="30" rows="10"
	                    	class="form-control"
                    		style="resize: none; margin-top: 10px"></textarea>
                    		<div class="counter" style="float: right;">
								<span id="count">0</span><span>/500</span>
                    		</div>
	                </div>
	                <!-- /.container-fluid -->
					
	            </div>
	            
			</form>
            <!-- End of Main Content -->
<script>
/* 쪽지 쓰기 500자 제한 코드 */
$(document).ready(function() {
	$('#textContent').on('keyup', function() {
		console.log($(this).val().length);
		
		$('#count').html($(this).val().length);
		
		if($(this).val().length > 500) {
			alert("500자까지만 입력할 수 있습니다.");
            $(this).val($(this).val().substring(0, 500));
            $('#count').html("500");
        }
	});
});

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>