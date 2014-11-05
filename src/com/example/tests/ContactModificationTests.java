package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class ContactModificationTests extends TestBase{
	
	@Test
	public void modifySomeContact() throws Exception {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		//actions
		app.getContactHelper().initContactModification(2, 7);
		ContactData contact = new ContactData();
		contact.first_name = "modified first name";
		contact.last_name = "modified last name";
		contact.address1 = "modified address";
		contact.primary_phone_mobile = "+79000000000";
		contact.birthday = "15";
		contact.birthmonth = "September";
		contact.birthyear = "1900";
		contact.email1 = "modified_email1111@mail.com";
		contact.email2 = "modified_email2222@mail.com";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getNavigationHelper().gotoHomePage();
	    
	    //save new state
	 	List<ContactData> newList = app.getContactHelper().getContacts();
	 	
	 	//compare states
	    assertEquals(newList.size(), oldList.size());
	    System.out.println("Old Contacts List size = " + oldList.size());
	    System.out.println("New Contacts List size = " + newList.size());
	    
	 	oldList.remove(0);
	 	oldList.add(contact);
	 	Collections.sort(oldList);
	 	assertEquals(newList, oldList);

	}
}
