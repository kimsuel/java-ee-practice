<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link rel="stylesheet" href="../css/member.css">
</head>
<body>
<div align="center">
<h2 id="main">
<img src="../image/minionleft.gif" width="120" height="170" style="cursor:pointer;"> 
WELCOME!
<img src="../image/minionright.gif" width="120" height="170" style="cursor:pointer;"> 
</h2>
</div>
<hr color="#8BBDFF">
<div align="right">
<ul>
<% if(session.getAttribute("memId") == null){ %>
<li><a href="../member/writeForm.jsp">회원가입</a></li>
<li><a href="../member/loginForm.jsp">로그인</a></li>
<% }else{ %>
<li><a href="../member/logout.jsp">로그아웃</a></li>
<li><a href="../member/modifyForm.jsp">회원정보수정</a></li>
<li><a href="../board/boardWriteForm.jsp">글쓰기</a></li>
<% } %>
<li><a href="../board/boardList.jsp?pg=1">글목록</a></li>
</ul>
</div>
</body>
</html>