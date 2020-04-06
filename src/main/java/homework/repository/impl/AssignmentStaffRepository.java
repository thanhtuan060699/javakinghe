package homework.repository.impl;

import homework.entity.AssignmentStaffEntity;
import homework.repository.IAssignmentStaffRepository;

public class AssignmentStaffRepository extends SimpleJpaRepository<AssignmentStaffEntity> implements IAssignmentStaffRepository {
	@Override
	public boolean existUserAssignmentLand(Long landId,Long userId) {
		String sql="select * from assignmentstaff where landid="+landId+" and staffid="+userId;
		if(this.findAll(sql).size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public void save(AssignmentStaffEntity assignmentStaffEntity) {
		this.insert(assignmentStaffEntity);
		
	}

	@Override
	public void delete(Long landId) {
		String sql="delete from assignmentstaff where landid="+landId;
		this.delete(sql);
		
	}
}
