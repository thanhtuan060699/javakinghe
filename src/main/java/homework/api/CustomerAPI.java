package homework.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework.dto.CustomerDTO;
import homework.service.ICustomerService;
import homework.service.impl.CustomerService;
import homework.util.HttpUtil;

/**
 * Servlet implementation class CustomerAPI
 */
@WebServlet(urlPatterns = {"/api-customer"})
public class CustomerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ICustomerService customerService=new CustomerService();
    public CustomerAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CustomerDTO customerDTO=HttpUtil.of(request.getReader()).toModel(CustomerDTO.class);
		customerService.save(customerDTO);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CustomerDTO customerDTO=HttpUtil.of(request.getReader()).toModel(CustomerDTO.class);
		customerService.delete(customerDTO.getCustomerIds());
		
	}

}
