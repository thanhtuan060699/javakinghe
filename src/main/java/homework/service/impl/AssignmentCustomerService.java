package homework.service.impl;

import java.util.ArrayList;
import java.util.List;

import homework.converter.UserConverter;
import homework.dto.UserDTO;
import homework.entity.UserEntity;
import homework.repository.ICustomerRepository;
import homework.repository.IUserRepository;
import homework.repository.impl.CustomerRepository;
import homework.repository.impl.UserRepository;
import homework.service.IAssignmentCustomerService;
import homework.service.ICustomerService;

public class AssignmentCustomerService implements IAssignmentCustomerService {
	
	private IUserRepository userRepository=new UserRepository();
	private ICustomerRepository customerRepository=new CustomerRepository();
	private UserConverter userConverter=new UserConverter();
	@Override
	public List<UserDTO> listUserManageCustomer(Long customerID) {
		List<UserEntity> listStaff=userRepository.findUserByRole("STAFF");
		List<UserDTO> userDTOs=new ArrayList<UserDTO>();
		for(int i=0;i<listStaff.size();i++) {
			UserDTO userDTO=userConverter.converToDTO(listStaff.get(i));
			boolean flag=userRepository.existUserIdInCustomer(customerID, userDTO.getId());
			if(flag==true) {
				userDTO.setChecked("check");
			}
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}
	@Override
	public void assignmentCustomer(Long userId, Long customerId) {
		customerRepository.assignmentCustomer(userId, customerId);
		
	}
	
}
