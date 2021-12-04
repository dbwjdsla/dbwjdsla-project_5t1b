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
			<div class="container">
        		<button class="btn btn-primary btn-icon-split" onclick="delMessage();">삭제</button>
			</div>
		 	<hr class="sidebar-divider my-3">
            <!-- Main Content -->
            <div id="content">
	 		<div class="row">
	 			<div class="col-sm-12">
	 				<table class="table table-bordered dataTable">
	 					<thead>
                           <tr>
                               <th><input type="checkbox" class="checkAll"/></th>
                               <th>받는사람</th>
                               <th>내용</th>
                               <th>보낸날짜</th>
                               <th>받은날짜</th>
                           </tr>
                         </thead>
                         <tbody>
<%
/* 
	로그인 회원이 보낸 쪽지데이터 출력
*/
List<Message> list = (List<Message>) request.getAttribute("list");
	for(Message message : list){
		if(message.getSenderDelYn().equals("N")){
%>
                         	<tr>
                         		<td><input type="checkbox" name="check" value="<%= message.getNo()%>"/></td>
                         		<td><%= message.getEmp().getEmpName() %></td>
                         		
                         		<td>
                         			<a href="<%= request.getContextPath() %>/message/sentMessageView?no=<%= message.getNo()%>"><%= message.getContent() %></a></td>
                         		<td><%= message.getSentDate() %></td>
                         		<td><%= message.getReadDate() != null ? message.getReadDate() : "읽지 않음" %></td>
                         	</tr>
<% 
		}
	}
 %>
                         </tbody>
 					</table>
	 			</div>
	 		<form
	 		
	 			id = "delFrm"
				name="messageDelFrm"
				method="POST" 
				action="<%= request.getContextPath() %>/message/sentMessageDelete" >
				<input type="hidden" id="no" name="no" value="" />
			</form>	
	 		</div>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
<script>
//메세지 삭제 제어
function delMessage(){
	// 선택된 갯수 
	var count = $("input:checkbox[name=check]:checked").length;  

	//선택한 쪽지가 1개 이상일때
	if(count > 0){
		if(confirm("삭제하시겠습니까?")){
			
			//check박스 요소들 변수 저장
			var check = document.getElementsByName("check");
			//글번호 저장
			var no = "";
			//check박스 전체순회
			for(let i = 0; i < check.length; i++){
				//해당순번의 체크박스가 체크되어 있으면
				if(check[i].checked){
					//,를 구분자로 값을 연결
					no += check[i].value + ",";
				}
			}
			var inputNo = document.getElementById("no");
			//input value에 글번호 대입
			inputNo.value = no;
			console.log("input value: " + inputNo.value);
			$("form[name=messageDelFrm]").submit();	
			//$(document.messageDelFrm).submit();
			
		}
	//선택한 쪽지가 0개일때
	}else{
		alert("선택한 쪽지가 없습니다.");
	}
}

// 체크박스 제어
$(".checkAll").click(function() {
	if($(".checkAll").is(":checked")) $("input[name=check]").prop("checked", true);
	else $("input[name=check]").prop("checked", false);
});

$("input[name=check]").click(function() {
	var total = $("input[name=check]").length;
	var checked = $("input[name=check]:checked").length;
	
	if(total != checked) $(".checkAll").prop("checked", false);
	else $(".checkAll").prop("checked", true); 
});
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>