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

public abstract class MenuItem extends TablePresentation implements Edible,
	Comparable<MenuItem> {

	/**
	 * Class defining the general behavior of all 
	 * items found in the menu of the restaurant.
	 * Implementation of methods specific to 
	 * particular types of items is found in 
	 * the subclasses
	 */
	
	protected String name;
	protected int calories;
	protected double cost;
	protected int carbsPerUnit; //carbs per gram of item

	/**
	 * 
	 * Create a new MenuItem instance with
	 * @param nme = name
	 * @param cals = calories
	 * @param price = cost
	 * @param carbsprUnit =carbsPerUnit
	 * @pre: none
	 * @post: a new instance of MenuItem object created
	 */
	MenuItem(String dish, int temp, String nme, int cals, double price, int carbsprUnit){
		super (dish,temp);
		name = nme;
		calories =  cals;
		cost = price;
		carbsPerUnit = carbsprUnit;
	}
	/**
	 * @pre:none
	 * @post: returned cost of the item per Unit
	 * @return cost of a menu item
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @pre:none
	 * @post: carbs per unit (gram/liter, etc.) returned
	 * @return amount of carbs per unit
	 * the item contains
	 */
	public int getCarbohydrates() {
		return carbsPerUnit;
	}
	


	/**
	 * @pre:none
	 * @post: name of the item returned
	 * @return the name of an item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @pre:none
	 * @post: calories in the item returned
	 * @return calories of an item
	 */
	public int getCalories() {
		return calories;
	}
	
	/**
	 * abstract method. See subclasses for details
	 */
	public abstract double getCostPerPortionSize();
	
	/**
	 * abstract method. See subclasses for details
	 */
	public abstract double getCarbsPerPortionSize();

	/**
	 * @pre: item's field for cost are well-defined
	 * implementing comparable interface
	 * @post: comparing the two items based on cost per
	 * size of the serving
	 * @return -1,1 or 0 if the cost per unit of MenuItem i 
	 * is greater than, less than or equal to this item,
	 * respectively
	 * 
	 */
	public int compareTo(MenuItem item) {
		if (this.getCostPerPortionSize() < item.getCostPerPortionSize()) {
			return -1;
		} 
		if(this.getCostPerPortionSize() > item.getCostPerPortionSize()) {
			return 1;
		} 

		return 0;
		
	}
		
	/**
	 * pretty-printing
	 */
	public String toString() {
		return  super.toString() + 
				"Item's name: " + name 
				+"\nCalories: " + calories
				+"\nCost per unit : " + cost
				+"\nCarbs Per Unit: " + carbsPerUnit;
	}
	
	//instantiating object of an abstract class is impossible
	//so testing of menu item will be done in Menu class
	
	
}
