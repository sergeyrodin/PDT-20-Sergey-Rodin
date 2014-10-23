package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupCreationTests;
import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initGroupCreation() {
		
		click(By.name("new"));
	}
	
	public void submitGroupCreation() {
		
		click(By.name("submit"));
	}

	public void fillGroupForm(GroupData group) {
		
		type(By.name("group_name"), group.name);
		type(By.name("group.headere"), group.header);
		type(By.name("group.footer"), group.footer);
	}

}
