<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인성공</title>
</head>
<body>
<form method="post" action="modifyForm.do">
<img src="../image/minion4.gif" width="100" height="100" 
	style="cursor:pointer;" onclick="location.href='../main/index.jsp'">
<input type="hidden" name="id" value="${sessionScope.memId}">
	${sessionScope.memName}님 로그인 성공하였습니다<br><br>
	<input type="button" value="로그아웃" onclick="location.href='logout.do'">
	<input type="submit" value="회원정보수정">	
</form>
</body>
</html>