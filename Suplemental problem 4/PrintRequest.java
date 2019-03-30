package code;


/**
 * Class describing a print request
 *numOfPages: number of pages to print
 *pagesLeft: number of pages not yet printed
 *timeSubmitted: time when request was sent
 *name: simply the name of the file
 *timeWaited: time the request waited in queue
 *before printing started
 *
 */
public class PrintRequest {

	public int numOfPages;
	public int pagesLeft;
	public int timeSubmitted;
	public String name;
	public int timeWaited;
	
	PrintRequest(int pages,int time, String file) {
		numOfPages = pages;
		pagesLeft = pages;
		timeSubmitted = time;
		name = file;
		timeWaited = 0;
	}
}
