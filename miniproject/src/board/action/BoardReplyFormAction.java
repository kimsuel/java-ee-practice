package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardReplyFormAction implements CommandProcess {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pseq = Integer.parseInt(request.getParameter("pseq"));  //원글 번호
		int pg = Integer.parseInt(request.getParameter("pg"));      //원글 페이지 번호
		
		request.setAttribute("pseq", pseq);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReplyForm.jsp");
		return "/main/index.jsp";
	}
}
