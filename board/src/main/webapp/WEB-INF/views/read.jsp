<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		
		.textLeft {
			width: 420px;
			padding: 5px;
			text-align: left;
		}
	</style>
</head>

<body>
	<h2>글 내용</h2>
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
			<td class="textLeft">${data.boardTitle}</td>
		</tr>
		<tr style="height: 300px">
			<td>내용</td>
			<td class="textLeft">${data.boardName}</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="/update?boardIdx=${data.boardIdx}"><input type="button" value="수정" /></a>
				<a href="/"><input type="button" value="목록" /></a>
				<a href="/delete?boardIdx=${data.boardIdx}"><input type="button" value="삭제" /></a>
			</td>
		</tr>
	</table>
</body>

</html>