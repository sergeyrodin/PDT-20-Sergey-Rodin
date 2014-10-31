package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

  @Test
  public void modifySomeGroup() {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().gotoGroupsPage();
	
	//save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
	
	//actions
	app.getGroupHelper().initGroupModification(0);
	GroupData group = new GroupData();
	group.name = "new name";
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().returnToGroupsPage();	
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states
    assertEquals(newList.size(), oldList.size());
    System.out.println("Old List size = " + oldList.size());
    System.out.println("New List size = " + newList.size());
    
    oldList.remove(group);
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
	}
}