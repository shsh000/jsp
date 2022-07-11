<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberLoginForm.jsp</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>로그인</h1>
		<div>
			<form id="frm" action="memberLogin.do" method="post">
				<table border="1">
					<tr>
						<th width="150px">아이디</th>
						<td width="200px">
						<input type="text" id="memberId"name="memberId" required="required" placeholder="Enter Your ID">
																		<!-- required : 필수, placeholder : 도움말 -->
						</td>
					</tr>
					<tr>
						<th width="150px">패스워드</th>
						<td width="200px">
						<input type="password" id="memberPassword"name="memberPassword" required="required" placeholder="Enter Your PASSWORD">
																						<!-- required : 필수, placeholder : 도움말 -->
						</td>
					</tr>
				</table>
		</div><br>
			<div>
				<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp; <!-- 공백 : &nbsp; -->
				<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
				<input type="button" value="홈으로 이동" onclick="location.href='main.do'">
			</div>
			</form>
		</div>
	</div>
</body>
</html>