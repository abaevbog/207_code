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

import java.util.ArrayList;



public class Menu extends ArrayList<MenuItem>{
	/**
	 * A collection of menu items sorted 
	 * by cost per unit.
	 */
	
	ArrayList<MenuItem> menuArray;
	
	Menu() {
		menuArray = new ArrayList<MenuItem>();
	}
	
	/** 
	 * 
	 * Add a MenuItem item into the menu.
	 * @pre: none
	 * @post: All items are inserted so that the original 
	 * order of elements sorted by cost per unit
	 * in ascending order is preserved
	 * @param item- item to be added to menu
	 */
	public void addMenuItem(MenuItem item) {
		menuArray.add(item);
		int i = menuArray.size()-1;
        while (i > 0 && item.compareTo(menuArray.get(i-1)) == -1) {
            menuArray.set(i, menuArray.get(i-1));
            i--;
        }
        menuArray.set(i,item);
	}
	
	/**
	 * Print out all items in the menu
	 * @pre: none
	 * @post: items are printed out 
	 * according to the format defined
	 * in their classes
	 */
	public void printMenu() {
		System.out.println ("Menu Listing");
        for (MenuItem item: menuArray) {
        	System.out.println(item);
        }
        System.out.println ("End of Listing");
    }
	
	/**
	 * Determines the item with lowest carbs
	 * in the menu
	 * @return the item with the lowest amount
	 * of carbs per serving
	 * @post: If the menu is empty, return null
	 */
	public MenuItem getLowestCarbs() {
		if (menuArray.isEmpty() ){
			return null;
		} else {
			MenuItem lowest = menuArray.get(0);
			for (MenuItem item: menuArray) {
	        	if (item.getCarbohydrates() < lowest.getCarbohydrates()) {
	        		lowest = item;
	        	}
	        }
			return lowest;
		}
	}
	
	//testing
	public static void main (String args[]) {
		
		//create the menu and some items
		Menu menu = new Menu();
		 
		System.out.println("Printing the empty menu!");
		menu.printMenu();
		System.out.println("Lowest carbs in an empty menu: " + menu.getLowestCarbs());
		
		Soup onionSoup = new Soup("Big bowl",70,"Onion soup", 200, 8.5, 300, 40, 2.5 );
		Soup fishSoup = new Soup("Big bowl",70,"Fish soup", 250, 9.5, 400, 45, 2.3 );
		Soup meatSoup = new Soup("Big bowl",70,"Meat soup", 300, 10.0, 500, 50, 2.7 );
		
		Beverage juice = new Beverage("Big glass",70,"Juice", 30, 2.5, 40, 70, 0.5);
		Beverage wine = new Beverage("Big glass",70,"Wine", 50, 7, 30, 80, 0.7);
		Beverage smoothie = new Beverage("Big glass",70,"Smoothie", 90, 5, 100, 60, 0.5);
		
		Food meat = new Food("Big dish",70,"Meat", 500, 0.5, 60, 300, 10);
		Food fish = new Food("Big dish",70,"Fish", 400, 0.2, 50, 250, 10);
		Food veggies = new Food("Big dish",70,"veggies", 300, 0.2, 40, 200, 8);
		
		//add items
		menu.addMenuItem(onionSoup);
		menu.addMenuItem(meatSoup);
		menu.addMenuItem(fishSoup);
		menu.addMenuItem(juice);
		menu.addMenuItem(wine);
		menu.addMenuItem(smoothie);
		menu.addMenuItem(meat);
		menu.addMenuItem(fish);
		menu.addMenuItem(veggies);
		
		System.out.println("Printing the menu!");
		menu.printMenu();
		
		System.out.println("Lowest carbs: " + menu.getLowestCarbs());
		
	}
	
	
	
}
