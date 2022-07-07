<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tag.jsp</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- 자바 주석 --%>
	<table border>
		<% for (int i = 1; i < 10; i++) { %>
		<tr>
		<% for (int j = 1; j < 10; j++) { %>
		<td><%= i*j %></td> <%-- <% out.print(i*j); %> --%>
		<% } %>
		</tr>
		<% } %>
	</table>
</body>
</html>