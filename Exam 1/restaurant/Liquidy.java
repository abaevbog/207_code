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

public abstract class Liquidy extends MenuItem{

	/**
	 * A class that generalizes the property
	 * of Soup and Beverage as liquidy items.
	 * Defined the percentage of water and
	 * corresponding methods in it
	 */
	
	protected int percentWater;
	/**
	 * @pre:none
	 * create instance of Liquidy object with parameters:
	 * @param nme: name
	 * @param cals: calories
	 * @param price: cost
	 * @param carbsprUnit: carbs per unit (liter or cup)
	 * @param water: % of water in serving
	 */
	Liquidy(String dish, int temp,String nme, int cals, double price, int carbsprUnit, int water) {
		super(dish,temp,nme, cals, price, carbsprUnit);
		percentWater = water;
	}

	/**
	 * @pre:none
	 * @return percent of water in the item
	 */
	public int getPercentWater() {
		return percentWater;
	}

	//instantiating object of an abstract class is impossible
	//so testing of this class will be done in Menu class
}
