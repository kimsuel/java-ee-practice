<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<table>
	<tr>
		<td><img src="../image/big.png" width="20" height="20"
		         style="cursor:pointer;" onclick="imgBigView('http://localhost:8080/miniproject/storage/${imageboardDTO.image1}')">그림확대</td>
	</tr>
	<tr>
		<td rowspan="4" width="200" height="200"><img src="../storage/${imageboardDTO.image1}" height="180" width="190"></td>
		<td width="100"><h3><b>상품명 : </b></h3></td>
		<td width="150" ><h3>${imageboardDTO.imageName}</h3></td>
	</tr>
	<tr>
		<td><b>단가 : </b></td>
		<td><fmt:formatNumber type="number" value="${imageboardDTO.imagePrice}" pattern="#,###"/>원</td>
	</tr>
	<tr>
		<td><b>개수 : </b></td>
		<td>${imageboardDTO.imageQty}개</td>
	</tr>
	<tr>
		<td><b>합계 : </b></td>
		<td><fmt:formatNumber type="number" value="${imageboardDTO.imagePrice*imageboardDTO.imageQty}" pattern="#,###"/>원</td>
	</tr>
</table>
<pre style="background-color:transparent;color:white;width:370px;"><font size="3">${imageboardDTO.imageContent}</font></pre>
<input type="button" class="btn btn-primary" value="목록" onclick="location.href='imageboardList.do?pg=${pg}'">
</body>
</html>