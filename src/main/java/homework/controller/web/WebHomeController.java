package homework.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework.service.impl.LandService;


@WebServlet(urlPatterns = {"/web-home"})
public class WebHomeController extends HttpServlet {
	LandService landService=new LandService();
	private static final long serialVersionUID = 1L;
       
    public WebHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lands",landService.findAll());
		RequestDispatcher rd=request.getRequestDispatcher("views/web/webhome.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
