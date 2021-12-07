<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.js"></script>
<script src="<%=request.getContextPath()%>/js/otochatroom.js"></script>
</head>
<body>
	1:1 대화방으로 이동을 원하면 클릭하십시오
	<br />
	<br /> 홍길동->양소영
	<input type="button" name="대화하기" value="대화하기"
		onClick="javascript:fnGoOtoChat('300102','202002','S','김이박','양소영','1:1');" />
	<br />
	<br /> 양소영->홍길동
	<input type="button" name="대화하기" value="대화하기"
		onClick="javascript:fnGoOtoChat('202002','300102','S','양소영','김이박','1:1');" />
	<br />
	<br /> 양소영->이송이
	<input type="button" name="대화하기" value="대화하기"
		onClick="javascript:fnGoOtoChat('202002', '202102','S','양소영','이송이','1:1');" />
	<br />
	<br /> 고길동->홍길동
	<input type="button" name="대화하기" value="대화하기"
		onClick="javascript:fnGoOtoChat('202102','202002','S','이송이','양소영','1:1');" />
	<br />
	<br />
	<br />

</body>
</html>