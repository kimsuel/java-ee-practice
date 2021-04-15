<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/board.css">
<script type="text/javascript" src="../js/board.js"></script>
</head>
<body>
<h2>답글쓰기</h2>
<form name="boardReplyForm" method="post" action="boardReply.do">
	<table>
		<tr height="40">
			<td align="center" width="50">제목</td>
			<td>
			<input type="text" name="subject" style="width:315px; background-color:transparent;">
			<input type="hidden" name="pseq" value="${pseq}">
			<input type="hidden" name="pg" value="${pg}">
			</td>
		</tr>
		<tr height="200">
			<td align="center">내용</td>
			<td><textarea name="content" style="background-color:transparent;" cols="40" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" class="btn btn-primary outline" value="답글쓰기" onclick="checkBoardReply()">
		 	<input type="reset" class="btn btn-primary outline" value="다시작성"></td>
		</tr>
	
	</table> 
</form>
</body>
</html>