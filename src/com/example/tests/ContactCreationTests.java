package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	
@Test
public void testNonEmptyContactCreation() throws Exception {
	  
	app.getNavigationHelper().openMainPage();

    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
	app.getContactHelper().initContactCreation();
	ContactData contact = new ContactData();
    contact.first_name = "Test";
    contact.last_name = "User";
    contact.address1 = "Test Address 123";
    contact.primary_phone_home = "89011111111";
    contact.primary_phone_mobile = "89011111112";
    contact.primary_phone_work = "89011111113";
    contact.email1 = "testuser@gmail.com";
    contact.email2 = "testuser1@gmail.com";
    contact.address2 = "Test Address 456";
    contact.birthday = "14";
    contact.birthmonth = "February";
    contact.birthyear = "2000";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().submitContactCreation();
	app.getNavigationHelper().gotoHomePage();
	
    //save new state
    List<ContactData> newList  = app.getContactHelper().getContacts();
    
    //compare states
    assertEquals(newList.size(), oldList.size() + 1);
    System.out.println("Old Contacts List size = " + oldList.size());
    System.out.println("New Contacts List size = " + newList.size());
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
@Test
  public void testEmptyContactCreation() throws Exception {
	  
	app.getNavigationHelper().openMainPage();

    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
  
    //actions
	app.getContactHelper().initContactCreation();
	ContactData contact = new ContactData();
    contact.first_name = "";
    contact.last_name = "";
    contact.address1 = "";
    contact.primary_phone_home = "";
    contact.primary_phone_mobile = "";
    contact.primary_phone_work = "";
    contact.email1 = "";
    contact.email2 = "";
    contact.address2 = "";
    contact.birthday = "-";
    contact.birthmonth = "-";
    contact.birthyear = "";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().submitContactCreation();
	app.getNavigationHelper().gotoHomePage();
	
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
  
    //compare states
    assertEquals(newList.size(), oldList.size() + 1);
    System.out.println("Old Contacts List size = " + oldList.size());
    System.out.println("New Contacts List size = " + newList.size());
  
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);

  }

}
