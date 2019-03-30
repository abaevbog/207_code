package code;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Class describing one queue in the printer.
 * queue: actual queue of print requests
 * numOfDeuques: number of dequeues performed
 * since the last promotion of an element
 *
 */
public class Queue {
	
	private ConcurrentLinkedQueue<PrintRequest> queue;
	private int numOfDequeues;

	Queue() {
		 queue = new ConcurrentLinkedQueue<PrintRequest>();
		 numOfDequeues= 0;
	}
	

	/**
	 * getter of numOfDequeues
	 */
	public int getNumOfDequeues() {
		return numOfDequeues;
	}


	/**
	 * setter of numOfDequques
	 */
	public void setNumOfDequeues(int numOfDequeues) {
		this.numOfDequeues = numOfDequeues;
	}



	/**
	 * place print request into the queue
	 * @param pr
	 */
	public void enqueue(PrintRequest pr) {
		this.queue.add(pr);
	}
	
	/**
	 * remove the first print request from the queue
	 * does not return anything if there is nothing to return
	 * @return: print request
	 */
	public PrintRequest dequeue() {
		numOfDequeues++;
		return this.queue.poll();
	}
	
	/**
	 * 
	 * @return true if queue is empty, false 
	 * otherwise
	 */
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}
	
	
}
