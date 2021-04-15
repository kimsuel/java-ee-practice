<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<!--  <table cellpadding="3" frame="hsides" rules="rows"> -->
<table class="table table-responsive" align="center">
<tr>
	<td align="center"><b>글 번 호</b></td>
	<td align="center"><b>제 목</b></td>
	<td align="center"><b>작 성 자</b></td>
	<td align="center"><b>작 성 일</b></td>
	<td align="center"><b>조 회 수</b></td>
</tr>
<c:if test="${list != null }">
<c:forEach var="boardDTO" items="${list}">
<tr>
	<td align="center">${boardDTO.seq}</td>
	<td>
	<c:forEach begin="0" end="${boardDTO.lev}" step="1">
		&emsp;
	</c:forEach>
	
	<c:if test="${boardDTO.pseq != 0}">
		<img src="../image/reply.gif">
	</c:if>
	
	<a id="subjectA" href="javascript:isLogin('${memId}',${boardDTO.seq},${pg})" >
	${boardDTO.subject}
	</a></td>
	<td align="center">${boardDTO.id}</td>
	<td align="center">
	<fmt:formatDate pattern="YYYY.MM.dd" value="${boardDTO.logtime}"/>
	</td>
	<td align="center">${boardDTO.hit}</td>
</tr>
</c:forEach>
</c:if>
</table>
<div align="center" style = "width : 100%;">
	${boardPaging.pagingHTML }
</div>
<br>
<form name="searchList" method="post" action="/miniproject/board/boardSearch.do">
<div align="center" style = "width : 100%;">
<select name="searchBox" id="searchBox" style="width: 100px; height: 25px; background-color:transparent; color:white;">
		<option value="id" selected>작성자</option>
		<option value="subject">제목</option>
</select>
&nbsp;
<input type="text" name="search" id="search" style="width: 200px; height: 25px; background-color:transparent; color:white;">
<input type="hidden" name="pg" value="${pg}">
<input type="button" value="검색" class="btn btn-link" onclick="checkSearch()">
</div>
</form>
</body>
<script>
	function boardSearch(pg){
		location.href="/miniproject/board/boardSearch.do?pg="+pg
						+"&searchBox=${searchBox}&search="+encodeURIComponent("${search}");
	}
	
 	window.onload=function(){
		if('${searchBox}' != ""){
			document.getElementById("searchBox").value='${searchBox}';
			document.getElementById("search").value='${search}';
		}
	} 
</script>
</html>

