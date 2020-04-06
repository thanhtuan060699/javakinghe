package homework.service;

import java.util.List;

import homework.dto.CustomerAppointmentDTO;
import homework.entity.CustomerAppointmentEntity;

public interface ICustomerAppointmentService {
	void save(CustomerAppointmentDTO customerAppointmentDTO);
	List<CustomerAppointmentDTO> findAll(long customerId);
}
