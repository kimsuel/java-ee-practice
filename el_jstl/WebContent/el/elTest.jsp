<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="50%">
<tr>
	<th width="50%">표현식</th>
	<th width="50%">값</th>
</tr>
<tr>
	<td align="center">\${25+3}</td> <!-- \ : 글씨를 그대로 뿌려라 -->
	<td align="center">${25+3}</td>
</tr>
<tr>
	<td align="center">\${25/3}</td>
	<td align="center">${25/3}</td> <!-- 나누기 : 소수점까지 계산 -->
</tr>
<tr>
	<td align="center">\${25 div 3 }</td>
	<td align="center">${25 div 3}</td> <!-- 나누기만 div 사용 가능 -->
</tr>
<tr>
	<td align="center">\${25 % 3 }</td>
	<td align="center">${25 % 3}</td>
</tr>
<tr>
	<td align="center">\${25 mod 3 }</td>
	<td align="center">${25 mod 3}</td> <!-- 나머지 : mod 사용 가능 -->
</tr>
<tr>
	<td align="center">\${25 < 3 }</td>
	<td align="center">${ 25 < 3 }</td>
</tr>

<!--  > gt, < lt, >= ge, <= le, == eq, != ne -->
<!--  관계연산자는 태그기호와 헷갈려서 영어로도 사용 가능 -->

<tr>
	<td align="center">\${ 25 ne 3 }</td>
	<td align="center">${ 25 ne 3 }</td>
</tr>
<tr>
	<td align="center">\${header['host'] }</td>
	<td align="center">${header['host']}</td>
	                  <!-- 내 호스트가 누구인지 알려줌 -->
</tr>
<tr>
	<td align="center">\${header.host}</td>
	<td align="center">${header.host}</td>
</tr>
</table>
</body>
</html>



