<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/navbar.jsp"%>

<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

	<!-- Main Content -->
	<div id="content">

		<!-- Begin Page Content -->
		<div class="container-fluid">


			<div class="row">


				<!-- 공지사항 & 자유 게시판 부분  -->
				<div class="col-lg-6 mb-4">

					<!-- 공지사항 부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
						</div>
						<div class="card-body">
							<!-- 공지사항 내용 띄울 부분 -->
							<p>SB Admin 2 makes extensive use of Bootstrap 4 utility
								classes in order to reduce CSS bloat and poor page performance.
								Custom CSS classes are used to create custom components and
								custom utility classes.</p>
						</div>
					</div>

					<!-- 자유게시판 부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">자유게시판</h6>
						</div>
						<div class="card-body">
							<!-- 자유게시판 내용 띄울 부분 -->
							<p>SB Admin 2 makes extensive use of Bootstrap 4 utility
								classes in order to reduce CSS bloat and poor page performance.
								Custom CSS classes are used to create custom components and
								custom utility classes.</p>
						</div>
					</div>
				</div>


				<!-- 인기게시글 & 익명 게시판 부분  -->
				<div class="col-lg-6 mb-4">

					<!-- 인기게시글 부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">인기게시글</h6>
						</div>
						<div class="card-body">
							<!-- 인기게시글 내용 띄울 부분 -->
							<p>SB Admin 2 makes extensive use of Bootstrap 4 utility
								classes in order to reduce CSS bloat and poor page performance.
								Custom CSS classes are used to create custom components and
								custom utility classes.</p>
						</div>
					</div>

					<!-- 익명게시판부분 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">익명게시판</h6>
						</div>
						<div class="card-body">
							<!-- 익명 게시판 내용 띄울 부분 -->
							<p>SB Admin 2 makes extensive use of Bootstrap 4 utility
								classes in order to reduce CSS bloat and poor page performance.
								Custom CSS classes are used to create custom components and
								custom utility classes.</p>
						</div>
					</div>

				</div>
				<!-- 인기게시글 부분 -->
				<div class="col-lg-6 mb-4">

					<!-- Illustrations -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Illustrations</h6>
						</div>
						<div class="card-body">
							<div class="text-center">
								<img class="img-fluid px-3 px-sm-4 mt-3 mb-4"
									style="width: 25rem;"
									src="${pageContext.request.contextPath}/resources/img/undraw_posting_photo.svg"
									alt="...">
							</div>
							<p>
								Add some quality, svg illustrations to your project courtesy of
								<a target="_blank" rel="nofollow" href="https://undraw.co/">unDraw</a>,
								a constantly updated collection of beautiful svg images that you
								can use completely free and without attribution!
							</p>
							<a target="_blank" rel="nofollow" href="https://undraw.co/">Browse
								Illustrations on unDraw &rarr;</a>
						</div>
					</div>

					<!-- Approach -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Development
								Approach</h6>
						</div>
						<div class="card-body">
							<p>SB Admin 2 makes extensive use of Bootstrap 4 utility
								classes in order to reduce CSS bloat and poor page performance.
								Custom CSS classes are used to create custom components and
								custom utility classes.</p>
							<p class="mb-0">Before working with this theme, you should
								become familiar with the Bootstrap framework, especially the
								utility classes.</p>
						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

		</div>

	</div>
	<!-- End of Main Content -->

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>