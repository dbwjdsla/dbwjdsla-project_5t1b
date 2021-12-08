// $(document).ready(function(boardViewURL, profileURL, chatURL, msgURL){


function setPopovers(contextPath, empNo, tag) {

const contents = `<a href="${contextPath + '/' }">게시글 보기</a><br><a href="${contextPath + '/emp/empInfoView?empNo=' + empNo}">프로필 보기</a><br><a href="${contextPath + '/'  }">1:1대화</a><br><a href="${contextPath + '/message/messageForm?senderNo=' + empNo}">쪽지 보내기</a>`;

	$(tag).css("cursor", "pointer");
	$(tag).click(function() {
		const $empPopovers = $(".empPopover");
		$empPopovers.each((i, elem) => {
			const $elem = $(elem);
			$elem.popover('hide');
		});
		$('[data-toggle="popover"]').popover({content: contents, delay: 0, placement: "bottom", html: true});
	});
}

function setPopover(contextPath, empNo, tag) {

const contents = `<a href="${contextPath + '/' }">게시글 보기</a><br><a href="${contextPath + '/emp/empInfoView?empNo=' + empNo}">프로필 보기</a><br><a href="${contextPath + '/'  }">1:1대화</a><br><a href="${contextPath + '/message/messageForm?senderNo=' + empNo}">쪽지 보내기</a>`;

	$(tag).css("cursor", "pointer");
	$(tag).click(function() {
	$('[data-toggle="popover"]').popover({content: contents, delay: 0, placement: "bottom", html: true});

	});
}

function setPopoversBoard(contextPath, empNo,empNm,rcvEmpNo,rcvEmpNm, tag) {
const contents = `<a href="${contextPath + '/' }">게시글 보기</a><br><a href="${contextPath + '/emp/empInfoView?empNo=' + empNo}">프로필 보기</a><br><a href="#" class="otoChat">1:1대화</a><br><a href="${contextPath + '/message/messageForm?senderNo=' + empNo}">쪽지 보내기</a>`;

   $(tag).css("cursor", "pointer");
   $(tag).click(function() {
      const $empPopovers = $(".empPopover");
      $empPopovers.each((i, elem) => {
         const $elem = $(elem);
         $elem.popover('hide');
      });
      $('[data-toggle="popover"]').popover({content: contents, delay: 0, placement: "bottom", html: true});
      
      //   click event 
      $("[data-toggle='popover']").on('shown.bs.popover', function(){
            var btns = document.getElementsByClassName("otoChat");
          
         for (var i=0; i < btns.length; i++) {
              btns[i].onclick = function() { 
               fnGoOtoChat(empNo,rcvEmpNo,'S',empNm,rcvEmpNm,'1:1');
            };
           }      
      });
   });
}

