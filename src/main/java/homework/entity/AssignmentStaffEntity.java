package homework.entity;

import homework.annotation.Column;
import homework.annotation.Entity;
import homework.annotation.Table;

@Entity
@Table(name="assignmentstaff")
public class AssignmentStaffEntity {
	@Column(name = "id")
	private Long id;
	
	@Column(name = "landid")
	private Long landId;
	
	@Column(name = "staffid")
	private Long staffId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLandId() {
		return landId;
	}

	public void setLandId(Long landId) {
		this.landId = landId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	
	
}
