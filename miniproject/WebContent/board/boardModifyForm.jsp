<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardModifyForm</title>
<script type="text/javascript" src="../js/board.js">
</script>
</head>
<body>
<form name="boardModifyForm" method="post" action="boardModify.do">
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<td align="center">제목</td>
			<td><input type="text" name="subject" value="${boardDTO.subject}" 
			           style="width:300px; background-color:transparent;">
				<input type="hidden" name="seq" value="${boardDTO.seq}">
				<input type="hidden" name="pg" value="${pg}">
			</td>
		</tr>
		<tr>
			<td align="center">내용</td>
			<td><textarea name="content" style="background-color:transparent;" cols="40" rows="10">
				${boardDTO.content}
				</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" class="btn btn-link" value="글수정" onclick="checkBoardModify()">
			<input type="reset" class="btn btn-link" value="다시작성"></td>
		</tr>
	
	</table> 
</form>
</body>
</html>