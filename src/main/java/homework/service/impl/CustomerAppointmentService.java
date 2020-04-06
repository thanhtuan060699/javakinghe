package homework.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import homework.converter.CustomerAppointmentConverter;
import homework.dto.CustomerAppointmentDTO;
import homework.entity.CustomerAppointmentEntity;
import homework.repository.impl.CustomerAppointmentRepository;
import homework.service.ICustomerAppointmentService;

public class CustomerAppointmentService implements ICustomerAppointmentService {
	
	CustomerAppointmentRepository customerAppointmentRepository=new CustomerAppointmentRepository();
	CustomerAppointmentConverter convert=new CustomerAppointmentConverter();
	
	@Override
	public void save(CustomerAppointmentDTO customerAppointmentDTO) {
		CustomerAppointmentEntity customerAppointmentEntity=convert.convertToEntity(customerAppointmentDTO);
		customerAppointmentRepository.save(customerAppointmentEntity);
		
	}

	@Override
	public List<CustomerAppointmentDTO> findAll(long customerId) {
		List<CustomerAppointmentEntity> customerAppointmentEntities=customerAppointmentRepository.findAll(customerId);
	    return customerAppointmentEntities.stream().map(item->convert.convertToDTO(item)).collect(Collectors.toList());	
	}

}
