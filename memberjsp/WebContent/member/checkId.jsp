<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	// 데이터
String id = request.getParameter("id"); 

//db
MemberDAO memberjspDAO = MemberDAO.getInstance();
MemberDTO memberjspDTO = memberjspDAO.memberList(id);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>중복체크</title>
<script type="text/javascript" src="../js/member.js">
</script>
</head>
<body>
<form name="checkId" method="post" action="checkId.jsp">
<% if(memberjspDTO==null){ %>
	<%= id %>는 사용가능합니다<br><br>
	<input type="button" value="사용하기" onclick="checkIdClose('<%= id %>')">
	<input type="button" value="다시찾기" onclick="">
<% }else{ %>
	<%= id %>는 사용할 수 없습니다<br><br>
	아이디 <input type="text" name="id" style="width:120px;">
		<input type="submit" value="중복체크">
<% } %>
</form>
</body>
</html>