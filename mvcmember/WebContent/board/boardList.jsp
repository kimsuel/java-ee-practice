<%@page import="java.util.List"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.bean.BoardPaging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<%
	//데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
    String id = (String)session.getAttribute("memId");

	//페이징처리 - 1페이지당 5개씩
	int endNum = pg * 5;
	int startNum = endNum - 4;

	//DB
	//BoardDAO boardDAO = BoardDAO.getInstance();
	List<BoardDTO> list = boardDAO.boardList(startNum, endNum);

	//페이징처리
	int totalA = boardDAO.getBoardTotalA(); // 총글수
	BoardPaging boardPaging = new BoardPaging();
	
	boardPaging.setCurrentPage(pg);
	boardPaging.setPageBlock(3);
	boardPaging.setPageSize(5);
	boardPaging.setTotalA(totalA);
	
	boardPaging.makePagingHTML();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글목록</title>
<link rel="stylesheet" href="../css/board.css">
<script type="text/javascript" src="../js/board.js">
</script>
</head>
<body>
<img src="../image/minion4.gif" width="100" height="100" 
	style="cursor:pointer;" onclick="location.href='../main/index.jsp'">
<br><br>
<!--  <table cellpadding="3" frame="hsides" rules="rows"> -->
<table class="boardList">
<tr>
	<th>글 번 호</th>
	<th>제 목</th>
	<th>작 성 자</th>
	<th>작 성 일</th>
	<th>조 회 수</th>
</tr>
<% if(list != null){ 
	for(BoardDTO boardDTO : list){ %>
<tr>
	<td align="center"><%= boardDTO.getSeq()%></td>
	<td><a id="subjectA" href="javascript:isLogin('<%=id %>',<%=boardDTO.getSeq() %>,<%=pg %>)" ><%=boardDTO.getSubject()%></a></td>
	<td align="center"><%=boardDTO.getId()%></td>
	<td align="center"><%=boardDTO.getLogtime()%></td>
	<td align="center"><%=boardDTO.getHit()%></td>
</tr>
	<% } %>
<% } %>
</table>
<!--  
<div style = "width : 200px; float:left; margin-right:10px;">
				<img src="../image/minion4.gif" width="100" height="100" 
	style="cursor:pointer;" onclick="location.href='../main/index.jsp'">
			</div>
-->
<div align="center" style = "width : 600px;">
	<%= boardPaging.getPagingHTML() %>
</div>
</body>
</html>