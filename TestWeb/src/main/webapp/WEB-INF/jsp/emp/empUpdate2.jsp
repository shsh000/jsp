<%@page import="co.micol.prj.emp.EmpVO"%>
<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="co.micol.prj.emp.JobsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- core 라이브러리, jstl(Java Standard Tag Library) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empUpdate.jsp</title>
<script>
function validateForm() {
	// 입력값이 공백("")이면 뜨는 경고창
	if(frm.employeeID.value == "") {
		alert("사번을 입력하세요.");
		frm.employeeID.focus();
		return false;
	}
	if(frm.lastName.value == "") {
		alert("이름을 입력하세요.");
		frm.lastName.focus();
		return false;
	}
	if(frm.email.value == "") {
		alert("이메일을 입력하세요.");
		frm.email.focus();
		return false;
	}
	if(frm.hireDate.value == "") {
		alert("입사일을 입력하세요.");
		frm.hireDate.focus();
		return false;
	}
	if(frm.jobID.value == "") {
		alert("직무를 입력하세요.");
		frm.jobID.focus();
		return false;
	}
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // 이메일 정규식
	if(regExp.test(frm.email.value) ==  false) {
		alert("이메일 형식");
		frm.email.focus();
		return false;
	}
	return true; // 이상이 없다면 true 값 반환
}
</script>
<style>
form > label {
display : inline-block;
width: 8%;
background-color: lightgrey;
text-align: center;
margin-bottom: 5px;
}

</style>
</head>
<body>
<%-- <%@ include file="/WEB-INF/jsp/header.jsp" %> --%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<h3>사원 등록</h3>
	<%
	EmpVO vo = (EmpVO)request.getAttribute("emp");
	%>
													<!-- onsubmit : submit 버튼을 누르면 발생하는 이벤트 -->
	<form action="empInsert" name="frm" method="post" onsubmit="return validateForm()">
		<label for="employeeID">사원번호</label>
		<input type="text" name="employeeID" id="employeeID" readonly="readonly" value="${vo.getEmployeeID()}"><br>
	
		<label for="lastName">이름</label>
		<input type="text" name="lastName" id="lastName" value="${vo.getLastName()}"><br>
	
		<label for="email">이메일</label>
		<input type="text" name="email" id="email" value="${vo.getEmail()}"><br>
	
		<label for="hireDate">입사일</label>
		<input type="date" name="hireDate" id="hiredate" value="${vo.getHireDate().substring(0, 10)}"><br>
	
		<label for="deptID">부서번호</label>
			<c:forEach items="${depts}" var="dept">
		<input type="radio" name="departmentID" value="${dept.getDepartmentId()}"
		<c:if test="dept.getDepartmentId() == vo.getDepartmentID()">checked="checked"</c:if>> <!-- 목록에서 이름 선택했을때 해당 부서가 체크되어있음 -->
		${dept.getDepartmentName()}
			</c:forEach>
		
		<br>
		<label for="jobID">직무</label>
		<select name="jobID">
		<c:forEach items="${jobs}" var="job">
		<!-- jobs => EmpInsertServ setAttribute 에서 받아옴 -->
		<option value="${job.getJobID()}"> ${job.getJobTitle()}
		</c:forEach>
		</select>
		<button>등록</button>
		<button type="button" onclick="empDelete()">삭제</button>
	</form>
	<script>
		function empDelete() {
			location.href = "empDelete?employeeID=<%= vo.getEmployeeID() %>";
		} 
		document.querySelectorAll("[name=departmentID][value='<%= vo.getDepartmentID() %>']").checked = true;
		document.getElementsByName("jobID")[0].value = "<%= vo.getJobID() %>";
	</script>
</body>
</html>