<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>글 쓰기</title>
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
	<h2>글 쓰기</h2>
	<form action="createOk" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td class="textLeft"><input class="textLeft" type="text" name="boardName" size="50" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td class="textLeft"><input class="textLeft" type="text" name="boardTitle" size="50" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td class="textLeft"><textarea class="textLeft" rows="10" cols="50" name="boardContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록"/>
					<input type="reset" value="다시 쓰기"/>
					<a href="/"><input type="button" value="목록"></a>
				</td>
			</tr>
		</table>
	</form>
</body>

</html>