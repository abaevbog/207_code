package shopping;

/**
 * 
 * @author bogdanabaev
 *Class shoppingCart
 */
public class ShoppingCart {

	//array of Items
	private Item [] Cart;
	private int maxSize;
	private static int currentSize;
	
	/**
	 * Initialize an empty cart
	 */
	public ShoppingCart() {
		maxSize = 3;
		Cart = new Item[maxSize];
		currentSize = 0;
	}
	/**
	 * 
	 * @param thingy is an Item to be added
	 * to the cart
	 * Size of Cart array is increases as needed
	 */
	public void addItem(Item thingy) {
		if (currentSize == maxSize) {
			maxSize = maxSize*2;
			Item [] temp =  new Item [maxSize];
			for (int i =0; i < currentSize; i++) {
				temp[i] = Cart[i];
			}
			Cart = temp;
		}
		
		
		Cart[currentSize] = thingy;
		currentSize+=1;
	}
	
	/**
	 * Print all elements in the cart
	 */
	public void printCart() {
		System.out.println("Items currently in the cart: \n");
		for (int i =0; i < currentSize; i ++) {
			System.out.println("Item " + i + ":\n" + Cart[i]);
		}
	}
	
	/**
	 * 
	 * @return total cost of items in the cart
	 */
	public double totalCost() {
		double total = 0;
		for (int i =0; i < currentSize; i ++) {
			total += Cart[i].getCost();
		}
		return total;
	}
	/**
	 * 
	 * @param thing is the name of item to find in the cart
	 * @return the number of items with the given name in 
	 * the cart
	 */
	public int numberInCart(String thing) {
		int count = 0;
		for (int i =0; i < currentSize; i ++) {
			if(Cart[i].equals(thing)) {
				count ++;
			}
		}
		return count;
	}
	//testing
	public static void main(String args[]) {
		//initialize all objects we need
		Beverage drink1 = new Beverage("coffee", 5, 2, 0.5);
		Beverage drink2 = new Beverage("water", 3, 1, 0.5);
		
		Produce prd1 = new Produce("banana",2.5,1.5, "Fruit");
		Produce prd2 = new Produce("carrot",1.3,0.7, "Vegetable");
		Produce prd3 = new Produce("banana",2.5,1.5, "Fruit");
		
		Package pac1 = new  Package("noodles", 4, 3, 3, 3, 2);
		Package pac2 = new  Package("broth", 3, 2, 2, 2, 1);
		
		ShoppingCart cart = new ShoppingCart();
		
		//add items to the cart
		cart.addItem(drink1);
		cart.addItem(drink2);
		cart.addItem(prd1);
		cart.addItem(prd2);
		cart.addItem(prd3);
		cart.addItem(pac1);
		cart.addItem(pac2);
		
		//print everything in the cart
		cart.printCart();
		//compute total price
		System.out.println("Total price is: " + cart.totalCost());
		
		//find cost per unit of all items
		for (int i = 0; i < currentSize; i++) {
			System.out.printf("The cost per unit of " + cart.Cart[i].name +" is %.2f \n",cart.Cart[i].costPerUnit() );
		}
		
		//test numberInCart
		System.out.println("Number of coffe in the cart: " + cart.numberInCart("coffee"));
		System.out.println("Number of bananas in the cart: " + cart.numberInCart("banana"));
		System.out.println("Number of toys in the cart: " + cart.numberInCart("toy"));
		
	}
	

}
