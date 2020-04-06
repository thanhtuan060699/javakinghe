package homework.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework.dto.UserDTO;
import homework.service.IUserService;
import homework.service.impl.UserService;
import homework.util.FormUtil;
import homework.util.SessionUtil;


@WebServlet(urlPatterns = {"/admin-home","/login","/logout"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    IUserService userService=new UserService();
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if(action!=null&&action.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}else if(action!=null&&action.equals("logout")){
			response.sendRedirect(request.getContextPath()+"/web-home");
		}else {
			RequestDispatcher rd  =request.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(request, response);
		}
			
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null&&action.equals("login")) {
			UserDTO userDTO =FormUtil.toModel(UserDTO.class, request);
			userDTO=userService.findByUserPassword(userDTO);
			if(userDTO!=null) {
				SessionUtil.getInstance().putValue(request,"user",userDTO);
				response.sendRedirect(request.getContextPath()+"/admin-home");
			}
		}
	}

}
