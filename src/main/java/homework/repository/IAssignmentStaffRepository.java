package homework.repository;

import homework.entity.AssignmentStaffEntity;

public interface IAssignmentStaffRepository {
	public boolean existUserAssignmentLand(Long landId,Long userId);
	public void save(AssignmentStaffEntity assignmentStaffEntity);
	public void delete(Long landId);
}
