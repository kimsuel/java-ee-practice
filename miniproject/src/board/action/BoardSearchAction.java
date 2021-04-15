package board.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardSearchAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
		String searchBox = request.getParameter("searchBox");
		String search = request.getParameter("search");
		
		// 페이징처리 - 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		// DB
		Map<String, String> map = null;
		if(searchBox != null && search != null && searchBox !="" && search !=""){
			map = new HashMap<String, String>();
			map.put("columnName", searchBox);
			map.put("value", search);
			map.put("endNum", endNum+"");
			map.put("startNum", startNum+"");
		}

		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = boardDAO.search(map);

		// 페이징처리
		int totalA = boardDAO.searchTotalA(map); // 총글수
		BoardPaging boardPaging = new BoardPaging();

		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);

		boardPaging.makeSearchPagingHTML();

		// 조회수 새로고침 방지
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		if (id != null) {
			Cookie cookie = new Cookie("memHit", "0");
			cookie.setMaxAge(30 * 60); // 초단위
			// 클라이언트에게 보내기
			response.addCookie(cookie);
		}

		// 응답
		request.setAttribute("pg", pg);
		request.setAttribute("searchBox", searchBox);
		request.setAttribute("search", search);
		request.setAttribute("list", list);
		request.setAttribute("boardPaging", boardPaging);
		
		request.setAttribute("display", "/board/boardList.jsp");
		return "/main/index.jsp";
	}

}
