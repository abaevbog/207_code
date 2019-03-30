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

public interface Edible {

	/**
	 * Interface defining the most
	 * general properties of all
	 * edible items in the restaurant
	 */
	
	/**
	 * @pre:none
	 * @post: name of the item returned
	 * @return the name of an item
	 */
	public String getName();
	
	/**
	 * @pre:none
	 * @post: calories in the item returned
	 * @return calories of an item
	 */
	public int getCalories();
}
