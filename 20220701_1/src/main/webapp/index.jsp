<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Hello My Web Site</h1>
		<a href="sum.do">서블릿 호출</a>
		<%-- <% %> = 자바 코드, <%! %> = 선언문, <%= %> = 출력문 --%>
		<%-- <%!
		public int sum(int m, int n) {
		return m + n;
	}%>

		<%
		int m = 10;
		int n = 20;
		%>
		
		합계 = <%= sum(m, n) %> --%>
	</div>
</body>
</html>