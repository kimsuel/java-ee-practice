package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/list")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get방식인 이유 : post로 요청하는 것이 없어서(요청이 없을 시 get방식으로 처리), 
		//               (onclick=location.href처럼 )링크 걸어서 주소 넘기는 건 보통 get방식
		
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//페이징처리 - 1페이지당 3개씩
		int endNum = pg*3;
		int startNum = endNum-2;
		
		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		ArrayList<GuestbookDTO> list = guestbookDAO.guestbookList(startNum, endNum);

		int totalA = guestbookDAO.getTotalA(); // 총글수
		int totalP = (totalA+2)/3; // 총 페이지 수 
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>글목록</title>");
		out.println("<style>");
		//out.println("a:link {color : blue;}");
		//out.println("a:visited {color : red;}");
		//out.println("a:hover {color : green;}");
		//out.println("a:active {color : yellow;}");
		
		out.println("#currentPaging {color : red;}");
		out.println("#paging {color : black; text-decoration:none}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		for(int i=1; i<=totalP; i++) {
			if(i==pg) {
				out.println("[<a href='list?pg="+i+"' id=currentPaging >"+i+"</a>]");	
				       // 원래 주소 : /guestbookservlet/list?pg=1,2,3,4,5
			}else {
				out.println("[<a href='list?pg="+i+"' id=paging >"+i+"</a>]");
			}
		}
		out.println("<br><br>");

		for (GuestbookDTO guestbookDTO : list) {
			out.println("<table border=1 cellpadding=5 cellspacing=0 >");
			out.println("<tr>");
			out.println("<td width=80 align=center>작성자</td>");
			out.println("<td width=80 align=center>");
			out.println(guestbookDTO.getName());
			out.println("</td>");
			out.println("<td width=90 align=center>작성일</td>");
			out.println("<td align=center>");
			out.println(guestbookDTO.getLogtime());
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td align=center>이메일</td>");
			out.println("<td colspan=3>");
			out.println(guestbookDTO.getEmail());
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td align=center>홈페이지</td>");
			out.println("<td colspan=3>");
			out.println(guestbookDTO.getHomepage());
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td align=center>제목</td>");
			out.println("<td colspan=3>");
			out.println(guestbookDTO.getSubject());
			out.println("</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td align=center>내용</td>");
			//out.println("<td colspan=3>");
			//out.println("<textarea readonly=readonly cols=40 rows=10 name=content>");
			out.println("<td colspan=3><pre>");
			// <pre> : 입력한 그대로 나타내주는 태그(띄어쓰기 같은 )
			out.println(guestbookDTO.getContent());
			out.println("</pre></td>");
			//out.println("</textarea>");
			out.println("</td>");
			out.println("</tr>");

			out.println("</table>");
			out.println("<hr color=orange width=400px align=left>"); 
			// 바로 color를 쓰는 건 hr의 속성
			// style=color:red 라고 쓰면 css
			out.println("</body>");
			out.println("</html>");
		}
	}

}

