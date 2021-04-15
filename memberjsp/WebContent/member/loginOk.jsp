<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
request.setCharacterEncoding("UTF-8");
//String name = request.getParameter("name"); 
//String id = request.getParameter("id"); 

String name=null;
String id=null;

/*
//쿠키 - 특정 쿠키만 가져올 수 없고 모든 쿠키를 얻어와야 함
Cookie[] ar = request.getCookies();
if(ar!=null){
	for(int i=0; i<ar.length;i++){
		
		//String cookieName = ar[i].getName(); //쿠키명
		//String cookieValue = URLDecoder.decode(ar[i].getValue(),"UTF-8"); //쿠키값
		
		//out.println("쿠키명="+cookieName);
		//out.println("쿠키값="+cookieValue+"<br>");
	
		
		if(ar[i].getName().equals("memName"))
			name = URLDecoder.decode(ar[i].getValue(),"UTF-8");
		if(ar[i].getName().equals("memId"))
			id = ar[i].getValue();
	}
}
*/

//세션
name = (String)session.getAttribute("memName");
id = (String)session.getAttribute("memId");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인성공</title>
</head>
<body>
<form method="post" action="modifyForm.jsp">
<img src="../image/minion4.gif" width="100" height="100" 
	style="cursor:pointer;" onclick="location.href='../main/index.jsp'">
<input type="hidden" name="id" value="<%=id%>">
	<%=name%>님 로그인 성공하였습니다<br><br>
	<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
	<input type="submit" value="회원정보수정">	
</form>
</body>
</html>