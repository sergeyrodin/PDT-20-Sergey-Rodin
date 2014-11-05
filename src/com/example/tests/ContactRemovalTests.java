package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() throws Exception {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();	
		
		//actions
		app.getContactHelper().submitContactDeletion(2, 7);
		app.getNavigationHelper().gotoHomePage();
		
	    //save new state
		List<ContactData> newList = app.getContactHelper().getContacts();	

	    //compare states
	    assertEquals(newList.size(), oldList.size() - 1);
	    System.out.println("Old Contacts List size = " + oldList.size());
	    System.out.println("New Contacts List size = " + newList.size());
		
		oldList.remove(0);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
	
}
