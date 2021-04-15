package imageboard.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;


public class ImageboardWriteAction implements CommandProcess{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String realFolder = request.getServletContext().getRealPath("/storage");
		
		//업로드
		MultipartRequest multi = new MultipartRequest(request
													 ,realFolder
													 ,5*1024*1024
													 ,"UTF-8"
													 , new DefaultFileRenamePolicy());
		
		//데이터
		String imageId = multi.getParameter("imageId");
		String imageName = multi.getParameter("imageName");
		int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
		int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
		String imageContent = multi.getParameter("imageContent");
		String image1 = multi.getOriginalFileName("image1");

		//DB
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(imageId);
		imageboardDTO.setImageName(imageName);
		imageboardDTO.setImagePrice(imagePrice);
		imageboardDTO.setImageQty(imageQty);
		imageboardDTO.setImageContent(imageContent);
		imageboardDTO.setImage1(image1);
		
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		imageboardDAO.imageboardWrite(imageboardDTO);
		
		request.setAttribute("display", "/imageboard/imageboardWrite.jsp");
		return "/main/index.jsp";
	}
}
