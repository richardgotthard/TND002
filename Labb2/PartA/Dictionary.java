package PartA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Dictionary {

	private ArrayList<Word> theDictionary;
	private BufferedWriter OutputWriter;

	public Dictionary() {
		theDictionary = new ArrayList<Word>();
	}

	public Dictionary(String arg) {
		theDictionary = new ArrayList<Word>();

		addWords(arg);
	}

	public void addWords(String arg) {

		arg = arg.replaceAll("[0-9]", "");

		String[] Words = arg.split(" +");

		for (int i = 0; i < Words.length; i++) {

			theDictionary.add(new Word(Words[i]));
		}

	}

	public int numberOfWords() {

		return theDictionary.size();
	}

	public void removeDuplicate() {

		for (int i = 0; i < theDictionary.size() - 1; i++) {

			for (int j = i + 1; j < theDictionary.size(); j++) {

				if (theDictionary.get(i).getWord().equals(theDictionary.get(j).getWord())) {

					theDictionary.get(i).increaseCounts();
					theDictionary.remove(j);

					j--;

				}

			}
		}
		System.out.println("You have grouped all duplicate words in your dictionary\n");

	}

	public String countOccurences() {
		String output = "";

		int max = 0;

		for (int i = 0; i < theDictionary.size(); i++) {
			if (theDictionary.get(i).getCounts() > max) {
				max = theDictionary.get(i).getCounts();
			}

		}

		for (int counter = 1; counter < max + 1; counter++) {
			int size = 0;
			for (int j = 0; j < theDictionary.size(); j++) {

				if (theDictionary.get(j).getCounts() == counter) {
					size = size + 1;
				}

			}

			if (size > 0) {
				output = output + ("There are " + size + " words that occured " + counter + " times \n");
			}

		}
		return output;
	}

	public void sortDictionaryByCounts() {

		for (int i = 0; i < numberOfWords() - 1; i++) {

			for (int j = i + 1; j < numberOfWords(); j++) {
				int first = theDictionary.get(i).getCounts();
				int second = theDictionary.get(j).getCounts();
				if (first < second) {
					Collections.swap(theDictionary, i, j);
				}
			}
		}
	}

	public void setFileName(String arg) throws IOException {
		File myFile = new File(arg);
		myFile.createNewFile();

		OutputWriter = new BufferedWriter(new FileWriter(myFile, false));

		OutputWriter.write(toString());
		saveFile();
		OutputWriter.close();

	}

	public void saveFile() {
		try {

		} catch (Exception err) {
			System.out.println("Not able to save file...");
		}

	}

	public String toString() {
		String arg = "";
		int occurences = 0;
		for (int i = 0; i < numberOfWords(); i++) {
			occurences += theDictionary.get(i).getCounts();
		}
		arg += "Total words: " + numberOfWords() + " and total occurences " + occurences + "\r\n";

		for (int j = 0; j < numberOfWords(); j++) {
			arg += theDictionary.get(j).toString();

		}
		return arg;

	}

}
