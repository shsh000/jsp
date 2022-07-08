<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>시작페이지</h1></div>
		<c:if test="${empty id}">
			<div><h3><a href="memberJoinForm.do">회원가입</a></h3></div>
			<div><h3><a href="memberLoginForm.do">로그인</a></h3></div>
		</c:if>
		<c:if test="${not empty id}">
			<div><h3><a href="memberLogout.do">로그아웃</a></h3></div>
		</c:if>
		<c:if test="${author eq 'ADMIN'}">
			<div><h3><a href="memberList.do">회원 목록 보기</a></h3></div>
		</c:if>
	</div>
</body>
</html>