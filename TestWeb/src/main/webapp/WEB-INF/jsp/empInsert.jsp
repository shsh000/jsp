<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
<style>
form > label {
display : inline-block;
width: 8%;
background-color: lightgrey;
text-align: center;
}
</style>
</head>
<body>
	<h3>사원 등록</h3>
	<form action="employee" name="empForm">
		<label for="empID">사원번호</label>
		<input type="text" name="empID" id="empID"><br>
	
		<label for="empName">이름</label>
		<input type="text" name="empName" id="empName"><br>
	
		<label for="email">이메일</label>
		<input type="text" name="email" id="email"><br>
	
		<label for="hiredate">입사일</label>
		<input type="date" name="hiredate" id="hiredate"><br>
	
		<label for="jobID">직무</label>
		<input type="text" name="jobID" id="jobID"><br>
	
		<input type="submit" value="등록">
	</form>
</body>
</html>