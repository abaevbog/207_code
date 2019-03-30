    /*****************************************************************
     * Bogdan Abaev                                             *
     * PO Box 3003                                            *
     * Program for CSC 207                                           *
     *   Supplemental problem 1                                  *
     * Assignment for Friday, September 28                           *
     *****************************************************************/


    /* ***************************************************************
     * Academic honesty certification:                               *
     *   Written/online sources used:                                *
     *     none                      *
     *   Help obtained                                               *
     *     none                            *
     *     [write "none" if none of these sources used]              *
     *   My signature below confirms that the above list of sources  *
     *   is complete AND that I have not talked to anyone else       *
     *   [e.g., CSC 161 students] about the solution to this problem *
     *                                                               *
     *   Signature:     Bogdan Abaev                                             *
     *****************************************************************/
package shopping;

/**
 * 
 * @author bogdanabaev
 * Base class Item
 */
public class Item{
	
	//fields of base class
	//accessible only by its subclasses
	protected String name;
	protected double cost;
	
	/**
	 * 
	 * @param thing Name of Item
	 * @param price cost of Item
	 */
	public Item(String thing, double price) {
		name = thing;
		cost = price;
	}
	/**
	 * 
	 * @return the cost of Item
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * 
	 * @return computed costPerUnit of Item
	 */
	public double costPerUnit() {
		return cost;
	}
	/**
	 * Pretty printing
	 */
	public String toString() {
		return "Name: " + name + "\n" +
	            "Cost: " + cost+"\n";
	}
	/**
	 * 
	 * @param nameOfItem is the name we compare Item.name to
	 * @return true if nameOfItem is the same as Item.name
	 * 			or false otherwise
	 */
	public boolean equals(String nameOfItem) {
		return (name.equals(nameOfItem));		
	}
	
	public static void main(String args[]) {
		System.out.println("Testing Item class");
		
		Item item1 = new Item("firstItem", 1.3);
		Item item2 = new Item("secondItem",2.4 );
		Item item3 = new Item("thirdItem", 3.2);
		
		System.out.println("Price of firstItem: " + item1.getCost());
		System.out.println("Price of secondItem: " + item2.getCost());
		
		System.out.println("Price per unit of thirItem: " + item3.costPerUnit());
		
		System.out.println(item1);
		System.out.println(item1);
		System.out.println(item1);
	}
}






