package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	@Test
	public void modifySomeContact() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(0);
		ContactData contact = new ContactData();
		contact.first_name = "new first name";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
	    app.getNavigationHelper().openMainPage();	

	}
}
