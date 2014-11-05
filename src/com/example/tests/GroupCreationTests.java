package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
@Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
	
	//save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
	
	//actions
    app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupsPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states
    System.out.println("Old Groups List size = " + oldList.size());
    System.out.println("New Groups List size = " + newList.size());
    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	}
}

