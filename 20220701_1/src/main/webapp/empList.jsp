<%@page import="java.util.ArrayList"%>
<%@page import="co.micol.prj.emp.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl</title>
</head>
<body>
	<table>
		<thead><tr><th>사번</th><th>이름</th><th>급여</th></tr></thead>
		<tbody>
		<c:forEach var="vo"  items="${list}">
			<tr>
				<td>${vo.employeeID}</td>
				<td>${vo.firstName}</td>
				<td>${vo.salary}</td> 
			</tr>
		</c:forEach>  
	
		</tbody>
	</table>
</body>
</html>