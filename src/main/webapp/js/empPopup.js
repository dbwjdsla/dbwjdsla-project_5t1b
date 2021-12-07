// $(document).ready(function(boardViewURL, profileURL, chatURL, msgURL){


function setPopovers(contextPath, boardViewURL, profileURL, chatURL, msgURL) {

const contents = `<a href="${contextPath + '/' + boardViewURL}">게시글 보기</a><br><a href="${contextPath + '/' + profileURL}">프로필 보기</a><br><a href="${contextPath + '/' + chatURL}">1:1대화</a><br><a href="${contextPath + '/' + msgURL}">쪽지 보내기</a>`;

	$(".empPopover").css("cursor", "pointer");
	$(".empPopover").click(function() {
		const $empPopovers = $(".empPopover");
		$empPopovers.each((i, elem) => {
			const $elem = $(elem);
			$elem.popover('hide');
		});
		$('[data-toggle="popover"]').popover({content: contents, delay: 0, placement: "bottom", html: true});
	});
}

function setPopover(contextPath, boardViewURL, profileURL, chatURL, msgURL) {

const contents = `<a href="${contextPath + '/' + boardViewURL}">게시글 보기</a><br><a href="${contextPath + '/' + profileURL}">프로필 보기</a><br><a href="${contextPath + '/' + chatURL}">1:1대화</a><br><a href="${contextPath + '/' + msgURL}">쪽지 보내기</a>`;

	$(".empPopover").css("cursor", "pointer");
	$(".empPopover").click(function() {
	$('[data-toggle="popover"]').popover({content: contents, delay: 0, placement: "bottom", html: true});

	});
}