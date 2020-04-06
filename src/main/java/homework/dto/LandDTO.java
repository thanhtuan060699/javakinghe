package homework.dto;

public class LandDTO extends AbstractDTO {
	private int length;
	private String image;
	private int width;
	private String address;
	private String direction;
	private String cost;
	private Long staffs[];
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public Long[] getStaffs() {
		return staffs;
	}
	public void setStaffs(Long staffs[]) {
		this.staffs = staffs;
	}
	
}
