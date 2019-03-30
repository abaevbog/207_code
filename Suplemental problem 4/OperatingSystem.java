package code;


/**
 * Class in charge of managing queues.
 * * allQueues: list of queues of all priorities
 * procesedsRequest: request that is currently being
 * printed
 * queueingOption: A, B or C approach determining how 
 * elements are placed in queues
 * numOfQueues: number of queues
 * dequeueCutOff: number of dequeues that take place
 * in each queue before an element is promoted from that
 * queue to a higher priority
 */
public class OperatingSystem {

	public Queue[] allQueues;
	public String queueingOption;
	public int numOfQueues;
	public int dequeueCutOff;
	public Printer printer;
	
	OperatingSystem(int numberOfQueues, int dequeueNum, String options, Printer prnt) {
		allQueues = new Queue[numberOfQueues];
		numOfQueues = numberOfQueues;
		dequeueCutOff = dequeueNum;
		queueingOption = options;
		for (int i =0; i < numOfQueues;i++) {
			allQueues[i] = new Queue();
		}
		printer = prnt;
	}
	
	
	
	
	
	
	/**
	 * Add the print request to a corresponding
	 * queue depending on the type of queue
	 * distribution selected by the user.
	 * A- everything goes into the 1st queue
	 * B- if i is the 1st digit in the number of 
	 * pages of the pr, pr goes to i'th queue
	 * C- index of the queue if pages mod number 
	 * of queues
	 * @param pr: print request
	 */
	public void addToQueues(PrintRequest pr) {
		if (printer.isIdle()) {
			printer.printFile(pr);
			return;
		}
		if (this.queueingOption.equals("B")) {
			int number = pr.numOfPages / numOfQueues;
			if (number >= numOfQueues)
				number = numOfQueues - 1;
			this.allQueues[number].enqueue(pr);
			System.out.println("BRequest " + pr.name +" added to " + number +" queue");
		} else if (this.queueingOption.equals("A")) {
			this.allQueues[0].enqueue(pr);
			System.out.println("ARequest " + pr.name +" added to " + 0 +" queue");
		} else {
			int number = pr.numOfPages % numOfQueues;
			this.allQueues[number].enqueue(pr);
			System.out.println("CRequest " + pr.name +" added to " + number +" queue");
		}
	}
	
	
	/**
	 * Finds the highest priority job in queues and
	 * sends it to the printer, if found.
	 * @param clock
	 * @return: the time a request waited to be printer
	 * if request found, if no request found in all
	 * queues, return -1
	 */
	public int findAndLoadJob(int clock) {
		// if the printed is not doing anything
		for(int i = 0; i < numOfQueues; i ++) {
			// go through all queues until you find the
			// one that has a job and execute it
			if (!this.allQueues[i].isEmpty()) {
				PrintRequest pr = this.allQueues[i].dequeue();
				printer.printFile(pr);
				pr.timeWaited = clock - pr.timeSubmitted;
				return pr.timeWaited;
			}
			
		}
		return -1;

	}
	
	
	/**
	 * Function that iterates though all queues and 
	 * promotes jobs from queues where dequeuing happened
	 * dequeueCutOff times
	 * @param clock: current time
	 */
	public void adjustQueues() {
		PrintRequest pr2 = null;
		for (int i = 1; i < numOfQueues; i ++) {

			//move jobs to a higher priority if needed
			if (!allQueues[i].isEmpty() && (allQueues[i].getNumOfDequeues() >= dequeueCutOff) ) {
				allQueues[i].setNumOfDequeues(0);
				pr2 = allQueues[i].dequeue();
				allQueues[i-1].enqueue(pr2);
				
			}
			
		}

	}
	
	
}
