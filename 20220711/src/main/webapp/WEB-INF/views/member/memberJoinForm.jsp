<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberJoinForm.jsp</title>
<style>
table {
border : 1px solid lightgrey;
border-collapse : collapse;
}
th {
padding:5px;
background-color: lightgrey;
}

</style>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원가입</h1>
		</div>
		<div>
			<form id="frm" action="memberJoin.do" onsubmit="return formCheck()" method="post">
				<div>
					<table>
						<tr>
							<th width="130px">아이디</th>
							<td width="300px">
								<input type="text" id="memberId" name="memberId" size="20">&nbsp;
								<input type="hidden" id="checkId" value="No">
								<button type="button" id="btn" onclick="idCheck()">중복 체크</button>
							</td>
						</tr>
						<tr>
							<th width="130px">패스워드</th>
							<td width="300px">
								<input type="password" id="memberPassword" name="memberPassword" size="20">
							</td>
						</tr>
						<tr>
							<th width="130px">패스워드 확인</th>
							<td width="300px">
								<input type="password" id="password" size="20">
							</td>
						</tr>
						<tr>
							<th width="130px">이름</th>
							<td width="300px">
								<input type="text" id="memberName" name="memberName" size="20">
							</td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
					<input type="button" value="홈으로 이동" onclick="location.href='main.do'">
				</div>
			</form>
		</div>
	</div>
<script type="text/javascript">
	function formCheck() {
		if(frm.memberId.value == "") { // memberId 값이 비어있으면
			alert("사용자 아이디를 입력하세요.");
			frm.memberId.focus();
			return false;
		}
		if(frm.checkId.value == "No") {
			alert("아이디 중복체크를 해주세요.");
			return false;
		}
		if(frm.memberPassword.value != frm.password.value) {
			alert("패스워드가 일치하지 않습니다.");
			frm.memberPassword.value = "";
			frm.password.value = "";
			frm.memberPassword.focus();
			return false;
		}
		if(frm.memberName.value == "") {
			alert("사용자 이름을 입력하세요.");
			frm.memberName.focus();
			return false;
		}
		return true;
	}
	
	function idCheck() { // 아이디 중복체크(onclick 이벤트 함수)
		let id = frm.memberId.value;
		if(id == "") {
			alert("아이디 입력 후 중복체크 해주세요.");
			frm.memberId.focus();
		} else {
			// Ajax 이용하여 아이디 중복체크 수행
			const xht = new XMLHttpRequest(); // ajax 객체 생성
			xht.onload = function() { // 콜백 함수(결과를 받아 처리하는 함수)
				if(this.readyState == 4 && this.status == 200) {
			    	htmlConvertAjax(this.responseText); // 성공했을때 수행하는 함수
				} else {
					errorAjaxCall(); // 실패했을때 수행하는 함수
				}
			  }
			xht.open("get", "ajaxMemberIdCheck.do?id=" + id); // 호출할 방식과 주소 설정
			xht.send(); // 호출
		}
	}
	
	// 성공했을때 수행하는 함수
	function htmlConvertAjax(str) {
		if(str == "Used") {
			alert("사용가능한 아이디입니다.");
			frm.checkId.value = "Yes";
			frm.btn.disabled = true;
			frm.memberPassword.focus();
		} else {
			alert("이미 사용중인 아이디입니다.");
			frm.memberId.value = "";
			frm.memberId.focus();
		}
	}
	
	// 실패했을때 수행하는 함수
	function errorAjaxCall() {
		alert("네트워크 통신 장애로 인해 처리할 수 없습니다. 잠시후 다시 실행해보세요.");
	}
</script>
</body>
</html>