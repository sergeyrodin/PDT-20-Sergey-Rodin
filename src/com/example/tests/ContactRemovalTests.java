package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator", priority = 4)
	public void deleteSomeContact(ContactData contact) throws Exception {
		
		//save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();	
		
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
		//actions
		app.getContactHelper().deleteContact(index+2, 7);

	    //save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();	

	    //compare states
	    assertThat(newList, equalTo(oldList.without(index)));
	}
	
}
