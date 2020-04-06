package homework.repository;

import java.util.List;

import homework.entity.CustomerAppointmentEntity;

public interface ICustomerAppointmentRepository {
	void save(CustomerAppointmentEntity customerAppointmentEntity);
	List<CustomerAppointmentEntity> findAll(long customerId);
}
