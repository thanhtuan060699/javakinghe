package homework.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homework.entity.CustomerEntity;
import homework.repository.ICustomerRepository;

public class CustomerRepository extends SimpleJpaRepository<CustomerEntity> implements ICustomerRepository {

	@Override
	public void save(CustomerEntity customerEntity) {
		this.insert(customerEntity);
		
	}

	@Override
	public List<CustomerEntity> findAll() {
		String sql="select * from customer";
		return this.findAll(sql);
	}

	@Override
	public void assignmentCustomer(Long userId, Long customerId) {
		String sql="update customer set iduser="+userId+" where id="+customerId;
		Connection connection = null;
		//PreparedStatement statement = null;
		Statement statement=null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			//statement = connection.prepareStatement(sql.toString());
			statement=connection.createStatement();
			int kq = statement.executeUpdate(sql);
		} catch (SQLException e) {
			
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
	}

	@Override
	public void deleteCustomer(Long id) {
		this.delete(id);
		
	}

}
