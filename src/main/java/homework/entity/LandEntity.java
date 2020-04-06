package homework.entity;

import homework.annotation.Column;
import homework.annotation.Entity;
import homework.annotation.Table;
@Entity
@Table(name = "land")
public class LandEntity extends BaseEntity {
	
	@Column(name = "length")
	private Integer length;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "width")
	private Integer width;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "direction")
	private String direction;
	
	@Column(name = "cost")
	private String cost;

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
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
	
	
}
