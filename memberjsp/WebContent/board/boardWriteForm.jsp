<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<script type="text/javascript" src="../js/board.js"></script>
</head>
<body>
<h2>글쓰기</h2>
<form name="boardWriteForm" method="post" action="boardWrite.jsp">
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<td align="center">제목</td>
			<td><input type="text" name="subject" style="width:300px;" placeholder="제목입력"></td>
		</tr>
		<tr>
			<td align="center">내용</td>
			<td><textarea name="content" cols="40" rows="10" placeholder="내용입력"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" value="글쓰기" onclick="checkBoardWrite()">
							<input type="reset" value="다시작성"></td>
		</tr>
	
	</table> 
</form>
</body>
</html>