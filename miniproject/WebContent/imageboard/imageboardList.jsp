<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/imageboard.css">
<script type="text/javascript" src="../js/imageboard.js">
</script>
</head>
<body>
<form name="imageboardList" method="post" action="imageboardDelete.do">
<table class="table table-responsive" align="center">
	<tr>
		<td align="center"><b>
		<!-- <input type="checkbox" name="seq" onclick="checkAll()"> -->
		<input type="checkbox" id="all" onclick="checkAll()">&nbsp;번호</b></td>
		<td align="center"><b>이미지</b></td>
		<td align="center"><b>상품명</b></td>
		<td align="center"><b>단가(원)</b></td>
		<td align="center"><b>개수</b></td>
		<td align="center"><b>합계</b></td>
	</tr>
<c:if test="${list != null }">
<c:forEach var="imageboardDTO" items="${list}">
	<tr>
		<td align="center">
		<input type="checkbox" name="seq" value="${imageboardDTO.seq}">&nbsp;${imageboardDTO.seq}</td>
		<td align="center">
			<img src="../storage/${imageboardDTO.image1}" height="40" width="50"
		          style="cursor:pointer;" onclick="location.href='imageboardView.do?seq=${imageboardDTO.seq}&pg=${pg}'"></td>
		<td align="center">${imageboardDTO.imageName}</td>
		<td align="center"><fmt:formatNumber type="number" value="${imageboardDTO.imagePrice}" pattern="#,###"/></td>
		<td align="center">${imageboardDTO.imageQty}</td>
		<td align="center">
			<fmt:formatNumber type="number" value="${imageboardDTO.imagePrice*imageboardDTO.imageQty}" pattern="#,###"/></td>
	</tr>
</c:forEach>
</c:if>
</table>
&nbsp;&nbsp;
<div style="float:left;">
	<input type="button" value="선택삭제" class="btn btn-primary" onclick="checkDelete()">
	&nbsp;
	<input type="button" value="전체삭제" 
		   class="btn btn-success" onclick="location.href='imageboardDeleteAll.do'">
</div>
<div align="center" style = "float:left; width : 100%;">
	${imageboardPaging.pagingHTML }
</div>
</form>
</body>
<script>
	function imageboardPaging(pg){
		location.href="/miniproject/imageboard/imageboardList.do?pg="+pg;
	}
</script>
</html>
