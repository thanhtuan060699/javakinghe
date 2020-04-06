package homework.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.dto.CustomerAppointmentDTO;
import homework.service.impl.CustomerAppointmentService;
import homework.util.HttpUtil;


@WebServlet(urlPatterns = {"/api-appointment"})
public class CustomerAppointmentAPI extends HttpServlet {

	/**
	 * 
	 */
	CustomerAppointmentService customerAppointmentService=new CustomerAppointmentService();
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CustomerAppointmentDTO appointmentDTO=HttpUtil.of(request.getReader()).toModel(CustomerAppointmentDTO.class);
		customerAppointmentService.save(appointmentDTO);
		
	}
}
