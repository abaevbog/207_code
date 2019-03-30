package code;


/**
 * Class simulating the behavior of a printer

 * procesedsRequest: request that is currently being
 * printed
 */
public class Printer {

	public PrintRequest processedRequest;

	
	Printer() {
		processedRequest = null;

	}
	
	public boolean isIdle() {
		return (processedRequest == null);	
	}
	
	
	

	
	/**
	 * Send the printing job to the printer.
	 * If there are no jobs waiting, pr 
	 * is being printed. Otherwise, do nothing
	 * @param pr: print request 
	 * @return true if file is printed, false otherwise
	 */
	public boolean printFile(PrintRequest pr) {
		if (this.isIdle()) {
			processedRequest = pr;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * If the printer is idle do nothing.
	 * If the printer is not idle, and it finishes printing
	 * return the request it finished. Else, return null;
	 */
	public PrintRequest processForOneUnit() {
		if(this.isIdle()) {

			return null;
		}
		// if the printed is doing stuff, decrease the pagesLeft
		if (this.processedRequest.pagesLeft > 1) {
			System.out.println("Processing " + this.processedRequest.name + " pages: "+ this.processedRequest.pagesLeft);
			this.processedRequest.pagesLeft -=1;
			return null;
		} else {
			//or return the finished request
			PrintRequest pr = processedRequest;
			processedRequest = null;
			return pr;
		}
		
	}
	
	

}




