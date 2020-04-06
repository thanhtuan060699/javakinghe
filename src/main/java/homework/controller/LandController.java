package homework.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import homework.dto.LandDTO;
import homework.service.ILandService;
import homework.service.impl.LandService;

/**
 * Servlet implementation class LandController
 */
@WebServlet(urlPatterns = {"/admin-land"})
public class LandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ILandService landService=new LandService();
    public LandController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String url=null;
		if(action!=null&&action.equals("LIST")) {
			List<LandDTO> landDTOs=landService.findAll();
			request.setAttribute("lands", landDTOs);
			url="/views/admin/land/list.jsp";
		}
		if(action!=null&&action.equals("EDIT")) {
			url="/views/admin/land/edit.jsp";
			
		}
		if(action!=null&&action.equals("UPDATE")) {
			url="/views/admin/land/update.jsp";
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

		

	
