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

public class Beverage extends Liquidy {

	/**
	 * Class defining the properties 
	 * and methods of the beverages in 
	 * the menu.
	 */

	protected double portionInLiters;
	
	/**
	 * 
	 * Create instance of Beverage object with parameters:
	 * @param nme: name
	 * @param cals: calories
	 * @param price: cost
	 * @param carbsprUnit: carbs per unit (liters)
	 * @param water: % of water
	 * @param portion: number of liters in serving
	 * @pre:none
	 * @post: an instance of the class created
	 */
	Beverage(String dish, int temp,String nme, int cals, double price, int carbsprUnit, int water, double portion) {
		super(dish,temp,nme, cals, price, carbsprUnit, water);
		portionInLiters = portion;
	}
	
	/**
	 * @pre: portionInLiters is not 0
	 * @post: cost per liter returned
	 * @return cost per liter
	 */
	public double getCostPerPortionSize() {
		return cost * portionInLiters;
	}

	/**
	 * @pre:none
	 * @post: total carbs in a serving returned
	 * @return total carbs in a serving
	 */
	public double getCarbsPerPortionSize() {
		return carbsPerUnit * portionInLiters;
	}

	/**
	 * @pre: none
	 * @post: number of liters in a srving returned
	 * @return amount of liters in a serving
	 */
	public double getPortionInLiters() {
		return portionInLiters;
	}

	
	/**
	 * pretty printing
	 */
	public String toString() {
		return super.toString() + 
				"\nCost: " + this.getCostPerPortionSize()
				+"\nCarbs per serving: " + this.getCarbsPerPortionSize()+
				"\nPortion in liters: " + portionInLiters+
				"\nPercent of water: " + percentWater + "\n";
	}
	//testing
	public static void main(String args[]) {

		Beverage juice = new Beverage("Big glass",40,"Juice", 30, 5, 40, 70, 0.5);
		Beverage wine = new Beverage("Small glass",80,"wine", 40, 4, 50, 60, 0.5);
		
		System.out.println(juice);

		System.out.println(wine);
		
	}

}
