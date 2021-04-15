package member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

public class CheckPostAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");

		//데이터
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");
		String roadname = request.getParameter("roadname");
		
		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		ArrayList<ZipcodeDTO> list = null;
		if(sido != null && roadname != null){
			list = memberDAO.getZipcodeList(sido, sigungu, roadname);
		}

		request.setAttribute("list", list);
		return "/member/checkPost.jsp";
	}

}
