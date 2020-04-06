package homework.entity;

import java.sql.Date;

import homework.annotation.Column;
import homework.annotation.Entity;
import homework.annotation.Table;

@Entity
@Table(name = "customerappointment")
public class CustomerAppointmentEntity {
	@Column(name = "id")
	private long id;
	
	@Column(name = "dateappointment")
	private Date dateAppointmentE;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "customerid")
	private long idCustomer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public Date getDateAppointmentE() {
		return dateAppointmentE;
	}

	public void setDateAppointmentE(Date dateAppointmentE) {
		this.dateAppointmentE = dateAppointmentE;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	
}
