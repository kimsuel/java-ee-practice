<%@ page import="member.dao.MemberDAO"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
<script type="text/javascript" src="../js/member.js">
</script>
<script type="text/javascript">
window.onload= function(){
	document.modifyForm.gender['${memberDTO.gender}'].checked = true;
	//document.getElementById('gen')['${memberDTO.gender}'].checked = true;
	
	//document.modifyForm.email2.value = '${memberDTO.email2}'
	document.getElementById('email2').value= '${memberDTO.email2}'
	
	document.modifyForm.tel1.value = '${memberDTO.tel1}'
}

</script>
</head>
<body>
<div class="container" align="center">
	<h2>회원정보수정</h2>
	<form name="modifyForm" method="post" action="modify.do">
		<table>
			<tr height="35">
				<td width="70" align="center">이름</td>
				<td align="left"><input type="text" name="name" style="background-color:transparent;" value="${memberDTO.name}"></td>
			</tr>
			<tr height="35">
				<td align="center">아이디</td>
				<td align="left">
					<input type="text" name="id" value="${memberDTO.id}" style="width: 200px;background-color:transparent;" readonly>
				</td>
			</tr>
			<tr height="35">
				<td align="center">비밀번호</td>
				<td align="left"><input type="password" name="pwd" style="width: 250px;background-color:transparent;" ></td>
			</tr>
			<tr height="35">
				<td align="center">재확인</td>
				<td align="left"><input type="password" name="repwd" style="width: 250px;background-color:transparent;" ></td>
			</tr>
			<tr height="35">
				<td align="center">성별</td>
				<td align="left"><input type="radio" name="gender" id="gen" value="0" >남
					<input type="radio" name="gender" id="gen" value="1" >여</td>
			</tr>
			<tr height="35">
				<td align="center">이메일</td>
				<td align="left"><input type="text" name="email1" value="${memberDTO.email1}" style="width: 120px;background-color:transparent;"> 
					@ 
					<select name="email2" id="email2" style="width: 100px; height: 22px;background-color:transparent;">
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="google.com">google.com</option>
						<option value="nate.com">nate.com</option>
				</select></td>
			</tr>
			<tr height="35">
				<td align="center">핸드폰</td>
				<td align="left"><select name="tel1" id="tel1" style="width: 70px; height: 22px;background-color:transparent;">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="012">012</option>
						<option value="012">019</option>
				</select> - <input type="text" name="tel2" value="${memberDTO.tel2}" style="width: 70px;background-color:transparent;"> - <input
					type="text" name="tel3" value="${memberDTO.tel3}" style="width: 70px;background-color:transparent;"></td>
			</tr>
			<tr height="35">
				<td align="center">주소</td>
				<td align="left"><input type="text" name="zipcode" id="zipcode" value="${memberDTO.zipcode}" style="width: 80px;background-color:transparent;">
					<input type="button" class="btn btn-link " value="우편번호검색" onclick="checkPost()"><br> <input
					type="text" name="addr1" id="addr1" value="${memberDTO.addr1}" style="width: 300px;background-color:transparent;"><br>
					<input type="text" name="addr2" id="addr2" value="${memberDTO.addr2}"
							style="width: 300px;background-color:transparent;"></td>
			</tr>
			<tr height="35">
				<td colspan="2" align="center">
				<div class="col-md-5 col-sm-3 col-xs-5">
					<a href="javascript:checkModify()" class="btn btn-sm animated-button victoria-three">UPDATE</a>
				</div>
				<div class="col-md-5 col-sm-3 col-xs-5">
					<a href="modifyForm.do" class="btn btn-sm animated-button victoria-four">AGAIN</a>
				</div>
			</tr>
		</table>
	</form>
</div>
</body>
</html>