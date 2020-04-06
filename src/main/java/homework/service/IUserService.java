package homework.service;

import homework.dto.UserDTO;

public interface IUserService {
	public UserDTO findByUserPassword(UserDTO userDTO);
}
