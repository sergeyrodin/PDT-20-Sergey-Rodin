package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase{
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}
	
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>(); 
		manager.navigateTo().mainPage();
		List<WebElement> lines = driver.findElements(By.name("entry"));
		for (WebElement line : lines) {
			String lastName = line.findElement(By.xpath(".//td[2]")).getText();
			String firstName = line.findElement(By.xpath(".//td[3]")).getText();
			cachedContacts.add(new ContactData().withLastName(lastName).withFirstName(firstName));
		}
	}
		
	public ContactHelper createContact(ContactData contact, boolean formType) {
		manager.navigateTo().mainPage();
	    initContactCreation();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		goToHomePage();
		return this;
	}
	
	public ContactHelper modifyContact(int line, int column, ContactData contact, boolean formType) {
		manager.navigateTo().mainPage();
		initContactModification(line, column);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		goToHomePage();
		return this;
	}
	
	public ContactHelper deleteContact(int line, int column) {
		manager.navigateTo().mainPage();
		initContactModification(line, column);
		submitContactDeletion();
		goToHomePage();
		return this;
	}
	
// -----------------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}
	
	public ContactHelper fillContactForm(ContactData contact, boolean formType){
		type(By.name("firstname"), contact.getFirstName());
	    type(By.name("lastname"), contact.getLastName());
	    type(By.name("address"), contact.getAddress1());
	    type(By.name("home"), contact.getPhoneHome());
	    type(By.name("mobile"), contact.getPhoneMobile());
	    type(By.name("work"), contact.getPhoneWork());
	    type(By.name("email"), contact.getEmail1());
	    type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBirthDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
	    if (formType == CREATION) {
	    	// selectByText(By.name("new_group"), "group 1");
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() != 0) {
	    		throw new Error("Group selector exists in contact modification form");
	    	}
	    }
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getPhone2());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}
		
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@name='update'][@value='Update']"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper submitContactDeletion() {
		click(By.xpath("//input[@name='update'][@value='Delete']"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper initContactModification(int line, int column) {
		click(By.xpath("//table[@id='maintable']/tbody/tr[" + line + "]/td[" + column + "]/a/img[@alt='Edit']"));
		return this;
	}

	public ContactHelper goToHomePage() {
		click(By.linkText("home"));
		return this;
	}
}
