<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
<style>
table {
text-align: "center";
}
</style>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>권한</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="m">
			<tr>
				<td>${m.memberId}</td>
				<td>${m.memberName}</td>
				<td>${m.memberAuthor}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>