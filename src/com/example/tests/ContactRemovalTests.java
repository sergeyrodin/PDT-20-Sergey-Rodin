package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void deleteSomeContact(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();	
		
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
		//actions
		app.getContactHelper().submitContactDeletion(index+2, 7);
		app.getNavigationHelper().gotoHomePage();
		
	    //save new state
		List<ContactData> newList = app.getContactHelper().getContacts();	

	    //compare states
	    System.out.println("Old Contacts List size = " + oldList.size());
	    System.out.println("New Contacts List size = " + newList.size());
		
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
	
}
