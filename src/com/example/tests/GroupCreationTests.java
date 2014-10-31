package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
@Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
	
	//save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
	
	//actions
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupsPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states
    System.out.println("Old List size = " + oldList.size());
    System.out.println("New List size = " + newList.size());
    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }

@Test
  public void testEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();

    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "";
    group.header = "";
    group.footer = "";
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupsPage();

    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states
    System.out.println("Old List size = " + oldList.size());
    System.out.println("New List size = " + newList.size());
    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
