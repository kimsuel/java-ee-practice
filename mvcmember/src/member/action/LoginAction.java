package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class LoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		String[] ar = memberDAO.login(id, pwd);
		String name = ar[0];
		String email = ar[1]+"@"+ar[2];
		
		//응답
		if(name == null) {
			return "loginFail.jsp";
		}else {
			//세션
			HttpSession session = request.getSession(); //생성
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", email);
			return "loginOk.jsp";
		}
	}

}
