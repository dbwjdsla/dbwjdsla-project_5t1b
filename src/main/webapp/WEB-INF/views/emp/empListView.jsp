<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/navbar.jsp" %>

<section id="board-container">

	<div id='empInfo'><%= request.getAttribute("list") %></div>
</section>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>