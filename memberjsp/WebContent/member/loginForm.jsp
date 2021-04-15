<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script type="text/javascript" src="../js/member.js">
</script>
</head>
<body>
	<h2><img src="../image/minion4.gif" width="100" height="100" 
	style="cursor:pointer;" onclick="location.href='../main/index.jsp'">로그인</h2>
	<form name="loginForm" method="post" action="login.jsp">
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<td align="center" width="70">아이디</td>
				<td><input type="text" name="id" 
						style="width: 120px;" placeholder="아이디 입력"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" 
						style="width: 120px;" placeholder="비밀번호 입력"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="로그인" onclick="checkLogin()" >
					<input type="button" value="회원가입" onclick="location.href='writeForm.jsp'" >
				</td>
			</tr>
		</table>
	</form>
</body>
</html>