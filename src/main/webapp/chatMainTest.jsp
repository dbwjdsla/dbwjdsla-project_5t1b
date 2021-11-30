<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script>
function goOtoChat(){
    var url = "<%= request.getContextPath() %>/otochat/otochatroom?otoSenderId=202002&otoReceiverId=202103&otoSRTp=S";
    var name = "양소영님과 1:1 채팅";
	var options = 'top=10, left=10, width=330, height=500, status=no, menubar=no, toolbar=no, resizable=no';
    
    var popup1	=	window.open(url, name, options);
}

function goOtoChat2(){
    var url = "<%= request.getContextPath() %>/otochat/otochatroom?otoSenderId=202002&otoReceiverId=202103&otoSRTp=R";
    var name = "홍길동님과 1:1 채팅";
	var options = 'top=10, left=10, width=330, height=500, status=no, menubar=no, toolbar=no, resizable=no';
    
	var popup2	=	window.open(url, name, options);
}


</script>
</head>
<body>
   	1:1 대화방으로 이동을 원하면 클릭하십시오
	
	<input type="button" name="홍길동님이 양소영님과 대화시작하기" value="홍길동님이 양소영님과 대화시작하기" onClick="javascript:goOtoChat();"/>
	<input type="button" name="양소영님이 홍길동님과 대화시작하기" value="양소영님이 홍길동님과 대화시작하기" onClick="javascript:goOtoChat2();"/>
	
	
</body>
</html>