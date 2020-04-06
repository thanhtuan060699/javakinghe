package homework.dto;

public class CustomerDTO  extends AbstractDTO{
	private String name;
	private String phoneNumber;
	private String address;
	private int status;
	private long staffId[];
	private Long customerIds[];
	
	
	public Long[] getCustomerIds() {
		return customerIds;
	}
	public void setCustomerIds(Long[] customerIds) {
		this.customerIds = customerIds;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long[] getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId[]) {
		this.staffId = staffId;
	}
	
	
}
