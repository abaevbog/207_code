package boxing;

public class Test1b {

	Integer int1 = 3;
	static Integer int2 = 8;
	
	public Test1b() {
		int1 +=7;
		int2 +=int1;
	}
	public String toString() {
		return "int1: " + int1 +", int2: " + int2;
	}
	public static void main(String args[]) {
		Test1b first = new Test1b();
		Test1b second = new Test1b();
		System.out.println("first: "+first);
		System.out.println("second: " + second);
		
	}
}
