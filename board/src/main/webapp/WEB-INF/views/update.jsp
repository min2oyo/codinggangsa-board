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
		
		.textLeft {
			text-align: left;
		}
	</style>
</head>

<body>
	<h2>글 내용</h2>
	<form action="update" method="post">
		<table>
			<tr>
				<td>번호</td>
				<td class="textLeft">${data.boardIdx}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td class="textLeft">${data.boardHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td class="textLeft">${data.boardName}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td class="textLeft"><input class="textLeft" type="text" name="boardTitle" value="${data.boardTitle}" size="50" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td class="textLeft"><textarea class="textLeft" name="boardContent" rows="10" cols="50">${data.boardName}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" />
					<a href="/"><input type="button" value="목록" /></a>
					<a href="/delete?boardIdx=${dto.boardIdx}"><input type="button" value="삭제" /></a>
				</td>
			</tr>
		</table>
	</form>
</body>

</html>