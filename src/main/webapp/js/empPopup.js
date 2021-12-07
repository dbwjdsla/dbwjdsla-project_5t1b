// $(document).ready(function(boardViewURL, profileURL, chatURL, msgURL){

function setPopover(contextPath, boardViewURL, profileURL, chatURL, msgURL) {

	const contents = `<a href="${contextPath + '/' + boardViewURL}">게시글 보기</a><br><a href="${profileURL}">프로필 보기</a><br><a href="${chatURL}">1:1대화</a><br><a href="${msgURL}">쪽지 보내기</a>`;
	$(".empPopover").css("cursor", "pointer");
	$(".empPopover").click(function() {
		$('[data-toggle="popover"]').popover({content: contents, delay: 0, placement: "bottom", html: true});
	});
}