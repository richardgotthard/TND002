package PartA;

import java.io.*;
import java.util.ArrayList;

public class PhoneBook {

	private ArrayList<Person> listOfNumbers;

	public PhoneBook() {
		listOfNumbers = new ArrayList<Person>();
	}

	public String load(String arg) {

		String output;
		try {

			File myFile = new File(arg);
			BufferedReader myBufferedReader = new BufferedReader(new FileReader(myFile));
			String loadPerson;

			while ((loadPerson = myBufferedReader.readLine()) != null) {
				String[] dummy = loadPerson.split(" +");
				int number = Integer.parseInt(dummy[2]);
				Person person = new Person(dummy[0], dummy[1], number);
				listOfNumbers.add(person);

			}

			output = "Phone book loaded";

			myBufferedReader.close();
		} catch (Exception e) {
			output = "Try again!";
		}
		;

		return output;

	}

	public ArrayList<Person> search(String arg) {
		ArrayList<Person> searchResults = new ArrayList<Person>();

		try {

			int searchNumber = Integer.parseInt(arg);
			for (int i = 0; i < listOfNumbers.size(); i++) {

				if (searchNumber == listOfNumbers.get(i).getPhoneNumber()) {
					searchResults.add(listOfNumbers.get(i));
				}

			}

		} catch (Exception ex) {

			for (int i = 0; i < listOfNumbers.size(); i++) {
				if (arg.equals(listOfNumbers.get(i).getSurname())) {
					searchResults.add(listOfNumbers.get(i));
				}
			}

		}

		return searchResults;

	}

	public String deletePerson(String arg1, int arg2) {

		String output = "";
		for (int i = 0; i < listOfNumbers.size(); i++) {
			if (arg1 == listOfNumbers.get(i).getFullName() && arg2 == listOfNumbers.get(i).getPhoneNumber()) {

				listOfNumbers.remove(i);
				output = "Person deleted";
			} else {
				output = "The Person/Number does not exist";
			}

		}
		return output;

	}

	public boolean addPerson(String arg1, int arg2) {
		String[] dummy = arg1.split(" +");
		int length = dummy.length;
		boolean result = true;

		for (int i = 0; i < listOfNumbers.size(); i++) {

			if (length != 2 || arg2 == listOfNumbers.get(i).getPhoneNumber()) {
				result = false;
			}

		}
		if (result == true) {
			Person person = new Person(dummy[0], dummy[1], arg2);
			listOfNumbers.add(person);
		}

		return result;
	}

	public String save(String arg) {
		String output = "";
		try {
			File myFile = new File(arg);
			myFile.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
			for (int j = 0; j < listOfNumbers.size(); j++) {

				String dummy = listOfNumbers.get(j).getFullName() + " " + listOfNumbers.get(j).getPhoneNumber()
						+ "\r\n";
				writer.write(dummy);
			}
			writer.close();
			output = "Saved " + listOfNumbers.size() + " people to the file.";
		} catch (Exception ex) {
			output = "Could not save to the file.";
		}
		return output;
	}

}
