package homework.service;

import java.util.List;

import homework.dto.CustomerDTO;

public interface ICustomerService {
	public void save(CustomerDTO customerDTO);
	public List<CustomerDTO> findAll();
	public void delete(Long customerIds[]);
}
