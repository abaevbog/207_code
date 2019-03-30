package iowalookup;

import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class IowaLookup {

	/**
	 * Program to read the address of the file from the 
	 * command line and analyze the population data 
	 * about iowa state population from the file
	 * @precond: one command line argument is
	 * the address of a file iowa-counties.txt
	 * @postcond: compute the percentage
	 * of Black, American Indians and Alaska Natives
	 * in iowa counties and find the 3 max ones
	 * @param args, list with one entry: address 
	 * of iowa-counties.txt
	 * @return: none, but the 3 counties with the highest
	 * percentage of Black, American Indians and Alaska
	 *  Natives population are printed
	 */
	public static void main(String args[]) {
		String address;
		String word = "";
		String county = "";
		int total = 0;
		int people = 0;
		double percent = 0;
		double resultMax = 0;
		double resultSecondMax = 0;
		double resultThirdMax = 0;
		String resultCountyFirst = "";
		String resultCountySecond = "";
		String resultCountyThird = "";
		String black = "";
		String indian = "";
		String alaska = "";
		boolean nameLine = true;   // indicates if current line if the one with 
									//county name or with population data
			
		//make sure we get at least one command line argument
		if (args.length < 1){
			System.out.println("Incorrent number of arguments.");
			System.out.println("The procedure expects 1 argument: the address of the file");
			return;
		} 
		try {
			address = args[0];  	//get the address
			FileReader fileReaderIn = new FileReader (address);
	        Scanner fileIn = new Scanner (fileReaderIn);
	        
	        while(fileIn.hasNextLine()) {  	//keep reading till the end
	        	String line = fileIn.nextLine();
	        	if (line.length() > 5) {		//handles two last lines that only have whitespaces
	        		
		        	if (!nameLine) {    //if we are not on the line with county name
		        		
		        		black = line.substring(7, 17).trim();
		        		indian = line.substring(17,27).trim();
		        		alaska = line.substring(39,47).trim();			//get the values
		        		try {
		        			people += Integer.parseInt(black);		//and compute total
		        			people += Integer.parseInt(indian); 	//of the 3 population groups
		        			people += Integer.parseInt(alaska); 	//in county
		        		} catch(NumberFormatException e) {	
		        			System.out.println(e);
		        		}
		        		
		        	} else {			// if we are on the line with the name of the county
		        		county = line.substring(0,25).trim();
		        		try {			//get the name and parse total population of the county
		        			total = Integer.parseInt(line.substring(25,40).trim());
		        		}catch(NumberFormatException e) {
		        			System.out.println(e);
		        		}
		        	}
		        	nameLine = !nameLine;
		        	if (nameLine) {   			// if we just processed 2 more lines
		        		percent = (double) people / total; //compute percentage
		        		if (percent > resultMax) {
		        			resultThirdMax = resultSecondMax;
		        			resultCountyThird = resultCountySecond;
		        			resultSecondMax = resultMax;
		        			resultCountySecond = resultCountyFirst;
		        			resultMax = percent;			//update current results if needed
		        			resultCountyFirst = county;
		        			
		        		} else if (percent > resultSecondMax) {
		        			resultThirdMax = resultSecondMax;
		        			resultCountyThird = resultCountySecond;
		        			resultSecondMax = percent;
		        			resultCountySecond = county;
		        		} else if(percent > resultThirdMax) {
		        			resultThirdMax = percent;
		        			resultCountyThird = county;
		        		}
		        	}
		        	
		        	
		        }
	        }
	     System.out.printf("%s has the highest percentage of %.3f \n", resultCountyFirst,resultMax);
	     System.out.printf("%s has the second highest percentage of %.3f \n", resultCountySecond,resultSecondMax);
	     System.out.printf("%s has the third highest percentage of %.3f \n", resultCountyThird,resultThirdMax);
		fileIn.close();
		} catch(IOException e) {
			System.out.println(e);
		}
	}

}
