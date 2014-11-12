package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;
	
	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
		    GroupData group = new GroupData()
		    	.withName(generateRandomString())
		    	.withHeader(generateRandomString())
		    	.withFooter(generateRandomString());
		    list.add(new Object[]{group});
		}
		 return list.iterator();
	} 	

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			Random rndDay = new Random(), rndMonth = new Random();
			String[] days = {"-","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
			String[] months = {"-","January","February","March","April","May","June","July","August","September","October","November","December" };
		    ContactData contact = new ContactData()
			    .withFirstName(generateRandomString())
			    .withLastName(generateRandomString())
			    .withAddress1(generateRandomString())
			    .withPhoneHome(generateRandomString())
			    .withPhoneMobile(generateRandomString())
			    .withPhoneWork(generateRandomString())
			    .withBirthDay(days[rndDay.nextInt(31)])
			    .withBirthMonth(months[rndMonth.nextInt(13)])
			    .withBirthYear(Integer.toString(randBetween(2000, 2014)))
			    .withEmail1(generateRandomEmail())
			    .withEmail2(generateRandomEmail())
			    .withPhone2(generateRandomString());
		    list.add(new Object[]{contact});
		}
		 return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt(999999999);
		}
	}
	
	public String generateRandomPhone() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "+7" + rnd.nextInt(1000000000);
		}
	}

	public String generateRandomEmail() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt(999999999) + "@mail.com";
		}
	}
	
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
