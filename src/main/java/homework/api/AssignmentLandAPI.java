package homework.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import homework.dto.LandDTO;
import homework.dto.UserDTO;
import homework.service.IAssignmentLandService;
import homework.service.impl.AssignmentLandService;
import homework.util.HttpUtil;

/**
 * Servlet implementation class AssignmentLandAPI
 */
@WebServlet(urlPatterns = {"/api-assignment-land"})
public class AssignmentLandAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignmentLandAPI() {
        super();
        // TODO Auto-generated constructor stub
    }
    private IAssignmentLandService assignmentLandService=new AssignmentLandService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String landId=request.getParameter("landId");
		List<UserDTO> userDTOs=assignmentLandService.listStaffManageLand(Long.parseLong(landId));
		objectMapper.writeValue(response.getOutputStream(), userDTOs);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		LandDTO landDTO=HttpUtil.of(request.getReader()).toModel(LandDTO.class);
		assignmentLandService.assignmentLand(landDTO);
	}

}
