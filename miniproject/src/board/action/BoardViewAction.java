package board.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		BoardDAO boardDAO = BoardDAO.getInstance();

		// 쿠키 이용하여 조회수 제어	( 새로고침 방지 )	
		Cookie[] cookies = request.getCookies(); //모든 쿠키 얻어오기
		if(cookies != null) {
			for(int i=0; i<cookies.length;i++) {
				if(cookies[i].getName().equals("memHit")) { 
					// 쿠키가 있는지 물어보기
					boardDAO.hitUpdate(seq); // 쿠키가 있을 때 조회수 증가 
					cookies[i].setMaxAge(0); // 쿠키 죽이기
					response.addCookie(cookies[i]);
				}
			}
		}
		
		//조회수 증가
		//boardDAO.hitUpdate(seq);
		
		BoardDTO boardDTO = boardDAO.boardView(seq);
		
		request.setAttribute("pg", pg);
		request.setAttribute("boardDTO", boardDTO);
		
		request.setAttribute("display", "/board/boardView.jsp");
		return "/main/index.jsp";
	}

}
