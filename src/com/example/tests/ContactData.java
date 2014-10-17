package com.example.tests;

public class ContactData {
	public String first_name;
	public String last_name;
	public String address1;
	public String primary_phone_home;
	public String primary_phone_mobile;
	public String primary_phone_work;
	public String email1;
	public String email2;
	public String birthday_day;
	public String birthday_month;
	public String birthday_year;
	public String group;
	public String address2;
	public String phone2;
	
	public ContactData() {}
	
	public ContactData(
			String first_name, 
			String last_name, 
			String address1, 
			String primary_phone_home,
			String primary_phone_mobile, 
			String primary_phone_work, 
			String email,
			String email2, 
			String birthday_day, 
			String birthday_month, 
			String birthday_year, 
			String group) 
	{
		this.first_name = first_name;
		this.last_name = last_name;
		this.address1 = address1;
		this.primary_phone_home = primary_phone_home;
		this.primary_phone_mobile = primary_phone_mobile;
		this.primary_phone_work =primary_phone_work;
		this.email1 = email;
		this.email2 = email2;
		this.address1 = address1;
		this.birthday_day = birthday_day;
		this.birthday_month = birthday_month;
		this.birthday_year = birthday_year;
		this.group = group;
	}
}