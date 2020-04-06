package homework.repository;

import java.util.List;

import homework.entity.UserEntity;

public interface IUserRepository {
	public UserEntity findByUserPassword(UserEntity userEntity);
	public List<UserEntity> findUserByRole(String Role);
	boolean existUserIdInCustomer(long customerId,long userId);
	
}
