<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/*
//쿠키
Cookie[] ar = request.getCookies();
if(ar != null){
	for(int i=0; i<ar.length; i++){
		if(ar[i].getName().equals("memName")){
			ar[i].setMaxAge(0); //쿠키 소멸
			response.addCookie(ar[i]); //클라이언트에게 쿠키소멸사실 보내기(알리기)
		}
		if(ar[i].getName().equals("memId")){
			ar[i].setMaxAge(0); //쿠키 소멸
			response.addCookie(ar[i]);
		}
	}
}
*/

//세션
session.removeAttribute("memName");
session.removeAttribute("memId");
session.invalidate(); //모든 세션 소멸

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그아웃</title>
</head>
<body>
<img src="../image/minion4.gif" width="100" height="100" 
	style="cursor:pointer;" onclick="location.href='../main/index.jsp'">
로그아웃되었습니다
</body>
</html>