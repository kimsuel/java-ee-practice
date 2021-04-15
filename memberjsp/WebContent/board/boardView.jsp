<%@page import="board.bean.BoardDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<%
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

BoardDTO boardDTO = boardDAO.boardView(seq);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 보기</title>
<link rel="stylesheet" href="../css/board.css">
</head>
<body>
<table class="view">
			<tr>
				<th>제목 : </th>
				<td colspan="6"><%= boardDTO.getSubject() %></td>
			</tr>
			<tr>
				<th>글번호 : </th>
				<td><%=seq %></td>
				<th>작성자 : </th>
				<td><%= boardDTO.getId() %></td>
				<th>조회수 : </th>
				<td><%= boardDTO.getHit() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="6" height="250px" valign="top"><pre><font size="3px"><%= boardDTO.getContent() %></font></pre></td>
			</tr>
</table>
<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%= pg %>'">
<% if(session.getAttribute("memId").equals(boardDTO.getId())){ %>
<input type="button" value="글수정" onclick="location.href='boardModify.jsp'">
<input type="button" value="글삭제" onclick="location.href='boardDelete.jsp'">
<% } %>
</body>
</html>