<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
   request.setCharacterEncoding("UTF-8");

   String id = (String)session.getAttribute("memId"); 
   String name = (String)session.getAttribute("memName"); 
   String email = (String)session.getAttribute("memEmail"); 
   String subject = request.getParameter("subject");
   String content = request.getParameter("content");

   Map<String,String> map = new HashMap<String,String>();
   map.put("id", id);
   map.put("name",name);
   map.put("email",email);
   map.put("subject",subject);
   map.put("content",content);
   
/*
   BoardDTO boardDTO = new BoardDTO();
   boardDTO.setId(id);
   boardDTO.setName(name);
   boardDTO.setEmail(email);
   boardDTO.setSubject(subject);
   boardDTO.setContent(content);
*/
   BoardDAO boardDAO = BoardDAO.getInstance();
   boardDAO.boardWrite(map);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
<script type="text/javascript">
window.onload=function(){
alert("작성하신 글을 저장하였습니다");
location.href='boardList.jsp?pg=1';
}
</script>

</body>
</html>