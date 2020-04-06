package homework.entity;

import java.util.Date;

import homework.annotation.Column;

public class BaseEntity {
	@Column(name = "id")
	private Long id;
	@Column(name = "createdate")
	private Date createdDate;
	
	@Column(name = "modifieddate")
	private Date modifiedDate;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@Column(name = "modifiedby")
	private String modifiedBy;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String cre) {
		this.createdBy = cre;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
