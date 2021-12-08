// $(document).ready(function(boardViewURL, profileURL, chatURL, msgURL){


function setPopovers(contextPath, targetEmpNo, tag, targetEmpName, loginEmpNo, loginEmpName) {

const contents = `<a href="${contextPath + '/' }">게시글 보기</a><br><a href="${contextPath + '/emp/empInfoView?empNo=' + targetEmpNo}">프로필 보기</a><br><a href="javascript:fnGoOtoChat(${loginEmpNo}, ${targetEmpNo}, 'S', ${loginEmpName}, ${targetEmpName}, '1:1')">1:1대화</a><br><a href="${contextPath + '/message/messageForm?senderNo=' + targetEmpNo}">쪽지 보내기</a>`;

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

function setPopover(contextPath, targetEmpNo, tag, targetEmpName, loginEmpNo, loginEmpName) {

//const contents = `<a href="${contextPath + '/' }">게시글 보기</a><br><a href="${contextPath + '/emp/empInfoView?empNo=' + targetEmpNo}">프로필 보기</a><br><a href="${contextPath + '/'  }">1:1대화</a><br><a href="${contextPath + '/message/messageForm?senderNo=' + targetEmpNo}">쪽지 보내기</a>`;
//const contents = `<a href="${contextPath + '/' }">게시글 보기</a><br><a href="${contextPath + '/emp/empInfoView?empNo=' + targetEmpNo}">프로필 보기</a><br><a href="fnGoOtoChat(${loginEmpNo}, ${targetEmpNo}, 'S', ${loginEmpName}, ${targetEmpName}, '1:1')">1:1대화</a><br><a href="${contextPath + '/message/messageForm?senderNo=' + targetEmpNo}">쪽지 보내기</a>`;
const contents = `<a href="${contextPath + '/' }">게시글 보기</a><br><a href="${contextPath + '/emp/empInfoView?empNo=' + targetEmpNo}">프로필 보기</a><br><div id="oto" onclick="alert("asdf");">1:1대화</div><a href="${contextPath + '/message/messageForm?senderNo=' + targetEmpNo}">쪽지 보내기</a>`;

	$(tag).css("cursor", "pointer");
	$(tag).click(function() {
	$('[data-toggle="popover"]').popover({content: contents, delay: 0, placement: "bottom", html: true});

	});
}