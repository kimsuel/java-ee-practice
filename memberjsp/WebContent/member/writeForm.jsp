<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="../js/member.js">
</script>
</head>
<body>
	<h2><img src="../image/minion4.gif" width="100" height="100" 
	style="cursor:pointer;" onclick="location.href='../main/index.jsp'">회원가입</h2>
	<form name="writeForm" method="post" action="write.jsp">
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" placeholder="이름입력" name="name"></td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" style="width: 200px;" placeholder="아이디 입력">
					<input type="hidden" name="idChk" value="">
					<input type="button" value="중복체크" onclick="checkId()">
				</td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" style="width: 250px;" name="pwd"></td>
			</tr>
			<tr>
				<td align="center">재확인</td>
				<td><input type="password" style="width: 250px;" name="repwd"></td>
			</tr>
			<tr>
				<td align="center">성별</td>
				<td><input type="radio" name="gender" checked value="0">남
					<input type="radio" name="gender" value="1">여</td>
			</tr>
			<tr>
				<td align="center">이메일</td>
				<td><input type="text" name="email1"> @ 
				<select name="email2" style="width: 100px; height: 22px;">
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="google.com">google.com</option>
						<option value="nate.com">nate.com</option>
				</select></td>
			</tr>
			<tr>
				<td align="center">핸드폰</td>
				<td><select name="tel1" style="width: 70px; height: 22px;">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="012">012</option>
						<option value="012">019</option>
				</select> - <input type="text" name="tel2" style="width: 70px;"> - <input
					type="text" name="tel3" style="width: 70px;"></td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td><input type="text" name="zipcode" id="zipcode" readonly style="width: 80px;">
					<input type="button" value="우편번호검색" onclick="checkPost()"><br> 
					<input type="text" name="addr1" id="addr1" readonly placeholder="주소" style="width: 300px;"><br>
					<input type="text" name="addr2" id="addr2" placeholder="상세주소"
					style="width: 300px;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="회원가입" onclick="checkWrite()"> 
				<input type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>
</body>
</html>