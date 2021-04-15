<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlTest</title>
</head>
<body>
<h3>** 변수 설정 **</h3>
<c:set var="name" value="홍길동"/>
<c:set var="age">25</c:set>
나의 이름은 <c:out value="${name}"/>입니다<br>
내 나이는 ${age}살입니다<br>
내 나이는 ${ageee }살입니다<br>
<!-- 에러 발생하지 않음 -->


<h3>** 변수 삭제 **</h3>
<c:remove var="name"/>
나의 이름은 <c:out value="${name}"/>입니다<br>
<!-- 에러 안 뜨고 그냥 안 나옴 -->
내 나이는 ${age}살입니다<br>


<h3>** forEach **</h3>
<c:forEach var="i" begin="1" end="10" step="1">
${i}
</c:forEach>

<br><br>
<c:forEach var="i" begin="1" end="10" step="1">
<c:set var="sum" value="${sum+i}"></c:set>
</c:forEach>
1~10까지의 합 = ${sum}

<br><br>
<!-- step : 0,음수 안됨 -->
<c:forEach var="i" begin="1" end="10" step="1">
${10-i+1}
</c:forEach>

<h3>** 문자열 분리 **</h3>
<c:forTokens var="car" items="소나타,아우디,링컨,페라리,벤츠" delims=",">
${car}<br>
</c:forTokens>

<h3>** jstlExam.jsp에서 넘어온 데이터 출력**</h3>
결과 = ${requestScope.list}

<h3>** 인텍스 2번째 데이터 출력 **</h3>
결과 = ${list[2]}
<!-- ${requestScope.list} = request.getAttribute("list") -->
<!-- forward : 주소는 jstlExam.jsp 에 머물러있지만 결과는 jstlTest.jsp가 나옴 -->

<h3>** list2의 모든 데이터 출력 **</h3>
<c:forEach var="i" begin="0" end="2" step="1">
이름 : ${list2[i].getName()}     
나이 : ${list2[i].getAge()}<br><br>
</c:forEach>
<br>

<h4>확장형 for문</h4>
<c:forEach var="dto" items="${list2}" varStatus="i">
index = ${i.index}  <!--  index : 0 1 2  -->
이름 : ${dto.name}     
나이 : ${dto.age}<br><br>
</c:forEach>
<br><br>
<c:forEach var="dto" items="${list2}" varStatus="i">
count = ${i.count} <!-- count : 1 2 3  -->
이름 : ${dto.name}     
나이 : ${dto.age}<br><br>
</c:forEach>
<!-- 
	getName() -> name
	메소드명도 변수명처럼 사용 가능
 -->
</body>
</html>