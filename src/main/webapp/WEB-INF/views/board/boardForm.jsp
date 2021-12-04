<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/navbar.jsp"%>

<!-- Bootstrap core JavaScript-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

<script>
window.onload = () => {
	title.focus();
};
</script>
<div class="container">
	<!-- Outer Row -->
	<div class="row justify-content-center">
		<div class="col-xl-10 col-lg-12 col-md-9">
			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
					<div class="p-5">
						<br />
						<div class="form-group">
							<div class="row ">
								<div class="col-7">자유 게시판 글쓰기</div>

								<div class="col-2">
									<input type="button" value="임시 저장"
										class="btn btn-primary btn-user btn-block"
										style="font-size: .8rem;" />
								</div>
								<div class="col-3">
									<button class="btn btn-primary btn-user btn-block"
										style="font-size: .8rem;">임시 저장 글 블러오기</button>
								</div>
							</div>
							<br />
							<form id="loginFrm" class="user" action="" method="POST">
								<div class="row">
									<div class="col-2 form-group">
										<select class="form-control">
											<option value="" class="dropdown-item">사담</option>
											<option value="">취미</option>
										</select> 									
									</div>
									<div class="col-10 form-group">
										<input type="text" class="form-control" id="title" placeholder="제목">									
									</div>
								</div>

								<div class="row">
									<div class="form-group col-12">
										<label for="textContent">내용</label>
										<textarea name="content" id="textContent" cols="30" rows="12"
											placeholder="내용을 입력해주세요." class="form-control"
											style="resize: none;"></textarea>
										<div class="counter" style="float: right;">
											<span id="count">0</span><span>/3000</span>
										</div>
									</div>
								</div>

								<!-- 첨부파일 -->
								<div class="form-group">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<button class="btn btn-danger" type="button"
												style="width: 50px;" id="button-addon1">-</button>
										</div>
										<div class="custom-file">
											<input type="file" class="w-70 custom-file-input" id="inputGroupFile01"
												aria-describedby="button-addon1" value="" style="cursor:pointer;"/>
												 <label class="custom-file-label" for="inputGroupFile01" >클릭해서 파일 추가하기</label>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<button class="btn btn-primary" type="button"
												style="width: 50px;" id="button-addon2">+</button>
										</div>
										<div class="custom-file">
											<input type="file" class="w-70 custom-file-input" id="inputGroupFile02"
												aria-describedby="button-addon2" value="" style="cursor:pointer;"/>
												 <label class="custom-file-label" for="inputGroupFile02" >클릭해서 파일 추가하기</label>
										</div>
									</div>
								</div>


								<br /> <br />
								<div class="form-group">
									<div class="row justify-content-around">
										<div class="col-4">
											<input type="button" value="작성 취소"
												class="btn btn-primary btn-block" />
										</div>
										<div class="col-4">
											<input type="submit" value="작성 완료"
												class="btn btn-primary btn-block" />
										</div>
									</div>
								</div>

							</form>
							<br /> <br />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
$("#textContent").keyup(({target}) => {
	//console.log(target);
	//console.log(target.value);
	const $target = $(target);
	const len = $target.val().length;
	$("#count")
		.html(len)
		.css("color", len > 3000 ? "red" : "gray");
});
</script>