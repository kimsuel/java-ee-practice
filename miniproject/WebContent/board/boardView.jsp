<%@page import="board.bean.BoardDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 보기</title>
<link rel="stylesheet" href="../css/board.css">
</head>
<body>
<div align="left">
<table class="view">
			<tr>
				<th>제목 : </th>
				<td colspan="6">${boardDTO.subject }</td>
			</tr>
			<tr>
				<th>글번호 : </th>
				<td>${boardDTO.seq}</td>
				<th>작성자 : </th>
				<td>${boardDTO.id}</td>
				<th>조회수 : </th>
				<td>${boardDTO.hit}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="6" height="250px"valign="top">
				<pre style="background-color:transparent; color:white;">
					<font size="3px">${boardDTO.content}</font>
				</pre>
				</td>
			</tr>
</table>
<form method="post" action="boardModifyForm.do">
<input type="button" class="btn btn-link" value="목록" 
		<%-- onclick="location.href='boardList.do?pg=${pg}'"> --%>
			 onclick="history.back()"> 
<input type="button" class="btn btn-link" value="답글" 
		onclick="location.href='boardReplyForm.do?pg=${pg}&pseq=${boardDTO.seq}'">
<c:if test="${sessionScope.memId == boardDTO.id}">
<input type="hidden" name="seq" value="${boardDTO.seq}">
<input type="hidden" name="pg" value="${pg}">
<input type="submit" class="btn btn-link" value="글수정">
<input type="button" class="btn btn-link" value="글삭제" onclick="location.href='boardDelete.do?seq=${boardDTO.seq}'">
										<!-- 삭제할 때는 1페이지로 이동 -->
</c:if>
</form>
</div>
</body>
</html>