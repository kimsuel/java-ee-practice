<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div align="center">
	${sessionScope.memName}님 로그인 성공하였습니다<br><br>
	<input type="button" class="btn btn-link " value="로그아웃" onclick="location.href='/miniproject/member/logout.do'">
	<input type="button" class="btn btn-link " value="회원정보수정" onclick="location.href='/miniproject/member/modifyForm.do'">	
</div>
