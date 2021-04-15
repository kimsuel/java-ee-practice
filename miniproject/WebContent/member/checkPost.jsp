<%@page import="java.util.ArrayList"%>
<%@page import="member.bean.ZipcodeDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소검색</title>

<link rel="stylesheet" href="../css/member.css">

<script type="text/javascript" src="../js/member.js">
</script>
</head>
<body>
<form method="post" action="checkPost.do">
<table border="1" width="100%">
	<tr>
		<td align="center">시도</td>
		<td><select name="sido">
			<option value="시도선택">시도선택</option>
			<option value="서울">서울</option>
			<option value="인천">인천</option>
			<option value="대전">대전</option>
			<option value="대구">대구</option>
			<option value="울산">울산</option>
			<option value="세종">세종</option>
			<option value="광주">광주</option>
			<option value="부산">부산</option>
			<option value="경기">경기</option>
			<option value="강원">강원</option>
			<option value="충북">충북</option>
			<option value="충남">충남</option>
			<option value="전북">전북</option>
			<option value="전남">전남</option>
			<option value="제주">제주</option>
			</select></td>
		<td align="center">시.군.구</td>
		<td><input type="text" name="sigungu"></td>
	</tr>
	<tr>
		<td align="center">도로명</td>
		<td colspan="3"><input type="text" name="roadname">
			<input type="submit" value="검색"></td>
	</tr>
	<tr>
		<td align="center">우편번호</td>
		<td colspan="3" align="center">주소</td>
	</tr>
<c:if test="${list != null}">
<c:forEach var="zipcodeDTO" items="${list}">
<c:set var="address">
	${zipcodeDTO.sido
	} ${zipcodeDTO.sigungu
	} ${zipcodeDTO.yubmyundong
	} ${zipcodeDTO.ri
	} ${zipcodeDTO.roadname
	} ${zipcodeDTO.buildingname}
</c:set>	
	<tr>
	<td width="50px" align="center">${zipcodeDTO.zipcode}</td>
	<td colspan="3"><a id="addressA" href="javascript:void(0)" onclick="checkPostClose('${zipcodeDTO.zipcode}','${address}')">${address}</a></td>
	                       <!-- javascript:void(0) : 페이지 이동하지 마라 / # : 자기 자신 페이지로 이동이 됨 -->
	</tr>
</c:forEach>
</c:if>	
</table>
</form>
</body>
</html>
