package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		String name = memberDAO.login(id,pwd);

		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>로그인</title>");
		out.println("</head>");
		out.println("<body>");
		if (name==null) {
			//out.println("없는 아이디입니다<br>");
			out.println("로그인 실패! 다시 로그인하세요<br><br>");
			out.println("<input type=button value=뒤로 onclick='javascript:history.go(-1)'>");
		//} else if (ch == 0) {
			//out.println("비밀번호가 일치하지 않습니다<br>");
			//out.println("<input type=button value=뒤로 onclick='javascript:history.go(-1)'>");
		} else out.println(name+"님 로그인 성공!!");

		out.println("</body>");
		out.println("</html>");
	}

}
