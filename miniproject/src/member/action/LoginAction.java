package member.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = memberDAO.login(map);
		String name = memberDTO.getName();
		String email = memberDTO.getEmail1()+"@"+memberDTO.getEmail2();
		
		//응답
		String loginResult = null;
		if(name == null) {
			loginResult="fail";
		}else {
			//세션
			HttpSession session = request.getSession(); //생성
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", email);
		}
		request.setAttribute("loginResult", loginResult);
		request.setAttribute("display", "/template/body.jsp");
		return "/main/index.jsp";
	}

}
