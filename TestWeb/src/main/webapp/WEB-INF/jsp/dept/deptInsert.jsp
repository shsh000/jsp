<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptInsert.jsp</title>
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
	<h3>부서등록</h3>
	<form name="frm" action="DeptInsert" method="post">
	부서번호 <input name="departmentId">
	부서명 <input name="departmentName">
		<button type="button" onclick="validationForm()">부서등록</button>
		<!-- button default 값 = submit -->
	</form>
</body>
</html>