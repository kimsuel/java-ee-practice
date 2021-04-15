<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="dto" class="exam.bean.DataDTO" scope="session"/>
<jsp:setProperty property="x" name="dto"/>
<jsp:setProperty property="y" name="dto"/>
<html>
<head>
	<title>결과</title>
</head>
<body>
<form method="" action="mul.jsp">
<jsp:getProperty property="x" name="dto"/>
+
<jsp:getProperty property="y" name="dto"/>
=
<%=dto.getX()+dto.getY() %>
<br><br>
<input type="submit" value="곱구하기" >
</form>
</body>
</html>