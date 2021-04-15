<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="dto" class="exam.bean.DataDTO" scope="session"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>곱구하기</title>
</head>
<body>
<jsp:getProperty property="x" name="dto"/>
*
<jsp:getProperty property="y" name="dto"/>
=
<%=dto.getX()*dto.getY() %>
</body>
</html>