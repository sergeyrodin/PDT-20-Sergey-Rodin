package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	
	public String first_name;
	public String last_name;
	public String address1;
	public String primary_phone_home;
	public String primary_phone_mobile;
	public String primary_phone_work;
	public String email1;
	public String email2;
	public String birthday;
	public String birthmonth;
	public String birthyear;
	public String group;
	public String address2;
	public String phone2;
	
	public ContactData() {}
	
	@Override
	public String toString() {
		return "ContactData [first_name=" + first_name + ", last_name="
				+ last_name + ", address1=" + address1
				+ ", primary_phone_home=" + primary_phone_home
				+ ", primary_phone_mobile=" + primary_phone_mobile
				+ ", primary_phone_work=" + primary_phone_work + ", email1="
				+ email1 + ", email2=" + email2 + ", birthday=" + birthday
				+ ", birthmonth=" + birthmonth + ", birthyear=" + birthyear
				+ ", group=" + group + ", address2=" + address2 + ", phone2="
				+ phone2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		if (!this.last_name.toLowerCase().equals(other.last_name.toLowerCase())) {
			return this.last_name.toLowerCase().compareTo(other.last_name.toLowerCase());
		}
		else {
			return this.first_name.toLowerCase().compareTo(other.first_name.toLowerCase());
		}
	}
}