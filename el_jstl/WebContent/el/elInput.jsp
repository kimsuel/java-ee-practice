<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>elInput</title>
</head>
<body>
<form name="input" method="get" action="elResult.jsp">
<table border="1" cellpadding="3" cellspacing="0">
	<tr>
		<td width="50px" align="center">X</td>
		<td><input type="text" style="width:120px;" name="x"></td>
	</tr>
	<tr>
		<td width="50px" align="center">Y</td>
		<td><input type="text" style="width:120px;" name="y"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="계산">
										<input type="reset" value="취소"></td>
	</tr>
	
</table>
</form>
</body>
</html>