<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="../css/main.css">
<script type="text/javascript" src="../js/member.js">
</script>
</head>
<body>
	<div align="center">
		<h2>로그인</h2>
		<form name="loginForm" method="post" action="/miniproject/member/login.do">
			<table>
				<tr height="50">
					<td align="center" width="70">아이디</td>
					<td><input type="text" name="id" style="width: 150px;background-color:transparent;"></td>
				</tr>
				<tr>
					<td align="center">비밀번호</td>
					<td><input type="password" name="pwd" style="width: 150px;background-color:transparent;"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<div class="col-md-6 col-sm-6 col-xs-6">
					<a href="javascript:checkLogin()" class="btn btn-sm animated-button victoria-two">LOGIN</a> 
					 </div>
					 <div class="col-md-6 col-sm-6 col-xs-6">
					<a href="/miniproject/member/writeForm.do" class="btn btn-sm animated-button victoria-one">SIGN UP</a>
					</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
