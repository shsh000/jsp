<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList.jsp</title>
<script src="js/jquery-3.6.0.min.js"></script>
<!-- 목록정보 가져오기 -->
</head>
<body>
	<div align="center">
		<div><h1>게시글 목록</h1></div>
		<div>
			<form id="frm">
				<select id="key" name="key">
 					<option value="notice_title">제목</option>
 					<option value="notice_subject">내용</option>
					<option value="notice_writer">작성자</option>
				</select>&nbsp;
				<input type="text" id="val" name="val">&nbsp;&nbsp;
				<input type="button" value="검색" onclick="noticeSearch()">
			</form>
		</div>
		<div>
			<table border="1" id="tt">
				<thead>
					<tr>
						<th width="70">순번</th>
						<th width="130">작성자</th>
						<th width="200">제목</th>
						<th width="130">작성일자</th>
						<th width="70">조회수</th>
						<th width="180">첨부파일</th>
					</tr>
				</thead>
				<tbody id="tb">
				<c:choose>
					<c:when test="${not empty list}">
						<c:forEach items="${list}" var="b">
							<tr>
								<td>${b.noticeId}</td>
								<td>${b.noticeWriter}</td>
								<td>${b.noticeTitle}</td>
								<td>${b.noticeDate}</td>
								<td>${b.noticeHit}</td>
								<td>${b.noticeAttach}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6" align="center">
							게시글이 존재하지 않습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div><br>
		<div>
		<c:if test="${not empty id}"> <!-- 비회원은 글등록 버튼 비활성화 -->
		<%-- <c:if test="${author == 'ADMIN'}"> --%> <!-- 권한이 관리자인 사람만 글 쓰기 가능 -->
			<button type="button" onclick="location.href='noticeForm.do'">등록</button>
		</c:if>
		</div>
	</div>
	
	<script type="text/javascript">
		function noticeSearch() {
			let key = $('#key').val();
			let val = $('#val').val();
			$.ajax({
				url : "ajaxNoticeSearch.do",
				type : "post",
				data : {key : key, val : val}, // 넘겨줄 데이터
				dataType : "json", // 받을 데이터 타입
				success : function(result) {
					if(result.length > 0) {
						jsonHtmlConvert(result);
					} else {
						alert("검색한 결과가 없습니다.");
					}
				},
				error : function() {
					
				}
			})
			// ajax function Call
		}
		
		function jsonHtmlConvert(data) {
			$('tbody').remove();
			var tbody = $("<tbody />");
			$.each(data, function(index, item) {
				var row = $("<tr />").append(
						  $("<td />").text(item.noticeId),
						  $("<td />").text(item.noticeWriter),
						  $("<td />").text(item.noticeTitle),
						  $("<td />").text(item.noticeDate),
						  $("<td />").text(item.noticeAttach),
						  $("<td />").text(item.noticeHit)
				);
				tbody.append(row);
			});
			$('table').append(tbody);
			
		}
	</script>
</body>
</html>