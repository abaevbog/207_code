package shopping;

/**
 * 
 * @author bogdanabaev
 *	Class Beverage
 *	Subclass of Item
 */
public class Beverage extends Item {

	private int fluidOunces;
	private double containerDeposit;
	
	/**
	 * 
	 * @param thing Name of item
	 * @param price Cost of item
	 * @param ounces weight of item in fluidOunces
	 * @param deposit containerDeposit of Item
	 */
	public Beverage(String thing, double price, int ounces, double deposit) {
		super(thing, price);
		fluidOunces = ounces;
		containerDeposit = deposit;
	}
	/**
	 * @return computed cost of item
	 */
	public double getCost() {
		return cost + containerDeposit;
	}
	/**
	 * @return computed cost per unit
	 */
	public double costPerUnit() {
		return cost/fluidOunces;
	}
	/**
	 * Pretty printing
	 */
	public String toString() {
		return super.toString() +
				"Fluid Ounces: " + fluidOunces +
				"\nDepoist: " + containerDeposit +"\n";
	}
	
	public static void main(String args[]) {
		System.out.println("Testing Beverages class");
		
		Beverage bev1 = new Beverage("firstBeverage", 2.5,1, 0.5);
		Beverage bev2 = new Beverage("secondBeverage", 3.5, 1, 3.3);
		Beverage bev3 = new Beverage("thirdBeverage", 4.5, 2, 2.3);
		
		System.out.printf("Price of firstBeverage: %.2f \n", bev1.getCost());
		System.out.printf("Price of secondBeverage: %.2f \n", bev2.getCost());
		System.out.printf("Price of thirdBeverage: %.2f \n", bev3.getCost());
		
		
		System.out.printf("Price per unit of firstBeverage: %.2f \n", bev1.costPerUnit());
		System.out.printf("Price per unit of secondBeverage: %.2f \n", bev2.costPerUnit());
		System.out.printf("Price per unit of thirdBeverage: %.2f \n", bev3.costPerUnit());
		
		System.out.println(bev1);
		System.out.println(bev2);
		System.out.println(bev3);
	}
	
}



