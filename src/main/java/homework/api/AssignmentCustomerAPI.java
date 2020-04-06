package homework.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import homework.dto.CustomerDTO;
import homework.dto.UserDTO;
import homework.service.IAssignmentCustomerService;
import homework.service.impl.AssignmentCustomerService;
import homework.util.HttpUtil;

/**
 * Servlet implementation class AssignmentCustomerAPI
 */
@WebServlet(urlPatterns = {"/api-assignment-customer"})
public class AssignmentCustomerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignmentCustomerAPI() {
        super();
        // TODO Auto-generated constructor stub
    }
    private IAssignmentCustomerService assignmentCustomerService=new AssignmentCustomerService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String type=request.getParameter("type");
		String customerId=request.getParameter("customerId");
		if(type.equals("SHOW_STAFF_USER")) {
			List<UserDTO> userDTOs=assignmentCustomerService.listUserManageCustomer(Long.parseLong(customerId));
			mapper.writeValue(response.getOutputStream(), userDTOs);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CustomerDTO customerDTO=HttpUtil.of(request.getReader()).toModel(CustomerDTO.class);
		assignmentCustomerService.assignmentCustomer(customerDTO.getStaffId()[0], customerDTO.getId());
	}

}
