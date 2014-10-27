package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;;

public class GroupCreationTests extends TestBase {
	
@Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    // save old state
//    List<GroupData> oldList = app.getGroupHelper().getGroups();
    // actions
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "123123 name 1";
    group.header = "123123header 1";
    group.footer = "123123footer 1";
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupsPage();
//    // save new state
//    List<GroupData> newList = app. getGroupHelper().getGroups();
//    //compare stated
//    assertEquals(newList.size(), oldList.size() + 1);
//    
//    oldList.add(group);
//    Collections.sort(oldList);
//    assertEquals(newList, oldList);
  }

@Test
  public void testEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "gdf";
    group.header = "sdf";
    group.footer = "sdf";
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupsPage();
  }
}
