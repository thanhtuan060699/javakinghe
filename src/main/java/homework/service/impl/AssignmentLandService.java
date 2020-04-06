package homework.service.impl;

import java.util.ArrayList;
import java.util.List;

import homework.converter.UserConverter;
import homework.dto.LandDTO;
import homework.dto.UserDTO;
import homework.entity.AssignmentStaffEntity;
import homework.entity.UserEntity;
import homework.repository.IAssignmentStaffRepository;
import homework.repository.IUserRepository;
import homework.repository.impl.AssignmentStaffRepository;
import homework.repository.impl.UserRepository;
import homework.service.IAssignmentLandService;

public class AssignmentLandService implements IAssignmentLandService {
	private IUserRepository userRepository=new UserRepository();
	private IAssignmentStaffRepository assignmentStaffRepository=new AssignmentStaffRepository();
	private UserConverter userConverter=new UserConverter();
	
	@Override
	public List<UserDTO> listStaffManageLand(Long landId) {
		List<UserEntity> listStaff=userRepository.findUserByRole("STAFF");
		List<UserDTO> userDTOs=new ArrayList<UserDTO>();
		for(int i=0;i<listStaff.size();i++) {
			UserDTO userDTO=userConverter.converToDTO(listStaff.get(i));
			if(assignmentStaffRepository.existUserAssignmentLand(landId,listStaff.get(i).getId())) {
				userDTO.setChecked("check");
				userDTOs.add(userDTO);
			}
			else
				userDTOs.add(userDTO);
				
		}
		return userDTOs;
	}

	@Override
	public void assignmentLand(LandDTO landDTO) {
		assignmentStaffRepository.delete(landDTO.getId());
		for(int i=0;i<landDTO.getStaffs().length;i++) {
			AssignmentStaffEntity assignmentStaffEntity=new AssignmentStaffEntity();
			assignmentStaffEntity.setLandId(landDTO.getId());
			assignmentStaffEntity.setStaffId(landDTO.getStaffs()[i]);
			assignmentStaffRepository.save(assignmentStaffEntity);
		}
		
	}
	
}
