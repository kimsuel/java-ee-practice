<%@ page import="member.dao.MemberDAO"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="memberDTO" class="member.bean.MemberjspDTO" scope="session"/>

<%
	String id = (String)session.getAttribute("memId");
	//String id = request.getParameter("id");
	MemberDAO memberjspDAO = MemberDAO.getInstance();
   	MemberDTO memberjspDTO = memberjspDAO.memberList(id);
   	
   	// session을 dto로 잡은 경우 dto생성하지 않고 바로
   	// session으로 dto값을 불러오면 됨
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
<script type="text/javascript" src="../js/member.js">
</script>
<script type="text/javascript">
window.onload= function(){
	document.modifyForm.gender['<%=memberjspDTO.getGender()%>'].checked = true;
	//document.getElementById('gen')['<%=memberjspDTO.getGender()%>'].checked = true;
	
	//document.modifyForm.email2.value = '<%=memberjspDTO.getEmail2()%>'
	document.getElementById('email2').value= '<%=memberjspDTO.getEmail2()%>'
	
	document.modifyForm.tel1.value = '<%=memberjspDTO.getTel1()%>'
}

</script>
</head>
<body>
	<h2>회원정보수정</h2>
	<form name="modifyForm" method="post" action="modify.jsp">
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" name="name" value="<%=memberjspDTO.getName() %>"></td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" value="<%=id %>" style="width: 200px;" readonly>
				</td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" style="width: 250px;" ></td>
			</tr>
			<tr>
				<td align="center">재확인</td>
				<td><input type="password" name="repwd" style="width: 250px;" ></td>
			</tr>
			<tr>
				<td align="center">성별</td>
				<td><input type="radio" name="gender" id="gen" value="0" >남
					<input type="radio" name="gender" id="gen" value="1" >여</td>
			</tr>
			<tr>
				<td align="center">이메일</td>
				<td><input type="text" name="email1" value="<%=memberjspDTO.getEmail1() %>" style="width: 120px;"> 
					@ 
					<select name="email2" id="email2" style="width: 100px; height: 22px;">
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="google.com">google.com</option>
						<option value="nate.com">nate.com</option>
				</select></td>
			</tr>
			<tr>
				<td align="center">핸드폰</td>
				<td><select name="tel1" id="tel1" style="width: 70px; height: 22px;">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="012">012</option>
						<option value="012">019</option>
				</select> - <input type="text" name="tel2" value="<%=memberjspDTO.getTel2() %>" style="width: 70px;"> - <input
					type="text" name="tel3" value="<%=memberjspDTO.getTel3() %>" style="width: 70px;"></td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td><input type="text" name="zipcode" id="zipcode" value="<%=memberjspDTO.getZipcode() %>" style="width: 80px;">
					<input type="button" value="우편번호검색" onclick="checkPost()"><br> <input
					type="text" name="addr1" id="addr1" value="<%=memberjspDTO.getAddr1() %>" style="width: 300px;"><br>
					<input type="text" name="addr2" id="addr2" value="<%=memberjspDTO.getAddr2() %>"
					style="width: 300px;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="정보수정" onclick="checkModify()"> 
				<input type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>
</body>
</html>