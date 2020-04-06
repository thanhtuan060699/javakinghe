package homework.service;

import java.util.List;

import homework.dto.LandDTO;
import homework.dto.UserDTO;

public interface IAssignmentLandService {
	public List<UserDTO> listStaffManageLand(Long landId);
	public void assignmentLand(LandDTO landDTO);
}
