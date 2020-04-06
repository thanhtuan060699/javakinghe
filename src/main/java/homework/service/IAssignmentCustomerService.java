package homework.service;

import java.util.List;

import homework.dto.UserDTO;

public interface IAssignmentCustomerService {
	public List<UserDTO> listUserManageCustomer(Long customerID);
	public void assignmentCustomer(Long userId,Long customerId);
}
