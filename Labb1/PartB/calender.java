package PartB;

public class calender {
	
	public String[][] data;
	
	public int counter;
	
	public calender(int size) {
		data = new String [size][5];
		counter = 0;
		}
	
	
	public String addPerson (String[] inString) {
		
		String outstring = "";
		
			if (counter > data.length){
		
			outstring = "Not added";
			return outstring;
		
			}
			else {
			for (int i = 0; i < inString.length; i++) {
		
			data[counter][i] = inString[i];
			
			outstring = "Person added at position" + counter;
			}
			                                                                                                                                                                                                     
			counter++;
			
			return outstring;
			
		}	
		
	}
	
	public String[] getName (int entryNumber) {
		
		if ( entryNumber >= -1 && entryNumber < counter ) {
			String [] name = {data[entryNumber][0], data[entryNumber][1]};
		
			return name;
			
		}
		else {
			String [] name = { "John", "doe"};
			return name;
		}
		}
	
	public Integer[] getDate (int entryNumber) {
				
		if ( entryNumber >= -1 && entryNumber < counter ) {
			Integer [] date = {Integer.parseInt( data[entryNumber][2]), Integer.parseInt(data[entryNumber][3]), Integer.parseInt(data[entryNumber][4])};

			return date;
		}
		else {
			Integer [] date = { 1, 1, 1900};
			return date;
		}
		}
	

	
	public String writeName (int entryNumber )
	{  
		
		//String[]  months = { "0", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
		int month = Integer.parseInt(data[entryNumber][3]);
		String info = "";
		String name;
		
		switch(month) {
		case 1: name = "January"; break;
		case 2: name = "February"; break;
		case 3: name = "March"; break;
		case 4: name = "April"; break;
		case 5: name = "May"; break;
		case 6: name = "June"; break;
		case 7: name = "July"; break;
		case 8: name = "August"; break;
		case 9: name = "September"; break;
		case 10: name = "October"; break;
		case 11: name = "November"; break;
		case 12: name = "December"; break;
		default: name = "dadahdah";
		
		}
		
		info = data[entryNumber][0].toLowerCase() + " " + data[entryNumber][1].toUpperCase() + " has birthday on the " + data[entryNumber][2] + " " + name +" "+  data[entryNumber][4] 
				+ " for the person that is stored in the slot " + entryNumber +  " of the global String array data";  
		
		return info;
	}
	
	
	public void searchSurname(String inName) {		
		for (int j=0; j < counter; j++) {
			if (data[j][1].equals(inName)) 
			{
				System.out.println(writeName(j));
			}
		}
	}
	
	public void searchNumber(int inNumber) {
		for (int j=0; j < counter; j++) {
			if (Integer.parseInt(data[j][4]) == inNumber)
			System.out.println(writeName(j));
		}
	}

	
	 
}
	