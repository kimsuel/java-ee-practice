<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:query var="rs" dataSource="jdbc/oracle">
 select * from usertable where id='${param.id}'
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlModifyForm</title>
</head>
<body>
<form name="jstlWriteForm" method="post" action="jstlModify.jsp">
<c:forEach var="row" items="${rs.rows}">
<!-- rows(map형식) : 키값으로 들어오기 때문에 키 이름을 가져와도 됨 -->
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<td align="center" width="70">이름</td>
				<td><input type="text" value="${row.name}" name="name" style="width: 150px;"></td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td><input type="text" value="${row.id}" name="id"readonly style="width: 150px;"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" value="${row.pwd}" name="pwd" style="width: 150px;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정">
					<input type="button" value="목록" onclick="location.href='jstlList.jsp'" >
				</td>
			</tr>
		</table>
</c:forEach>
	</form>
</body>
</html>