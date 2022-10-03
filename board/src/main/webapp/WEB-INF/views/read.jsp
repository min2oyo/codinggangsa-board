<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>글 내용</title>
	<style>
		* {
			margin: 0 auto;
			padding: 0 auto;
			overflow: hidden;
			text-align: center;
		}
		
		table, th, td {
			border: 1px solid black;
			border-collapse: collapse;
		}
		
		table {
			width: 500px;
		}
		
		.data {
			width: 420px;
			padding: 5px;
			text-align: left;
		}
	</style>
</head>

<body>
	<!-- 글 내용 -->
	<h2>글 내용</h2>
	<table>
		<tr>
			<td>번호</td>
			<td class="data">${board.boardIdx}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td class="data">${board.boardHit}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td class="data">${board.boardName}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td class="data">${board.boardTitle}</td>
		</tr>
		<tr style="height: 300px">
			<td>내용</td>
			<td class="data">${board.boardContent}</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="/updatePage?boardIdx=${board.boardIdx}"><input type="button" value="수정" /></a>
				<a href="/"><input type="button" value="목록" /></a>
			</td>
		</tr>
	</table>
	
	<br>
	
	<!-- 댓글 등록 -->
	<form action="reply/create" method="post">
		<input type="hidden" name="replyBoardIdx" value="${board.boardIdx}" />
		<table>
			<caption style="text-align: left">댓글</caption>
			<tr>
				<td>댓글</td>
				<td><textarea class="data" rows="2" cols="50" name="replyContent"></textarea></td>
			</tr>
			<tr>
				<td>별명</td>
				<td><input class="data" type="text" name="replyName" /></td>
			</tr>
			<tr>
				<td style="text-align: left" colspan="2"><input type="submit" value="등록" /></td>
			</tr>
		</table>
	</form>
	
	<br>
	
	<!-- 댓글 목록 -->
	<table>
		<tr>
			<th>별명</th>
			<th>내용</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="reply" items="${reply}">
			<tr>
				<td>${reply.replyName}</td>
				<td>${reply.replyContent}</td>
				<td><fmt:formatDate value="${reply.replyDate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
				<td><button onclick="deleteReply(${reply.replyIdx}, ${reply.replyBoardIdx})">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
	
	<script>
		// 뒤로가기 할 때, 페이지 재로딩 | 현재 실행 안 됨
		window.onpageshow = event => {
			if (event.persisted) {
				document.location.reload();
			}
		};
		
		// 댓글 삭제
		function deleteReply(replyIdx, replyBoardIdx) {
			confirm(`삭제 ㄱ?`)?location.href="/reply/delete?replyIdx=" + replyIdx + "&replyBoardIdx=" + replyBoardIdx:"";
		}
	</script>
</body>

</html>