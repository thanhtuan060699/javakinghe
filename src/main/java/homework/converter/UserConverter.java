package homework.converter;

import org.modelmapper.ModelMapper;

import homework.dto.UserDTO;
import homework.entity.UserEntity;

public class UserConverter {
	public UserEntity convertToEntity(UserDTO userDTO) {
		ModelMapper mapper=new ModelMapper();
		UserEntity userEntity=mapper.map(userDTO,UserEntity.class);
		return userEntity;
	}
	public UserDTO converToDTO(UserEntity userEntity) {
		ModelMapper mapper=new ModelMapper();
		UserDTO userDTO=mapper.map(userEntity, UserDTO.class);
		return userDTO;
	}
}
