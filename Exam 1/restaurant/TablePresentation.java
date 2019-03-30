    /*****************************************************************
     * Bogdan Abaev                                            *
     * PO Box 3003                                            *
     * Program for CSC 207                                           *
     *   Exam 1, problem 2                                 *
     * Assignment for October 9                         *
     *****************************************************************/


    /* ***************************************************************
     * Academic honesty certification:                               *
     *   Written/online sources used:                                *
     *     None                   *
     *   Help obtained                                               *
     *     None                          *
     *     [write "none" if none of these sources used]              *
     *   My signature below confirms that the above list of sources  *
     *   is complete AND that I have not talked to anyone else       *
     *   [e.g., CSC 161 students] about the solution to this problem *
     *                                                               *
     *   Signature:  Bogdan Abaev                                                *
     *****************************************************************/
package restaurant;

/**
 * class with the settings for how to serve the
 * meal + corresponding methods
 * @author bogdanabaev
 *
 */
public class TablePresentation {
	
	protected String dishType;
	protected int servingTemp;
	
	/**
	 * @pre: none
	 * @post: initialized instance of the object
	 * @return dishType, type of dish for a menu item
	 */	
	TablePresentation(String dish,int temp){
		dishType = dish;
		servingTemp = temp;
	}
	
	/**
	 * @pre: none
	 * @post: type of dish returned
	 * @return type of dish for serving
	 */
	public String getDishType() {
		return dishType;
	}

	/**
	 * @pre:none
	 * @post: optimal temperature returned
	 * @return servingTemp, the optimal temperature 
	 * for serving food
	 */
	public int getServingTemp() {
		return servingTemp;
	}

	/**
	 * pretty printing
	 */
	public String toString() {
		return "Dish Type: " + dishType 
				+"\nServing temperature: " + servingTemp + "\n";
	}
	//testing
	public static void main (String args[]) {

		TablePresentation present = new TablePresentation("Big dish", 70);
		
		TablePresentation present2 = new TablePresentation("Small dish", 50);
		System.out.println(present);
		System.out.println(present2);

		
	}
	

}
