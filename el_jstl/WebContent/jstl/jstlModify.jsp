<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<sql:update dataSource="jdbc/oracle">
	update usertable set name='${param.name}', pwd='${param.pwd}' where id= '${param.id}'
</sql:update>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlModify</title>
<script type="text/javascript">
	window.onload=function(){
		alert("수정하였습니다");
		location.href="jstlList.jsp";
	}
</script>
</head>
<body>
</body>
</html>