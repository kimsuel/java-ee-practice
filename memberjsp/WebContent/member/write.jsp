<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<%
	//데이터
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDTO memberjspDTO = new MemberDTO();
		memberjspDTO.setName(name);
		memberjspDTO.setId(id);
		memberjspDTO.setPwd(pwd);
		memberjspDTO.setGender(gender);
		memberjspDTO.setEmail1(email1);
		memberjspDTO.setEmail2(email2);
		memberjspDTO.setTel1(tel1);
		memberjspDTO.setTel2(tel2);
		memberjspDTO.setTel3(tel3);
		memberjspDTO.setZipcode(zipcode);
		memberjspDTO.setAddr1(addr1);
		memberjspDTO.setAddr2(addr2);
		
		//DB
		MemberDAO memberjspDAO = MemberDAO.getInstance();
		int su = memberjspDAO.write(memberjspDTO);
%>
</head>
<body>
<% if(su==0){ %>
회원가입 실패했습니다
<br><br>
<% }else{ %>
회원가입되었습니다
<br><br>
<input type="button" value="로그인" onclick="location.href='loginForm.jsp'">
<% } %>
</body>
</html>