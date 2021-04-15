<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URLEncoder"%>
<% 
String fileName = request.getParameter("fileName"); 
String realFolder = request.getServletContext().getRealPath("/storage");

//다운로드 받을 파일 생성
File file = new File(realFolder, fileName);
fileName = URLEncoder.encode(fileName,"UTF-8").replace("+"," ");

response.setHeader("Content-Disposition","attachment;fileName="+fileName);
response.setHeader("Content-Length", file.length()+"");

BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));    //입력
BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream()); //출력

out.clear();
out = pageContext.pushBody();


/* 
int data;
while((data = bis.read()) != 1){
	bos.write((char)data);
}
 */
int size = (int)file.length();
byte[] b = new byte[size];
bis.read(b,0,size);
bos.write(b);

bos.close();
bis.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>