<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/main.css">

<font class="top">
<img src="../image/minion4.gif" width="70" height="70"
 style="cursor:pointer;" onclick="location.href='../main/index.do'">
MVC를 이용한 미니프로젝트</font>

<div align="right">
<c:if test="${sessionScope.memId == null}">
<ul>
<li><a href="/miniproject/board/boardList.do?pg=1">글목록</a></li>
</ul>
</c:if>
<c:if test="${sessionScope.memId != null}">
<ul>
<li><a href="/miniproject/board/boardWriteForm.do">글쓰기</a></li>
<li><a href="/miniproject/imageboard/imageboardWriteForm.do">이미지등록</a></li>
<li><a href="/miniproject/board/boardList.do?pg=1">글목록</a></li>
<li><a href="/miniproject/imageboard/imageboardList.do?pg=1">이미지목록</a></li>
</ul>
</c:if>
</div>