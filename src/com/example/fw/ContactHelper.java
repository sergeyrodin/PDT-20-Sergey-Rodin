package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactCreationTests;
import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactCreation() {
		
	    manager.driver.findElement(By.name("submit")).click();
	}

	public void initContactCreation() {
		
	    manager.driver.findElement(By.linkText("add new")).click();
	}

	public void fillContactForm(ApplicationManager app, ContactCreationTests contactCreationTests, ContactData contact){
	
	    manager.driver.findElement(By.name("firstname")).clear();
	    manager.driver.findElement(By.name("firstname")).sendKeys(contact.first_name);
	    manager.driver.findElement(By.name("lastname")).clear();
	    manager.driver.findElement(By.name("lastname")).sendKeys(contact.last_name);
	    manager.driver.findElement(By.name("address")).clear();
	    manager.driver.findElement(By.name("address")).sendKeys(contact.address1);
	    manager.driver.findElement(By.name("home")).clear();
	    manager.driver.findElement(By.name("home")).sendKeys(contact.primary_phone_home);
	    manager.driver.findElement(By.name("mobile")).clear();
	    manager.driver.findElement(By.name("mobile")).sendKeys(contact.primary_phone_mobile);
	    manager.driver.findElement(By.name("work")).clear();
	    manager.driver.findElement(By.name("work")).sendKeys(contact.primary_phone_work);
	    manager.driver.findElement(By.name("email")).clear();
	    manager.driver.findElement(By.name("email")).sendKeys(contact.email1);
	    manager.driver.findElement(By.name("email2")).clear();
	    manager.driver.findElement(By.name("email2")).sendKeys(contact.email2);
	    new Select(manager.driver.findElement(By.name("bday"))).selectByVisibleText(contact.birthday_day);
	    new Select(manager.driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.birthday_month);
	    manager.driver.findElement(By.name("byear")).clear();
	    manager.driver.findElement(By.name("byear")).sendKeys(contact.birthday_year);
	    //driver.findElement(By.name("new_group")).sendKeys("Rob");
	    manager.driver.findElement(By.name("address2")).clear();
	    manager.driver.findElement(By.name("address2")).sendKeys(contact.address2);
	    manager.driver.findElement(By.name("phone2")).clear();
	    manager.driver.findElement(By.name("phone2")).sendKeys(contact.phone2);
	
	}

}
