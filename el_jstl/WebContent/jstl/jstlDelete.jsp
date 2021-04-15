<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:update dataSource="jdbc/oracle">
	delete from usertable where id='${param.id}'
</sql:update>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlDelete</title>
<script type="text/javascript">
	window.onload=function(){
		alert("삭제되었습니다");
		location.href="jstlList.jsp";
	}
</script>
</head>
<body>

</body>
</html>