<%@page import="com.otlb.semi.message.model.vo.Message"%>
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
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
	 		<div class="row">
	 			<div class="col-sm-12">
	 				<table class="table table-bordered dataTable">
	 					<thead>
                           <tr>
                               <th><input type="checkbox" id="allCheck"/></th>
                               <th>보낸사람</th>
                               <th>내용</th>
                               <th>날짜</th>
                           </tr>
                         </thead>
                         <tbody>
<%
/* 
	로그인 회원이 받은 쪽지데이터 출력
*/
List<Message> list = (List<Message>) request.getAttribute("list");
	for(Message message : list){
%>
                         	<tr>
                         		<td><input type="checkbox" /></td>
                         		<td><%= message.getEmp().getEmpName() %></td>
                         		<td><%= message.getContent() %></td>
                         		<td><%= message.getSentDate() %></td>
                         	</tr>
<% 
	}
 %>
                         </tbody>
 					</table>
	 			</div>
	 		
	 		</div>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
<script>

	/**
     * 전체체크박스 -> 개별체크박스 제어
     */ 
	function checkAllSubject(checkAll){
        const subjects = document.querySelectorAll("[type=checkbox]");
        
        for(let i = 0; i < subjects.length; i++){
          subjects[i].checked = checkAll.checked;
          manageTdClassOn(subjects[i], checkAll.checked);
        }
     }
  
  
    /**
     * 개별체크박스 -> 전체체크박스 제어
     */ 
    function checkSubject(subject){
        //1. 부모td
		manageTdClassOn(subject, subject.checked);
		
		// 2. 전체체크박스 제어
		const subjects = document.querySelectorAll("[type=checkbox]");
		for(let i = 0; i < subjects.length; i++){
		  if(!subjects[i].checked) {
		    checkAll2.checked = false;
		    return;
		  }
		}
		checkAll2.checked = true;
    }

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>