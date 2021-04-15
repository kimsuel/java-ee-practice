<%@page import="java.net.URLEncoder"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//데이터
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	// DB
	MemberDAO memberjspDAO = MemberDAO.getInstance();
	String[] ar = memberjspDAO.login(id,pwd);
	String name = ar[0];
	String email = ar[1]+"@"+ar[2];

	if(name == null) {
		response.sendRedirect("loginFail.jsp");
	} else {
		//response.sendRedirect("loginOk.jsp?name="+URLEncoder.encode(name,"utf-8")+"&id="+id);

		//쿠키
		/*
		Cookie cookie = new Cookie("memName",URLEncoder.encode(name,"utf-8")); //생성
		cookie.setMaxAge(30*60); // 초단위 - 30분
		response.addCookie(cookie); //클라이언트에 저장
		
		Cookie cookie2 = new Cookie("memId",id); 
		cookie2.setMaxAge(30*60);
		response.addCookie(cookie2);
		*/
		
		//세션 - 기본 30분
		//HttpSession session = request.getSession(); //생성
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		session.setAttribute("memEmail", email);
		//session.setMaxInactiveInterval(30*60); // 초단위
		
		//session.setAttribute("memDTO",memberDTO);
		// dto로 잡을 경우 한꺼번에 잡을 때 사용
		
		response.sendRedirect("loginOk.jsp");
	}
%>		