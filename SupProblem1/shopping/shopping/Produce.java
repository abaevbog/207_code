package shopping;

/**
 * 
 * @author bogdanabaev
 *	Class Produce
 *	Subclass of Item
 */
public class Produce extends Item {

	private double pounds;
	private String category;
	
	/**
	 * 
	 * @param thing Name of item
	 * @param price Cost of item
	 * @param weight weight of item in pounds
	 * @param type category of item
	 * 
	 */
	public Produce(String thing, double price, double weight, String type) {
		super(thing, price);
		pounds = weight;
		category = type;
	}
	/**
	 * @return computed cost per unit
	 */
	public double costPerUnit() {
		return cost/pounds ;
	}
	/**
	 * Pretty printing
	 */
	public String toString() {
		return super.toString() + 
				"Weight: " + pounds +
				"\nCategory: " + category+"\n";
	}
	
	public static void main(String args[]) {
		System.out.println("Testing Produce class");
		
		Produce prod1 = new Produce("firstProfuce", 2.5, 1.1, "goodType");
		Produce prod2 = new Produce("secondProfuce", 3.5, 1.15, "badType");
		Produce prod3 = new Produce("thirdProfuce", 4.5, 1.9, "normalType");
		
		System.out.printf("Price per unit of firstProduce: %.2f \n", prod1.costPerUnit());
		System.out.printf("Price per unit of secondProduce: %.2f \n", prod2.costPerUnit());
		System.out.printf("Price per unit of thirdProduce: %.2f \n", prod3.costPerUnit());
		
		System.out.println(prod1);
		System.out.println(prod2);
		System.out.println(prod3);
	}
}
