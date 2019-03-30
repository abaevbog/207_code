package code;

public class StudentNode {

    private String username;  //always stored in lowercase
    private double credits;   //credits toward graduation
    private StudentNode left;             //pointer to left subtree within a tree structure
    private StudentNode right;            //pointer to right subtree within a tree structure
    private StudentNode next;             //pointer to next node in singly-linked list
	
    StudentNode(String username, double credits){
    	this.username = username;
    	this.credits = credits;
    }

    
    /**
     * Getters and setters for the fields
     * of the class
     */
    
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public StudentNode getLeft() {
		return left;
	}

	public void setLeft(StudentNode left) {
		this.left = left;
	}

	public StudentNode getRight() {
		return right;
	}

	public void setRight(StudentNode right) {
		this.right = right;
	}

	public StudentNode getNext() {
		return next;
	}

	public void setNext(StudentNode next) {
		this.next = next;
	}
	public int compareTo(String name) {
		return (this.username.compareTo(name));
	}
	
	// pretty printing
	 public String toString() {
		 return "Username: " + username + "\n"
				 + "Credits: " + credits +"\n";
	 }
	
    
}
