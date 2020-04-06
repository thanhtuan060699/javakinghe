package homework.api;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import homework.dto.LandDTO;
import homework.service.ILandService;
import homework.service.impl.LandService;


@WebServlet(urlPatterns = {"/api-land"})
public class LandAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LandAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	ILandService landService=new LandService();
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		LandDTO landDTO=new LandDTO();
		if (isMultipart) {
		try {
			 ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
			 ServletContext context = request.getSession().getServletContext();
			 String dirUrl1 = "C:\\Users\\Administrator\\Desktop\\Java-web8\\workspace-kinghe\\homework\\src\\main\\webapp"  
			 + "files";
			 response.getWriter().println(dirUrl1);
			 List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
			 if (!fileItem.isFormField()) {
				String nameimg = fileItem.getName();
				if (!nameimg.equals("")) {
					
					String dirUrl = "C:\\Users\\Administrator\\Desktop\\Java-web8\\workspace-kinghe\\homework\\src\\main\\webapp\\" 
					+  "files";
					File dir = new File(dirUrl);
					if (!dir.exists()) {
						dir.mkdir();
					}
				    String fileImg = dirUrl +"\\"+nameimg;
				    File file = new File(fileImg);//tạo file
				    fileItem.write(file);//lưu file
			    	landDTO.setImage(nameimg);
			    	
			   }
		    }else {
		    	String t=fileItem.getFieldName();
		    	if(t.equals("length")) {
		    		landDTO.setLength(Integer.parseInt(fileItem.getString()));
		    	}
		    	if(t.equals("width")) {
		    		landDTO.setWidth(Integer.parseInt(fileItem.getString()));
		    	}
		    	if(t.equals("address")) {
		    		landDTO.setAddress(fileItem.getString());
		    	}
		    	if(t.equals("direction")) {
		    		landDTO.setDirection(fileItem.getString());
		    	}
		    	if(t.equals("cost")) {
		    		landDTO.setCost(fileItem.getString());
		    	}
		    }
		 }
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	
	}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		LandDTO landDTO=new LandDTO();
		if (isMultipart) {
		try {
			 ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
			 ServletContext context = request.getSession().getServletContext();
			 String dirUrl1 = "C:\\Users\\Administrator\\Desktop\\Java-web8\\workspace-kinghe\\homework\\src\\main\\webapp"  
			 + "files";
			 response.getWriter().println(dirUrl1);
			 List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
			 if (!fileItem.isFormField()) {
				String nameimg = fileItem.getName();
				if (!nameimg.equals("")) {
					
					String dirUrl = "C:\\Users\\Administrator\\Desktop\\Java-web8\\workspace-kinghe\\homework\\src\\main\\webapp\\" 
					+  "files";
					File dir = new File(dirUrl);
					if (!dir.exists()) {
						dir.mkdir();
					}
				    String fileImg = dirUrl +"\\"+nameimg;
				    File file = new File(fileImg);//tạo file
				    fileItem.write(file);//lưu file
			    	landDTO.setImage(nameimg);
			    	
			   }
		    }else {
		    	String t=fileItem.getFieldName();
		    	if(t.equals("length")) {
		    		landDTO.setLength(Integer.parseInt(fileItem.getString()));
		    	}
		    	if(t.equals("width")) {
		    		landDTO.setWidth(Integer.parseInt(fileItem.getString()));
		    	}
		    	if(t.equals("address")) {
		    		landDTO.setAddress(fileItem.getString());
		    	}
		    	if(t.equals("direction")) {
		    		landDTO.setDirection(fileItem.getString());
		    	}
		    	if(t.equals("cost")) {
		    		landDTO.setCost(fileItem.getString());
		    	}
		    }
		 }
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
		landService.save(landDTO);
		
	
	}

}
