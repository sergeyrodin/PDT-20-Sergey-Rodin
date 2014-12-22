package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {
	
	private static String[] days = {"-","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private static String[] months = {"-","January","February","March","April","May","June","July","August","September","October","November","December" };
	private static Random rndDay = new Random();
	private static Random rndMonth = new Random();
	
	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
				System.out.println("File exists, please remove it manually:" + file);
				return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
				saveContactsToXmlFile(contacts, file);
			} else {
				System.out.println("Unknown format" + format);
				return;
			}
	}
	
	public static List<ContactData> generateRandomContacts(int amount) {
		
		List<ContactData> list = new ArrayList<ContactData>();
		
		for (int i = 0; i < amount; i++) {
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
		    System.out.println(contact);
		    list.add(contact);
		}
		 return list;
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contacts", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	public static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress1() + ","
		+ contact.getPhoneHome() + "," + contact.getPhoneMobile() + "," + contact.getPhoneWork() + "," + contact.getBirthDay() 
		+ "," + contact.getBirthMonth() + "," + contact.getBirthYear() + "," + contact.getEmail1() + "," + contact.getEmail2() 
		+ "," + contact.getPhone2() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
	    FileReader reader = new FileReader(file);
	    BufferedReader bufferedReader = new BufferedReader(reader);
	    String line = bufferedReader.readLine();
	    while (line != null) {
	    	String[] part = line.split(",");
	    	ContactData contact = new ContactData()
		    .withFirstName(part[0])
		    .withLastName(part[1])
		    .withAddress1(part[2])
		    .withPhoneHome(part[3])
		    .withPhoneMobile(part[4])
		    .withPhoneWork(part[5])
		    .withBirthDay(part[6])
		    .withBirthMonth(part[7])
		    .withBirthYear(part[8])
		    .withEmail1(part[9])
		    .withEmail2(part[10])
		    .withPhone2(part[11]);
	    list.add(contact);
	    line = bufferedReader.readLine();
	    }
	    bufferedReader.close();
		return list;
	}

	public String generateRandomPhone() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "+7" + rnd.nextInt(1000000000);
		}
	}

	public static String generateRandomEmail() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test_contact_email_" + rnd.nextInt(999999999) + "@mail.com";
		}
	}
	
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test_contact_" + rnd.nextInt(999999999);
		}
	}
}