package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

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
	    type(By.name("home"), contact.primary_phone_home);
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
		
	public void submitContactModification() {
		click(By.xpath("//input[@name='update'][@value='Update']"));
		}

	public void submitContactDeletion(int line, int column) {
		selectContactByIndex(line, column);
		click(By.xpath("//input[@name='update'][@value='Delete']"));
	}
	
	private void selectContactByIndex(int line, int column) {
		click(By.xpath("//table[@id='maintable']/tbody/tr[" + line + "]/td[" + column + "]/a/img[@alt='Edit']"));
	}
	
	public void initContactModification(int row, int column) {
		   selectContactByIndex(row, column);	
		}

	public List<ContactData> getContacts() {
    	List<ContactData> contacts = new ArrayList<ContactData>(); 
    	WebElement NumberOfResults = driver.findElement(By.xpath("//div[@id='content']/label/strong/span[@id='search_count']"));
    	String NumberOfRows = NumberOfResults.getText();
    	Integer Rows = Integer.valueOf(NumberOfRows);
    	for (int i = 2; i < Rows + 2; i++)
    	{
    		ContactData contact = new ContactData();
    		WebElement last_name = driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[2]"));
    		WebElement first_name = driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[3]"));
    		contact.first_name = first_name.getText();
    		contact.last_name = last_name.getText();
    		contacts.add(contact);
        }    		
    	return contacts;
   }
}
