<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- core 라이브러리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptList.jsp</title>
</head>
<body>
<%-- <%@ include file="/WEB-INF/jsp/header.jsp" %> --%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<h3>부서목록_jstl</h3>
	<!-- <a href="DeptInsert">부서등록</a> -->
	<table border=1>
		<tr>
			<td>부서번호</td>
			<td>부서명</td>
		</tr>
		
		<c:forEach items="${list}" var="dept">
		<tr>
			<td>${dept.getDepartmentId()}</td>
			<td><a href="DeptUpdate?departmentID=${dept.getDepartmentId()}">
												 ${dept.getDepartmentName()}</a></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>