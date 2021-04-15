package imageboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.dao.ImageboardDAO;

public class ImageboardDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String[] seq = request.getParameterValues("seq");
		
		//DB
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		imageboardDAO.imageboardDelete(seq);
		/*for(int i=0; i<seq.length;i++) {
			imageboardDAO.imageboardDelete(seq[i]);
		}*/
		
		request.setAttribute("display", "/imageboard/imageboardDelete.jsp");
		return "/main/index.jsp";
	}

}
