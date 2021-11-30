<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//	check parameters
	String otoSenderId	=	(String)request.getAttribute("otoSenderId");
	String otoReceiverId=	(String)request.getAttribute("otoReceiverId");
	String otoSRTp		=	(String)request.getAttribute("otoSRTp");
	String thisUserId	=	"";
	String targetUserId	=	"";
	
	if(otoSRTp.equals("S")){
		thisUserId		=	otoSenderId;
		targetUserId	=	otoReceiverId;		
	}else{
		thisUserId		=	otoReceiverId;
		targetUserId	=	otoSenderId;		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 대화방</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"/>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<style>
	
   .chat_wrap { border:none; solid #999;font-size:13px; color:#333}
   .chat_wrap .chatwith{display: flex; padding-left:10px; background-color:#0394fc; height:40px; color:white; align-items:center; font-weight: bolder;}
   .chat_wrap img{border-radius:50px; padding:5px}
   .chat_wrap .inner{padding: 12px; background-color:white; overflow-y:scroll; height:380px;}
   ::-webkit-scrollbar {display: none;}
   .chat_wrap .item{margin-top:15px}
   .chat_wrap .item:first-child{margin-top:0px}
   .chat_wrap .item .box{display:inline-block; max-width:180px; position:relative}
   .chat_wrap .item .box::before{content:""; position:absolute; left:-8px; top:9px; border-top:0px solid transparent; border-bottom:8px solid transparent;border-right:8px solid #0394fc;}
   .chat_wrap .item .box .msg {background:#0394fc; color: white; border-radius:5px; padding:8px; text-align:left}
   .chat_wrap .item .box .time {font-size:11px; color:#999; position:absolute; right: -75px; bottom:5px; width:70px}
   .chat_wrap .item.mymsg{text-align:right; }
   .chat_wrap .item.mymsg .box::before{left:auto; right:-8px; border-left:8px solid #d1d7e0; border-right:0;}
   .chat_wrap .item.mymsg .box .msg{background:#d1d7e0; color:black;}
   .chat_wrap .item.mymsg .box .time{right:auto; left:-75px}
   .chat_wrap .item .box{transition:all .3s ease-out; margin:0 0 0 20px;opacity:0}
   .chat_wrap .item.mymsg .box{transition:all .3s ease-out; margin:0 20px 0 0;}
   .chat_wrap .item.on .box{margin:0; opacity: 1;} 
  	
	
   input[type="text"]{margin-top: 20px; margin-left:10px; border:0; width:270px;background:#ddd; border-radius:5px; height:30px; padding-left:10px; box-sizing:border-box;}
   input[type="text"]::placeholder{color:#999; display:inline;}
	button{border: none; display:inline; background-color:white;}
	button i {color:#0394fc; width:30px; height:30px;}

</style>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<script src="https://kit.fontawesome.com/01809a491f.js" crossorigin="anonymous"></script>
<script>
/**
 * websocket client설정
 */
const ws = new WebSocket(`ws://\${location.host}<%= request.getContextPath() %>/otoChatWebsocket?otoSenderId=<%= otoSenderId %>&otoReceiverId=<%= otoReceiverId %>&otoSRTp=<%= otoSRTp %>`);
ws.onopen = (e) => {
	console.log("open!", e);
};
ws.onmessage = (e) => {
	console.log("message!", e);
	const msg = JSON.parse(e.data);
	msgToHtml(msg);
};
ws.onerror = (e) => {
	console.log("error!", e);
};
ws.onclose = (e) => {
	console.log("close!", e);
};

const msgToHtml = ({type, msg, sender,receiver, time}) => {

	//	여기서 송수신이 일치할때만 출력한다 
	if(sender == "<%=targetUserId%>"){
		const timeHandler = (time) => {
			const d = new Date(time);
			return `\${d.getMonth() + 1}-\${d.getDate()} \${d.getHours()}:\${d.getMinutes()}`;
		};

		setText1(msg);
	}
	
};

const msgToHtml2 = ({type, msg, sender,receiver, time}) => {
	//	자신이 입력하는 것은 무조건 보이게 처리한다  
	const timeHandler = (time) => {
		const d = new Date(time);
		return `\${d.getMonth() + 1}-\${d.getDate()} \${d.getHours()}:\${d.getMinutes()}`;
	};
	
	setText2();
};
 function setText2(){
	 var _val = $("#sendingMsg").val();

     var _class ="mymsg";
     $(this).val('');
	 var _tar = $(".chat_wrap .inner").append('<div class="item '+_class+'"><div class="box"><p class="msg">'+_val+'</p><span class="time">'+currentTime()+'</span></div></div>');

     var lastItem = $(".chat_wrap .inner").find(".item:last");
     setTimeout(function(){
         lastItem.addClass("on");
     },10);

     var position = lastItem.position().top + $(".chat_wrap .inner").scrollTop();
     console.log(position);

     $(".chat_wrap .inner").stop().animate({scrollTop:position},500);
 }
 
 function setText1(rcvMsg){
	 var _val = rcvMsg;
     var _class = $("#yourmsg").attr("class");
     $(this).val('');
	 var _tar = $(".chat_wrap .inner").append('<div class="item '+_class+'"><div class="box"><p class="msg">'+_val+'</p><span class="time">'+currentTime()+'</span></div></div>');

     var lastItem = $(".chat_wrap .inner").find(".item:last");
     setTimeout(function(){
         lastItem.addClass("on");
     },10);

     var position = lastItem.position().top + $(".chat_wrap .inner").scrollTop();
     console.log(position);

     $(".chat_wrap .inner").stop().animate({scrollTop:position},500);
 }
 
 function sendMsg(){
		//const $sendingMsg = $(sendingMsg);

		//if(!/^(.|\n)+$/.test($sendingMsg.val()))
			//return;
		var sendMsg = $("#sendingMsg").val();
		const msg = {
			type: "message",
			msg: sendMsg,
			sender: "<%= thisUserId %>",
			receiver : "<%= targetUserId %>",
			time: Date.now()
		};
		// 자신의 창은 그대로 출력하게 조치 
		msgToHtml2(msg);
		// 전송처리 
		const jsonStr = JSON.stringify(msg);
		ws.send(jsonStr); // 웹소켓 통해 전송
 }
</script>
    <script>
        $(function(){
            $("input[type='text']").keypress(function(e){
                if(e.keyCode == 13 && $(this).val().length){
                	sendMsg();
                }
            });

        });
        
        var currentTime = function(){
            var date = new Date();
            var hh = date.getHours();
            var mm = date.getMinutes();
            var apm = hh >12 ? "오후":"오전";
            var ct = apm + " "+hh+":"+mm+"";
            return ct;
        }

    </script>

</head>
<body>
	<div class="chat-container"></div>
	    <div class="chat_wrap">
	    <div class="chatwith">
	    <img src="<%=request.getContextPath()%>/honggd.png" width=30px; height=30px; />
		<% if(otoSRTp.equals("S")){ %>
		<h1><%= request.getAttribute("otoReceiverNm") %>(<%= request.getAttribute("otoReceiverId") %>)</h1>
		<% }else{ %>
		<h1><%= request.getAttribute("otoSenderNm") %>(<%= request.getAttribute("otoSenderId") %>)</h1>
		<% } %>
	</div>
        <div class="inner">&nbsp;</div>
        <input type="text" name="sendingMsg" id="sendingMsg" placeholder="내용 입력">
        <button type="button" name="sendmsg" id="sendmsg" onclick=sendMsg();><i class="fas fa-paper-plane" alt="전송"></i></button>
    </div>

</body>
</html>