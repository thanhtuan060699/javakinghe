package homework.builder;

public class LandSearchBuilder {
	private int length;
	private int width;
	private String image;
	private String address;
	private String direction;
	private String cost;
	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}
	public String getImage() {
		return image;
	}
	public String getAddress() {
		return address;
	}
	public String getDirection() {
		return direction;
	}
	public String getCost() {
		return cost;
	}
	private LandSearchBuilder(Builder builder) {
		this.length=builder.length;
		this.width=builder.width;
		this.image=builder.image;
		this.address=builder.address;
		this.direction=builder.direction;
		this.cost=builder.cost;
	}
	public static class Builder{
		private int length;
		private int width;
		private String image;
		private String address;
		private String direction;
		private String cost;
		public Builder setLength(int length) {
			this.length = length;
			return this;
		}
		public Builder setWidth(int width) {
			this.width = width;
			return this;
		}
		public Builder setImage(String image) {
			this.image = image;
			return this;
		}
		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}
		public Builder setDirection(String direction) {
			this.direction = direction;
			return this;
		}
		public Builder setCost(String cost) {
			this.cost = cost;
			return this;
		}
		
	}
}
