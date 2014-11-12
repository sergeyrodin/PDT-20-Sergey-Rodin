package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	
	public String firstName;
	public String lastName;
	private String address1;
	private String phoneHome;
	private String phoneMobile;
	private String phoneWork;
	private String email1;
	private String email2;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String group;
	private String address2;
	private String phone2;
	
	public ContactData() {
		
	}
	
	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName="+ lastName + ", address1=" + address1
				+ ", phoneHome=" + phoneHome+ ", phoneMobile=" + phoneMobile
				+ ", phoneWork=" + phoneWork + ", email1="+ email1 + ", email2=" + email2 + ", birthDay=" + birthDay
				+ ", birthMonth=" + birthMonth + ", birthYear=" + birthYear+ ", group=" + group + ", address2=" + address2 + ", phone2="
				+ phone2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	    //result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		int compareLastNames = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (compareLastNames != 0) {
			return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		}
		else {
			int compareFirstNames = this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
			if (compareFirstNames != 0) {
				return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
			} else{
			  return 0;
			  } 
		}
	}

	
	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	} 
	
	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public ContactData withAddress1(String address1) {
		this.address1 = address1;
		return this;
	}
	
	public ContactData withPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
		return this;
	}
	
	public ContactData withPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
		return this;
	}
	
	public ContactData withPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
		return this;
	}
	
	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	
	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}
	
	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}
	
	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}
	
	public ContactData withGroup(String group) {
		this.group = group;
		return this;
	}
	
	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	
	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getGroup() {
		return group;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}
		
}