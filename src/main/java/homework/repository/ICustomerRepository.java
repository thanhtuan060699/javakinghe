package homework.repository;

import java.util.List;

import homework.entity.CustomerEntity;

public interface ICustomerRepository {
	public void save(CustomerEntity customerEntity);
	public List<CustomerEntity> findAll();
	public void assignmentCustomer(Long userId,Long customerId);
	public void deleteCustomer(Long id);
}
