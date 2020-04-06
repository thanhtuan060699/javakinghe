package homework.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework.dto.CustomerAppointmentDTO;
import homework.dto.CustomerDTO;
import homework.repository.ICustomerAppointmentRepository;
import homework.service.ICustomerAppointmentService;
import homework.service.ICustomerService;
import homework.service.impl.CustomerAppointmentService;
import homework.service.impl.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet(urlPatterns = {"/admin-customer"})
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICustomerService customerService=new CustomerService();
	ICustomerAppointmentService customerAppointmentService=new CustomerAppointmentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String action=request.getParameter("action");
		String signal=request.getParameter("signal");
		String url=null;
		if(action!=null&&action.equals("LIST")) {
			url="views/admin/customer/clist.jsp";
			List<CustomerDTO> customerDTOs=customerService.findAll();
			request.setAttribute("customers", customerDTOs);
		}
		if(signal!=null&&signal.equals("EDIT"))
		{
			url="views/admin/customer/insert.jsp";
		}
		if(signal!=null&&signal.equals("APPOINTMENT"))
		{	
			Long customerId=Long.parseLong(request.getParameter("id"));
			List<CustomerAppointmentDTO> customerAppointmentDTOs=customerAppointmentService.findAll(customerId);
			request.setAttribute("appointments", customerAppointmentDTOs);
			url="views/admin/customer/appointment.jsp";
		}
		if(signal!=null&&signal.equals("UPDATE"))
		{
			url="views/admin/customer/cupdate.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
