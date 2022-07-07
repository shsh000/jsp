<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>TITLE</th>
				<th>CONTENT</th>
				<th>WRITER</th>
				<th>RDT</th>
				<th>HIT</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.id}</td>
					<td>${vo.title}</td>
					<td>${vo.content}</td>
					<td>${vo.writer}</td>
					<td>${vo.rdt}</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>