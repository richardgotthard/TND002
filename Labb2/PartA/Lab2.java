package PartA;

import java.io.*;

public class Lab2 {

	public static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

	public static final String questionToUser = "You have the following options :\n"
			+ "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
			+ "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
			+ "List reduced content : type '1'\nList full content : type '2'\n"
			+ "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";

	public static String consoleInput() {
		String userinput;
		try {
			System.out.println(questionToUser);
			userinput = consoleReader.readLine();
		} catch (IOException err) {
			userinput = "";
		}
		;

		return userinput;

	}

	public static void main(String[] args) throws IOException {
		Dictionary dictionary = new Dictionary();
		String User = "";
		do {
			User = consoleInput().trim();

			String[] dummy;

			dummy = User.split(" +");

			if (User.equals("")) {
				System.out.println("Something went wrong...\n");
			}

			else if (dummy[0].equals("load")) {

				try {

					File myFile = new File(dummy[1]);
					BufferedReader myBufferedReader = new BufferedReader(new FileReader(myFile));
					String loadString;
					String loadWord = new String();

					while ((loadString = myBufferedReader.readLine()) != null) {
						loadWord += loadString;
					}
					dictionary.addWords(loadWord);
					System.out.println(loadWord);

					myBufferedReader.close();
				} catch (IOException IOerror) {
					System.out.println("No such file exists...");

				} catch (NumberFormatException error) {
					System.out.println("IO Exception");

				}

			}
			else if (User.equals("1")) {
				
				Word.changeOutputFormat(0);
				
				System.out.println(dictionary.toString());	
			}
            else if (User.equals("2")) {
				
				Word.changeOutputFormat(1);
				
				System.out.println(dictionary.toString());	
			}
			

			else if (User.equals("3")) {
				dictionary.removeDuplicate();}
			else if(User.equals("4")) {
				dictionary.sortDictionaryByCounts();}
			else if (User.equals("5")) {
				System.out.println(dictionary.countOccurences());
			}

			else if (dummy[0].equals("save")) {
				
				dictionary.setFileName(dummy[1]);
				

			} 
			else
			{
				dictionary.addWords(User);
			}
			

		} while (!User.equals("end"));

		System.out.println("Bye!");

	}
}

// String input = System.console().readLine();

// Word theWord = new Word("Text.txt");
// myWord.getWord(10004);
