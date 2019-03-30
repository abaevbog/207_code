package code;
import java.util.Random;


/**
 * The class simulating work of a printer
 * clock: clock count
 * maxWaitTime: max time a request waited to be printed
 * countOfFiles: a counter used to distinguish file names
 * totalWaitTime: total time requests waited
 * requestsSent: number of requests processed
 */
public class Simulation {
	
	static int clock;
	public static int maxWaitTime;
	static int counterOfFiles;
	static int totalWaitTime;
	static int requestsSent;
	
	Simulation() {
		clock = 0;
		counterOfFiles = 0;
		maxWaitTime = 0;
		requestsSent = 0;
		totalWaitTime = 0;
	}
	
	
	public static void main(String args[]) {
		if(args.length < 4) {
			System.out.println("Enter corrent number of parameters");
			return;
		}
		
		double requestProb = Double.parseDouble(args[0]);
		int numOfQueues = Integer.parseInt(args[1]);
		int numOfDequeues = Integer.parseInt(args[2]);
		String option = args[3];
		

		PrintRequest finished = null;
		
		Random rand = new Random();
		Printer printer = new Printer();
		OperatingSystem os = new OperatingSystem(numOfQueues,numOfDequeues, option,printer);
		
		// loop simly counts clock
		for( ;;clock++) {
			
			// if printer is printing stuff, let it print
			if (!printer.isIdle()) {
				printer.processForOneUnit();
			} else {
				// otherwise, adjust queues
				
			    os.adjustQueues();

			    // and try to load a new print request
			    int result = os.findAndLoadJob(clock);
			    
				//if printer is doing
			    // nothing and it did not just finish 
			    // a print request, and time ran out, leave the loop 
				if (printer.isIdle() && (clock >= 1000) && finished ==null) {
					break;

				} 
			    
				// if the printer started a new job
				if (result != -1) {
					//begin printing
					printer.processForOneUnit();
					// update max wait time if needed
					if (result > maxWaitTime) {
						maxWaitTime = result;
					} 
					totalWaitTime+=result;
				}
				


			}
			double chance = (double) rand.nextInt(100)/100;
			
			
			// sometimes issue print request
			if (chance < requestProb && clock < 1000) {
	
				requestsSent++;
				counterOfFiles++;
				int pages = rand.nextInt(100) + 1;
				PrintRequest pr = new PrintRequest(pages, clock, "file_" + counterOfFiles);
				System.out.println("Created request: " + pr.name + " pages: " + pr.numOfPages +
						" cycle: " + clock );
				os.addToQueues(pr);

				
			}
		
		}
		
		System.out.println("Simulation finished with clock cycles: " + clock);
		System.out.println("Performed " + requestsSent + " requests");
		System.out.println("Total wait time: " + totalWaitTime );
		System.out.println("Average wait time: " +(double) totalWaitTime / requestsSent);
		System.out.println("Max wait time: " + maxWaitTime);
	}
}






