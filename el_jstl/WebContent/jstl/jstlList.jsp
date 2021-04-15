<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:query var="rs" dataSource="jdbc/oracle">
 select * from usertable
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlList</title>
</head>
<body>
<table border="1">
	<tr>
		<!-- 필드명 -->
		<c:forEach var="colName" items="${rs.columnNames}">
		<th width="120">${colName}</th>
		</c:forEach>
		<th width="120">비고</th>
		
		<!-- 필드  -->
		<c:forEach var="row" items="${rs.rowsByIndex}">
		<tr>
		<c:forEach var="col" items="${row}">
			<td align="center">${col}</td>
		</c:forEach>
			<td align="center">
				<input type="button" value="수정" onclick="location.href='jstlModifyForm.jsp?id=${row[1]}'">
				<input type="button" value="삭제" onclick="location.href='jstlDelete.jsp?id=${row[1]}'">
			</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>