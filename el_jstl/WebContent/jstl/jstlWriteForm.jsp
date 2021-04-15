<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlWriteForm</title>
</head>
<body>
	<form name="jstlWriteForm" method="post" action="jstlWrite.jsp">
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<td align="center" width="70">이름</td>
				<td><input type="text" name="name" style="width: 150px;"></td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td><input type="text" name="id" style="width: 150px;"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" style="width: 150px;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="저장">
					<input type="button" value="목록" onclick="location.href='jstlList.jsp'" >
				</td>
			</tr>
		</table>
	</form>
</body>
</html>