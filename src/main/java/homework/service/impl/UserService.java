package homework.service.impl;

import homework.converter.UserConverter;
import homework.dto.UserDTO;
import homework.entity.UserEntity;
import homework.repository.IUserRepository;
import homework.repository.impl.UserRepository;
import homework.service.IUserService;

public class UserService implements IUserService{

	IUserRepository userRepository=new UserRepository();
	UserConverter userCoverter=new UserConverter();
	@Override
	public UserDTO findByUserPassword(UserDTO userDTO) {
		UserEntity userEntity=userCoverter.convertToEntity(userDTO);
		userDTO=userCoverter.converToDTO(userRepository.findByUserPassword(userEntity));
		return userDTO;
	}

}
