<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request.jsp</title>
</head>
<body>
<ul>
<li> parameter: <%= request.getParameter("name") %> <%-- = ${param.name} --%>
<li> parameter: <%= request.getAttribute("id") %> <%-- ${id} --%>
<li> method: <%= request.getMethod() %> <%-- ${pageContext.request.method}, ${pageContext.request.getMethod()} --%>
<%-- <li> <% ArrayList list = ( )request.getAttribute("id") %> --%>
<li> url: <%= request.getRequestURL() %> <!-- 전체 주소 -->
<li> uri: <%= request.getRequestURI() %> <!-- 컨텍스트 패스 다음 주소 -->
<li> protocol: <%= request.getProtocol() %>
<li> queryString: <%= request.getQueryString() %>
<li> ip addr: <%= request.getRemoteAddr() %>
</ul>
</body>
</html>