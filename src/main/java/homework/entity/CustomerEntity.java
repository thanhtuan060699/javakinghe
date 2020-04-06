package homework.entity;

import homework.annotation.Column;
import homework.annotation.Entity;
import homework.annotation.Table;
@Entity
@Table(name="customer")
public class CustomerEntity extends BaseEntity{
		@Column(name = "name")
		private String name;
		
		@Column(name = "phonenumber")
		private String phoneNumber;
		
		@Column(name = "address")
		private String address;

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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		

}
