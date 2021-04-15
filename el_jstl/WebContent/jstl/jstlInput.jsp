<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlInput</title>
</head>
<body>
	<form name="" method="post" action="jstlResult.jsp">
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="70" align="center">나이</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td align="center">색깔</td>
				<td><select name="color" style="width: 80px;">
						<option value="red">빨강</option>
						<option value="green">초록</option>
						<option value="blue">파랑</option>
						<option value="magenta">보라</option>
						<option value="cyan">하늘</option>
				</select></td>
			</tr>
			<tr>
				<td align="center">취미</td>
				<td>
				<input type="checkbox" name="hobby" value="독서">독서 
				<input type="checkbox" name="hobby" value="영화">영화 
				<input type="checkbox" name="hobby" value="음악">음악 
				<input type="checkbox" name="hobby" value="운동">운동 
				<input type="checkbox" name="hobby" value="게임">게임
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="보내기"> 
				<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>