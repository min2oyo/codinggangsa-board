<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>글 수정</title>
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
			text-align: left;
		}
	</style>
</head>

<body>
	<h2>글 수정</h2>
	<form action="update" method="post">
		<table>
			<tr>
				<td>번호</td>
				<td class="data"><input type="hidden" name="boardIdx" value="${board.boardIdx}" size="50" />${board.boardIdx}</td>
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
				<td class="data"><input class="data" type="text" name="boardTitle" value="${board.boardTitle}" size="50" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td class="data"><textarea class="data" name="boardContent" rows="10" cols="50">${board.boardContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="확인" />
					<a href="/readPage?boardIdx=${board.boardIdx}"><input type="button" value="취소" /></a>
					<a href="/"><input type="button" value="목록" /></a>
					<a href="/delete?boardIdx=${board.boardIdx}"><input type="button" value="삭제" /></a>
				</td>
			</tr>
		</table>
	</form>
</body>

</html>