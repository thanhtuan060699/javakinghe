package homework.dto;

public class CustomerAppointmentDTO {
	private long id;
	private String dateAppointment;
	private String note;
	private long idCustomer;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getDateAppointment() {
		return dateAppointment;
	}
	public void setDateAppointment(String dateAppointment) {
		this.dateAppointment = dateAppointment;
	}
	public long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	
}
