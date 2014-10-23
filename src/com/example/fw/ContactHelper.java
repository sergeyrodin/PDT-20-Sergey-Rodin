package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactCreationTests;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}
	
	public void fillContactForm(ContactData contact){
		type(By.name("firstname"), contact.first_name);
	    type(By.name("lastname"), contact.last_name);
	    type(By.name("address"), contact.address1);
	    type(By.name("home"), contact.first_name);
	    type(By.name("mobile"), contact.primary_phone_mobile);
	    type(By.name("work"), contact.primary_phone_work);
	    type(By.name("email"), contact.email1);
	    type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.birthday);
	    selectByText(By.name("bmonth"), contact.birthmonth);
	    type(By.name("byear"), contact.birthyear);
	    //selectByText(By.name("new_group"), "group 1");
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phone2);
	    
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}
}
