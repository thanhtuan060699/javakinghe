package homework.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import homework.converter.CustomerConverter;
import homework.dto.CustomerDTO;
import homework.entity.CustomerEntity;
import homework.repository.ICustomerRepository;
import homework.repository.impl.CustomerRepository;
import homework.service.ICustomerService;

public class CustomerService implements ICustomerService {
	
	CustomerConverter converter=new CustomerConverter();
	ICustomerRepository customerRepository=new CustomerRepository();
	@Override
	public void save(CustomerDTO customerDTO) {
		CustomerEntity customerEntity=converter.convertToEntity(customerDTO);
		customerRepository.save(customerEntity);
		
	}
	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerEntity> customerEntities=customerRepository.findAll();
		return  customerEntities.stream().map(item->converter.convertToDTO(item)).collect(Collectors.toList());
	}
	@Override
	public void delete(Long[] customerIds) {
		for(int i=0;i<customerIds.length;i++) {
			customerRepository.deleteCustomer(customerIds[i]);
		}
		
	}

}
