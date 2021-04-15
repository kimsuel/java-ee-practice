<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//request.setAttribute("변수", "값");
request.setAttribute("apple", "사과");

//페이지 이동
response.sendRedirect("sendResult.jsp");
%>