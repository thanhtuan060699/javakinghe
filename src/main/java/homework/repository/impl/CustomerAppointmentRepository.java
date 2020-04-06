package homework.repository.impl;

import java.util.List;

import homework.entity.CustomerAppointmentEntity;
import homework.repository.ICustomerAppointmentRepository;

public class CustomerAppointmentRepository extends SimpleJpaRepository<CustomerAppointmentEntity> implements ICustomerAppointmentRepository {

	@Override
	public void save(CustomerAppointmentEntity customerAppointmentEntity) {
		this.insert(customerAppointmentEntity);
	}

	@Override
	public List<CustomerAppointmentEntity> findAll(long customerId) {
		String sql="select * from customerappointment where customerid="+customerId;
		List<CustomerAppointmentEntity> customerAppointmentEntities=this.findAll(sql);
		return customerAppointmentEntities;
	}
	
}
