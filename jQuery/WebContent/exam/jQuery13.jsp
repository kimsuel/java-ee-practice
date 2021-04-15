<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
/* 
*{ position:absolute; margin: 0 0; padding: 0 0;}
.d1{width:50px; height:50px; background:red;}
.d2{width:50px; height:50px; background:green; top:100px; left:100px;}
.d3{width:50px; height:50px; background:blue; top:200px; left:200px;} */

*{ margin: 0 0; padding: 0 0;}
.d1{width:50px; height:50px; background:red;}
.d2{width:50px; height:50px; background:green; margin-top:100px; margin-left:100px;}
.d3{width:50px; height:50px; background:blue; margin-top:200px; margin-left:200px;}
/* 
* : 모든 태그 
top : 화면 끝 경계선부터 100px / position:absolute;로 설정해야 한다
margin-top : div 끝 경계선부터 100px
*/
</style>
</head>
<body>
<div class="d1"></div>
<div class="d2"></div>
<div class="d3"></div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('div').click(function(){
		var divOffset = $(this).offset();
		alert(divOffset.top+", "+divOffset.left);
	});
});
</script>
</body>
</html>