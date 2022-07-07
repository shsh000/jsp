<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- core 라이브러리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl</title>
</head>
<body>
<%-- <%@ include file="/WEB-INF/jsp/header.jsp" %> --%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<h3>사원목록</h3>
	<!-- <a href="empInsert">사원등록</a> -->
	<form>
		<input name="departmentId">
		<button>검색</button>
	</form>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>이메일</th>
				<th>입사일</th>
				<th>부서번호</th>
				<th>직무</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.employeeID}</td>
					<td><a href="empUpdate?employeeID=${vo.employeeID}">${vo.lastName}</a></td>
					<td>${vo.email}</td>
					<td>${vo.hireDate}</td>
					<td>${vo.departmentID}</td>
					<td>${vo.jobID}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>