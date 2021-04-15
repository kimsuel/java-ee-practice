<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../css/main.css">
<script type="text/javascript" src="../js/member.js">
</script>
</head>
<body>
<div class="container" align="center">
	<h2>회원가입</h2>
	<form name="writeForm" method="post" action="write.do">
		<table>
			<tr height="35">
				<td width="70" align="center">이름</td>
				<td align="left"><input type="text" style="background-color:transparent;" name="name"></td>
			</tr>
			<tr height="35">
				<td align="center">아이디</td>
				<td align="left">
					<input type="text" name="id" style="width: 200px; background-color:transparent;">
					<input type="hidden" name="idChk" value="">
					<input type="button" class="btn btn-link " value="중복체크" onclick="checkId()">
				</td>
			</tr>
			<tr height="35">
				<td align="center">비밀번호</td>
				<td align="left"><input type="password" style="width: 250px;background-color:transparent;" name="pwd"></td>
			</tr>
			<tr height="35">
				<td align="center">재확인</td>
				<td align="left"><input type="password" style="width: 250px;background-color:transparent;" name="repwd"></td>
			</tr>
			<tr height="35">
				<td align="center">성별</td>
				<td align="left"><input type="radio" name="gender" checked value="0">남
					<input type="radio" name="gender" value="1">여</td>
			</tr>
			<tr height="35">
				<td align="center">이메일</td>
				<td align="left"><input type="text" style="background-color:transparent;" name="email1"> @ 
				<select name="email2" style="width: 100px; height: 22px;background-color:transparent;">
						<option value="naver.com" >naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="google.com">google.com</option>
						<option value="nate.com">nate.com</option>
				</select></td>
			</tr>
			<tr height="35">
				<td align="center">핸드폰</td>
				<td align="left"><select name="tel1" style="width: 70px; height: 22px;background-color:transparent;">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="012">012</option>
						<option value="012">019</option>
				</select> - <input type="text" name="tel2" style="width:70px;background-color:transparent;"> - <input
					type="text" name="tel3" style="width:70px;background-color:transparent;"></td>
			</tr>
			<tr height="35">
				<td align="center">주소</td>
				<td align="left"><input type="text" name="zipcode" id="zipcode" readonly style="width: 80px;background-color:transparent;">
					<input type="button" class="btn btn-link " value="우편번호검색" onclick="checkPost()"><br> 
					<input type="text" name="addr1" id="addr1" readonly style="width: 300px;background-color:transparent;"><br>
					<input type="text" name="addr2" id="addr2" style="width: 300px;background-color:transparent;"></td>
			</tr>
			<tr>
				<td colspan="2">
				<div class="col-md-5 col-sm-3 col-xs-5">
				<a href="javascript:checkWrite()" class="btn btn-sm animated-button victoria-three">REGISTER</a>
				</div>
				<div class="col-md-5 col-sm-3 col-xs-5">
				<a href="writeForm.do" class="btn btn-sm animated-button victoria-four">AGAIN</a>
				</div>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>