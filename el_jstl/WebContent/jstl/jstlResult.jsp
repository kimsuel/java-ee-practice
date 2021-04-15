<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlResult</title>
</head>
<body>
<fmt:requestEncoding value="UTF-8"/>
이름 : ${param.name}<br>
나이 : ${param.age}살
<c:if test="${param.age >= 20}">(성인)</c:if>
<c:if test="${param.age < 20}">(청소년)</c:if>
<br>
색 깔 : 
<c:choose>
	<c:when test="${param.color == 'red' }">빨강</c:when>
	<c:when test="${param.color == 'green' }">초록</c:when>
	<c:when test="${param.color == 'blue' }">파랑</c:when>
	<c:when test="${param.color == 'magenta' }">보라</c:when>
	<c:otherwise>하늘</c:otherwise>
</c:choose>
<br>
취 미 : 
${paramValues['hobby'][0] }
${paramValues['hobby'][1] }
${paramValues['hobby'][2] }
${paramValues['hobby'][3] }
${paramValues['hobby'][4] }
<br>
취 미 :
<c:forEach var="data" items="${paramValues.hobby}">
${data }
</c:forEach>
</body>
</html>
