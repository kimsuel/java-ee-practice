<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/board.css">
<script type="text/javascript" src="../js/board.js">
</script>
</head>
<body>
<table class="table table-responsive" align="center">
<tr>
	<th>글 번 호</th>
	<th>제 목</th>
	<th>작 성 자</th>
	<th>작 성 일</th>
	<th>조 회 수</th>
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
	${boardPaging.pagingHTML}
</div>
<form name="searchList" method="post" action="boardSearch.do?pg=1">
<div align="center" style = "width : 100%;">
<select name="searchBox" style="width: 100px; height: 25px;background-color:transparent;">
		<option value="id"<c:if test="${'id' == searchBox }"> selected</c:if>>
		작성자</option>
		<option value="subject" <c:if test="${'subject' == searchBox }"> selected</c:if>>제목</option>
</select>
&nbsp;
<input type="text" name="search" value="${search}" style="width: 200px; height: 25px; background-color:transparent; color:white;">
<input type="button" value="검색" class="btn btn-link" onclick="checkSearch()">
</div> 
</form> 
</body>
</html></html>