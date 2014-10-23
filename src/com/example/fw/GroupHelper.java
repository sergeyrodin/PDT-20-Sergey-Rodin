package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupCreationTests;
import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitGroupCreation() {
		
		manager.driver.findElement(By.name("submit")).click();
	}

	public void initGroupCreation() {
		
		manager.driver.findElement(By.name("new")).click();
	}

	public void fillGroupForm(ApplicationManager app, GroupCreationTests groupCreationTests, GroupData group) {
		
		manager.driver.findElement(By.name("group_name")).clear();
		manager.driver.findElement(By.name("group_name")).sendKeys(group.name);
		manager.driver.findElement(By.name("group_header")).clear();
		manager.driver.findElement(By.name("group_header")).sendKeys(group.header);
		manager.driver.findElement(By.name("group_footer")).clear();
		manager.driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

}
