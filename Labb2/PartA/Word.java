package PartA;

public class Word {
	
	private int counts;
	private static int outputFormat;
	private String theWord;
	
	public String[] text;
	
	
	public Word(String arg) {
		theWord = arg;
		counts = 1;
		outputFormat = 0;
	}
	
	
	public String getWord() {
		
		
		return theWord;
	}
	
	
	public int getCounts() {
		
		
		return counts;
	}
	
	
	public void increaseCounts() {
		counts = counts + 1;
	}
	
	
	public static void changeOutputFormat(int form) {
	
			outputFormat = form;
	}
	
	
	
	public String toString(){
		
		String result = "";
		
		if(outputFormat == 0) {
			result = "The Word is : " + theWord + "\r\n";
		}
		else if (outputFormat == 1) {
			result =  "The word " +  theWord + " has occured " + counts + " times \r\n";
		}
		
		return result;
		
	}
	
	
	
	
	

}