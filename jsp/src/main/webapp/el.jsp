<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el.jsp</title>
</head>
<body>
	<ul>
		<li>${param.name}
		<li>${id} <!-- ElServ의 어트리뷰트 값 가져옴 -->
		<li>${pageContext.request.method}
		<li>${pageContext.request.getMethod()}
		<li>${arr[0]} ${arr[1]}
	</ul>
</body>
</html>