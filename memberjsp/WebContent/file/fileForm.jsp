<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="" method="post" enctype="multipart/form-data" action="fileUpload.jsp">
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<td align="center">제목</td>
			<td><input type="text" name="subject" style="width:300px;" placeholder="제목입력"></td>
		</tr>
		<tr>
			<td align="center">내용</td>
			<td><textarea name="content" cols="40" rows="10" placeholder="내용입력"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="file" name="upload1" size="50">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="file" name="upload2" size="50">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="파일업로드">
			</td>
		</tr>
	
	</table> 
</form>
</body>
</html>