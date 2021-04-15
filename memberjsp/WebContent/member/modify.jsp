<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="memberjspDTO" class="member.bean.MemberjspDTO"/>
<jsp:setProperty property="*" name="memberjspDTO"/>

<%
	// useBean은 기본생성자밖에 사용하지 못하기 때문에 사용하지 않음

//DB
MemberDAO memberjspDAO = MemberDAO.getInstance();
memberjspDAO.modify(memberjspDTO);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원수정</title>
<script type="text/javascript">
window.onload=function(){
	alert("수정하였습니다");
	location.href='loginForm.jsp';
}
</script>
</head>
<body>

회원수정이 완료되었습니다.

</body>
</html>