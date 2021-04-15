package board.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardReplyAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pseq = Integer.parseInt(request.getParameter("pseq")); //원글 번호
		int pg = Integer.parseInt(request.getParameter("pg"));     //원글 페이지 번호
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		String email = (String) session.getAttribute("memEmail");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("pseq", pseq+"");
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardReply(map);
		
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReply.jsp");
		return "/main/index.jsp";
	}

}
