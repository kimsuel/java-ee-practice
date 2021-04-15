<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/imageboard.css">
<script type="text/javascript" src="../js/imageboard.js">
</script>
</head>
<body>
<form name="imageboardWriteForm" method="post" enctype="multipart/form-data" action="imageboardWrite.do">
	<table class="table table-bordered">
		<tr>
			<td align="center" width="100px">상품코드</td>
			<td><input type="text" name="imageId" value="img_" style="background-color:transparent; width:60%;"></td>
		</tr>
		<tr>	
			<td align="center">상품명</td>
			<td><input type="text" name="imageName" style="background-color:transparent;width:80%;"></td>
		</tr>
		<tr>	
			<td align="center">단가</td>
			<td><input type="text" name="imagePrice" style="background-color:transparent;width:50%;"></td>
		</tr>
		<tr>	
			<td align="center">개수</td>
			<td><input type="text" name="imageQty" style="background-color:transparent;width:50%;"></td>
		</tr>
		<tr>	
			<td align="center">내용</td>
			<td><textarea name="imageContent" style="background-color:transparent;width:100%;" cols="50" rows="10"></textarea></td>
		</tr>
		<tr>	
			<td colspan="2"><input type="file" name="image1" size="50" style="background-color:transparent;"></td>
		</tr>
		<tr>	
			<td colspan="2" align="center">
			<input type="submit" class="btn btn-primary" value="이미지등록">
			&nbsp;
			<input type="reset" class="btn btn-primary" value="다시작성"></td>
		</tr>
	</table>
</form>
</body>
</html>