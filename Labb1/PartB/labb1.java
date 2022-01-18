package PartB;

public class labb1 {
	
	public static void main(String[] args) {
		
		
		Databas theDataBase = new Databas();
		
		String [] newdata = theDataBase.rawData.split(",");
		
		calender newcalendar = new calender(newdata.length);
		
		
		for(int i = 0; i < newdata.length; i++)
		{
	    String [] nospace = newdata[i].split(" +");
	    newcalendar.addPerson(nospace);
	    System.out.println(newcalendar.data[i][0]);
	    
	}
		
		System.out.println();
		
		for(int i = 0; i < newdata.length; i++)
		{
			System.out.println(newcalendar.getName(i)[0] + " " + newcalendar.getName(i)[1]);
		}
		
		System.out.println();
		
		for(int i = 0; i < newdata.length; i++)
		{
			System.out.println(newcalendar.getDate(i)[0] + " " + newcalendar.getDate(i)[1] + " " + newcalendar.getDate(i)[2]);
		}
		
		System.out.println();
	    
		for(int i = 0; i < newdata.length; i++) 
		{	
			System.out.println(newcalendar.writeName(i));
		}
		
		System.out.println();

		
		newcalendar.searchSurname("Johnson");
		
		newcalendar.searchNumber(2008);
		
}
	
}

