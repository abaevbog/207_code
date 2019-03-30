package iowa;

import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class IowaLookup {

	
	public static void main(String args[]) {
		String address;
		String word = "";
		String county = "";
		int total = 0;
		int people = 0;
		double percent = 0;
		double result = 0;
		String resultCounty = "";
		String black = "";
		String indian = "";
		String alaska = "";
		boolean nameLine = true;

		
		
		if (args.length < 1){
			System.out.println("Incorrent number of arguments.");
			System.out.println("The procedure expects 1 argument: the address of the file");
			return;
		} 
		try {
			address = args[0];
			FileReader fileReaderIn = new FileReader (address);
	        // use FileReader object to initialize scanner
	        Scanner fileIn = new Scanner (fileReaderIn);
	        while(fileIn.hasNextLine()) {
	        	String line = fileIn.nextLine();
	        	System.out.println(line);
	        	if (!nameLine) {    //if we are not on the line with county name
	        		black = line.substring(7, 17).trim();
	        		indian = line.substring(17,27).trim();
	        		alaska = line.substring(37,47).trim();
	        		try {
	        			people += Integer.parseInt(black);
	        			people += Integer.parseInt(indian); //calculate total
	        			people += Integer.parseInt(alaska); 
	        		} catch(NumberFormatException e) {
	        			System.out.println(e);
	        		}
	        		
	        	} else {
	        		county = line.substring(0,25).trim();
	        		try {
	        			total = Integer.parseInt(line.substring(25,40).trim());
	        		}catch(NumberFormatException e) {
	        			System.out.println(e);
	        		}
	        	}
	        	nameLine = !nameLine;
	        	if (nameLine) {   			// if we just made it through 2 lines
	        		percent = (double) people / total;
	        		System.out.println("Computed percentage " + percent+" for " + county);
	        		if (percent > result) {
	        			result = percent;
	        			resultCounty = county;
	        		}
	        	}
	        	
	        	
	        }
	     System.out.println(resultCounty + " has the highest percentage of " + result);
			
		} catch(IOException e) {
			System.out.println(e);
		}
	}

}