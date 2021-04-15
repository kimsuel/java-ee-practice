<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
<table border="1" width="100%" cellspacing="0">
	<tr><td colspan="2" align="center">
		<jsp:include page="../template/top.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
		<td height="500" width="250"><jsp:include page="../template/left.jsp"></jsp:include>
		</td>
		<td><jsp:include page="${display}"></jsp:include>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<jsp:include page="../template/bottom.jsp"></jsp:include>
		</td>
	</tr>
</table>
</body>
</html>