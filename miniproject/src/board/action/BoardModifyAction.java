package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardModifyAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(seq);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardModify(boardDTO);
		
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardModify.jsp");
		return "/main/index.jsp";
	}

}
