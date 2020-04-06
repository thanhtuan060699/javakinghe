package homework.repository.impl;

import java.util.List;

import homework.entity.UserEntity;
import homework.repository.IUserRepository;

public class UserRepository extends SimpleJpaRepository<UserEntity> implements IUserRepository{

	@Override
	public UserEntity findByUserPassword(UserEntity userEntity) {
		String sql="select * from user where username='"+userEntity.getUsername()+
				"' and password='"+userEntity.getPassword()+"' and status=1";
		List<UserEntity> userEntities=this.findAll(sql);
		if(userEntities==null)
			return null;
		else
			return userEntities.get(0);
	}

	@Override
	public List<UserEntity> findUserByRole(String Role) {
		String sql="";
		sql=createSqlFindByRole(Role);
		return this.findAll(sql);

	}
	private String createSqlFindByRole(String roleCode) {
		String sql="select us.* "
				+ "from user as us "
				+ "join user_role as ur on us.id=ur.userid "
				+ "join role as r on ur.roleid=r.id "
				+ "where r.code='"+roleCode+"'";
		return sql;
	}
	
	@Override
	public boolean existUserIdInCustomer(long customerId,long userId) {
		String sql=sqlExistUserIdInCustomer(customerId,userId);
		if(this.findAll(sql).size()>0) {
			return true;
		}
		return false;
	}

	private String sqlExistUserIdInCustomer(long customerId,long userId) {
		String sql="select u.* "
				+" from customer c join user u on c.iduser=u.id "
				+" where c.id= "+customerId
				+" and u.id= "+userId;
		return sql;
	}

}
