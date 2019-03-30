package shopping;
/**
 * 
 * @author bogdanabaev
 *	Class Package
 *	Subclass of Item
 */
public class Package extends Item {

	private int length;
	private int  width;
	private int height;
	private int ounces;
	
	
	/**
	 * 
	 * @param thing Name of item
	 * @param price Cost of item
	 * @param len Length of package
	 * @param wdth Width of package
	 * @param hight Height of package
	 * @param weight Weight of package
	 */
	public Package(String thing, double price, int len, int wdth, int hight, int weight) {
		super(thing, price);
		length = len;
		width = wdth;
		height = hight;
		ounces = weight;
	}
	/**
	 * Pretty printing
	 */
	public String toString() {
		return super.toString() +
				"Ounces " + ounces +
				"\nSize parameters: length "+ length + ", width: " + width +
				", height: " + height+"\n" ;
	}
	public static void main(String args[]) {
		System.out.println("Testing Package class");
		
		Package pac1 = new Package("firstPackage", 2.5, 2,3,2,5);
		Package pac2 = new Package("secondPackage", 1.6, 3,2,3,2);
		Package pac3 = new Package("thirdPackage", 3.3, 1,3,4,3);
		

		System.out.println(pac1);
		System.out.println(pac2);
		System.out.println(pac3);
	}
	
}
