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

public class Food extends MenuItem {


	/**
	 * Class defining the properties and 
	 * methods of Food category in the menu
	 */
	protected int portionInGrams;
	protected int saltInGrams;
	
	/**
	 * @pre:none 
	 * create an instance of Food object with parameters:
	 * @param nme: name
	 * @param cals: calories
	 * @param price: cost
	 * @param carbsprUnit: carbs per gram
	 * @param portion: grams in serving
	 * @param salt: grams of salt in serving
	 */
	Food(String dish, int temp,String nme, int cals, double price, int carbsprUnit, int portion, int salt) {
		super(dish,temp,nme, cals, price, carbsprUnit);
		portionInGrams = portion;
		saltInGrams = salt;
	}
	
	/**
	 * 
	 * @return number of grams in a serving
	 */
	public int getPortionInGrams() {
		return portionInGrams;
	}



	/**
	 * 
	 * @return the amount of salt that goes 
	 * into a serving
	 */
	public int getSaltInGrams() {
		return saltInGrams;
	}


	/**
	 * @return cost per gram
	 */
	public double getCostPerPortionSize() {
		return (double)cost * portionInGrams;
	}

	/**
	 * @return total amount of carbs in a serving
	 */
	public double getCarbsPerPortionSize() {
		return portionInGrams * carbsPerUnit;
	}

	/**
	 * pretty printing
	 */
	public String toString() {
		return super.toString() + 
				"\nCost: " + this.getCostPerPortionSize()
				+"\nCarbs in serving: " + this.getCarbsPerPortionSize() +
				"\nGrams in portion: " + this.portionInGrams 
				+"\nGrams of salt in portion: " + this.saltInGrams+"\n";
	}
	
	//testing
	public static void main (String args[]) {
		Food meat = new Food("Big dish",80,"Meat", 500, 0.5, 60, 300, 1);
		Food fish = new Food("Meduim dish",70,"Fish", 450, 0.2, 50, 200, 2);
		System.out.println(meat);
		System.out.println(fish);

	}

	
}
