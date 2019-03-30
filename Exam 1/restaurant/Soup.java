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

public class Soup extends Liquidy {

	/**
	 * Class defining the properties and methods
	 * of soups in the restaurant
	 */

	protected double cupsInPortion;

	/**
	 * @pre:none
	 * @post: instance of Soup object initialized
	 * Creating an instance of Soup object with parameters:
	 * @param nme: name
	 * @param cals: calories
	 * @param price: cost
	 * @param carbsprUnit: carbs per cup
	 * @param water: % of water
	 * @param cups: number of cups in serving
	 * @return instance of soup object
	 */
	Soup(String dish, int temp,String nme, int cals, double price, int carbsprUnit, int water, double cups) {
		super(dish,temp,nme, cals, price, carbsprUnit, water);
		cupsInPortion = cups;
	}
	

	/**
	 * @pre: none
	 * @post: cost per cup of soup returned
	 * @return cost per cup of the soup
	 */
	public double getCostPerPortionSize() {
		return (double) cost * cupsInPortion;
	}

	/**
	 * @pre:none
	 * @post: total amount of carbs in serving returned
	 * @return total amount of carbs in portion
	 */
	public double getCarbsPerPortionSize() {
		return carbsPerUnit * cupsInPortion;
	}
	
	/**
	 * @pre:none
	 * @post: number of cups in a portion returned
	 * @return number of cups in a serving
	 */
	public double getCupsInPortion() {
		return cupsInPortion;
	}


	/**
	 * pretty printing
	 */
	public String toString() {
		return super.toString() + 
				"\nCost: " + this.getCostPerPortionSize()
				+"\nCarbs per serving: " + this.getCarbsPerPortionSize()
				+"\nCups in portion: " + cupsInPortion +
				"\nPercent of water: " + percentWater + "\n";
	}
	//testing
	public static void main (String args[]) {
		

		Soup onionSoup = new Soup("Big dish",60,"Onion soup", 200, 8.5, 300, 40, 2.5 );

		
		System.out.println(onionSoup);
		System.out.println("Cost per cup: " + onionSoup.getCostPerPortionSize());
		System.out.println("Carbs in serving: " + onionSoup.getCarbsPerPortionSize());
		System.out.println(onionSoup);
}

}
