package homework.converter;

import org.modelmapper.ModelMapper;

import homework.dto.CustomerDTO;
import homework.entity.CustomerEntity;

public class CustomerConverter {
	
	public CustomerDTO convertToDTO(CustomerEntity customerEntity) {
		ModelMapper mapper=new ModelMapper();
		CustomerDTO customerDTO=mapper.map(customerEntity,CustomerDTO.class);
		return customerDTO;
	}
	public CustomerEntity convertToEntity(CustomerDTO customerDTO) {
		ModelMapper mapper=new ModelMapper();
		CustomerEntity customerEntity=mapper.map(customerDTO, CustomerEntity.class);
		return customerEntity;
	}
}
