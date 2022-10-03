<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>게시판</title>
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
	</style>
</head>

<body>
	<h2>게시판 글 목록</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${board}">
			<tr>
				<td>${board.boardIdx}</td>
				<td>${board.boardName}</td>
				<td><a href="read?boardIdx=${board.boardIdx}">${board.boardTitle}</a></td>
				<td><fmt:formatDate value="${board.boardDate}" pattern="yyyy-HH-dd HH:mm:ss" /></td>
				<td>${board.boardHit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="create">등록</a></td>
		</tr>
	</table>
</body>

</html>