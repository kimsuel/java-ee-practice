<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="checkId" method="post" action="checkId.do">
${requestScope.id}는 사용할 수 없습니다<br><br>
	아이디 <input type="text" name="id" style="width:120px;">
		<input type="submit" value="중복체크">
</form>
</body>
</html>