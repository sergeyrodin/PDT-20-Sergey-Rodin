package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

  @Test
  public void deleteSomeGroup() {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().gotoGroupsPage();
	
	//save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size() - 1);
	
	//actions
	app.getGroupHelper().deleteGroup(index);
    app.getNavigationHelper().returnToGroupsPage();	
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states
    //assertEquals(newList.size(), oldList.size() - 1);
    System.out.println("Old Groups List size = " + oldList.size());
    System.out.println("New Groups List size = " + newList.size());
    
    oldList.remove(index);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
    
	}
}
