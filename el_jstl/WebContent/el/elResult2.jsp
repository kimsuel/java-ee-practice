<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="angel" uri="tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>elResult2</title>
</head>
<body>
<h3>자바클래스의 메소드를 이용하여 계산</h3>
${param['x']} + ${param['y']} = ${ angel:sum(param['x'], param['y']) }<br>
${param.x} * ${param.y} = ${ angel:mul(param.x, param.y) }<br>
</body>
</html>