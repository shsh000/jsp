<%@page import="co.micol.prj.dept.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptUpdate.jsp</title>
<script>
function validationForm() {
	if(frm.departmentId.value == "") {
		alert("부서번호를 입력하세요.")
		return;
	}
	frm.submit(); // submit 전송버튼과 동일
}
</script>
</head>
<body>
<%-- <%@ include file="/WEB-INF/jsp/header.jsp" %> --%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<% DeptVO dept = (DeptVO)request.getAttribute("dept"); %>
	<h3>부서정보수정</h3>
	<form name="frm" action="DeptUpdate" method="post">
	부서번호 <input name="departmentId" value="<%= dept.getDepartmentId() %>">
	부서명 <input name="departmentName" value="<%= dept.getDepartmentName() %>">
		<button type="button" onclick="validationForm()">부서정보수정</button>
		<!-- button default 값 = submit -->
	</form>
</body>
</html>