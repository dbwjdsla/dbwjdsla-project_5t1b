<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<script>
	function chatReqCheck() {
		$.ajax({
			url : "<%= request.getContextPath() %>/otochat/otocheckchatreq",
			type : "GET",
			cache : false,
			dataType : "json",
			data : null,
			success : function(data) {
				let checkReq = data.reqYn;
				let otoSenderId = data.otoSenderId;
				let otoReceiverId = data.otoReceiverId;
				let otoSRTp = data.otoSRTp;
				if (checkReq == "Y"){
					goOtoChat(otoSenderId, otoReceiverId, otoSRTp);
				}
			},
			error : function(request, status, error) {
				//alert(request.responseText + ":" + error);
			}
		});
		//setTimeout(chatReqCheck, 5000);
	}
</script>
<script>
function hidestatus(){
window.status=''
return true
}
if (document.layers)
document.captureEvents(Event.MOUSEOVER | Event.MOUSEOUT)
document.onmouseover=hidestatus
document.onmouseout=hidestatus
</script>
<script>
function goOtoChat(otoSenderId, otoReceiverId, otoSRTp){
    var url = "<%= request.getContextPath() %>/otochat/otochatroom?otoSenderId="+otoSenderId+"&otoReceiverId="+otoReceiverId+"&otoSRTp=" +otoSRTp;
    var name = "홍길동님과 1:1 채팅";
	var options = 'top=10, left=10, width=330, height=500, status=no, menubar=no, toolbar=no, resizable=no, titlebar=no, location=no';
    
	var popup2	= window.open(url, name, options);
}
function goOtoChat1(){
    var url = "<%= request.getContextPath() %>/otochat/otochatroom?otoSenderId=202002&otoReceiverId=202103&otoSRTp=S";
    var name = "양소영님과 1:1 채팅";
	var options = "top=10, left=10, width=330, height=500, location=no,status=no, menubar=no, toolbar=no, resizable=no, titlebar=no, location=no";
    
    var popup1	=	window.open(url, name, options);
}

function goOtoChat2(){
    var url = "<%= request.getContextPath() %>/otochat/otochatroom?otoSenderId=202002&otoReceiverId=202103&otoSRTp=R";
    var name = "홍길동님과 1:1 채팅";
	var options = 'top=10, left=10, width=330, height=500, status=no, menubar=no, toolbar=no, resizable=no, titlebar=no, location=no';
    
	var popup2	= window.open(url, name, options);
}
</script>
</head>
<body>
   	1:1 대화방으로 이동을 원하면 클릭하십시오
	
	<input type="button" name="홍길동님이 양소영님과 대화시작하기" value="홍길동님이 양소영님과 대화시작하기" onClick="javascript:goOtoChat1();"/>
	<input type="button" name="양소영님이 홍길동님과 대화시작하기" value="양소영님이 홍길동님과 대화시작하기" onClick="javascript:goOtoChat2();"/>
	
	<input type="button" name="test" value="test" onclick="javascript:chatReqCheck();" />
</body>
</html>