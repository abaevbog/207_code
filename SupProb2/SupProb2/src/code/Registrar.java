package code;

public class Registrar {

	StudentNode root;
	StudentNode first;
	
	Registrar(){
		this.root = null;
		this.first = null;
	}
	
	/**
	 * Inserts the entry with given username and
	 * credits into the registrar
	 * @param username
	 * @param credits
	 */
	public void insert(String username,double credits) {
		StudentNode entry = new StudentNode(username,credits);
		insertTree(entry);
		insertList(entry);
	}
	
	/**
	 * Inserts a given entry into the 
	 * tree of a registrar tree, so that the
	 * order of a binary search tree
	 * is preserved.
	 * @param entry
	 */
	 public void insertTree (StudentNode entry) {
		 if (root == null) {
			 root = entry;
		 } else {
			 StudentNode ptr = root;
			 while (ptr != null) {
				 if (entry.compareTo(ptr.getUsername()) < 0) {
					 if (ptr.getLeft() == null) {
						 ptr.setLeft(entry);
						 return;
					 } else {
						 ptr = ptr.getLeft();
					 }
				 } else {
					 if (ptr.getRight() == null) {
						 ptr.setRight(entry);
						 return;
					 } else {
						 ptr = ptr.getRight();
					 }
				 }
			 }
		 }
		 
	 }
	 
	 /**
	  * Inserts a given entry into the registrar
	  * linked list so that the linked list
	  * remains sorted in ascending order
	  * by credits.
	  * @param entry
	  */
	 public void insertList(StudentNode entry) {
		 if (first == null) {
			 first = entry;
			 entry.setNext(null);
		 } else {
			 StudentNode ptrThis = first;
			 StudentNode ptrNext = first;
		     while (ptrNext != null ) {
			 if (ptrNext.getCredits() <= entry.getCredits()) {
				 ptrThis = ptrNext;
				 ptrNext = ptrNext.getNext();
			 } else {
				 if (ptrNext == first){
			 
				 entry.setNext(ptrNext);
				 first = entry;
				 return;	 
				 } else {
				 entry.setNext(ptrNext);
				 ptrThis.setNext(entry);
				 return;
				 }
			  }
		    }
		     entry.setNext(null);
		     ptrThis.setNext(entry);
		     
		 }
	 }
		     
	 
	 /**
	  * Finds the credits of a person with 
	  * a given username through binary search
	  * tree.
	  * @param username whose credits are needed
	  * @return -1 if username is not in
	  * registrar or credits of the given username
	  */
	 public double findCredits (String username) {
		 if (root == null) {
			 return -1;
		 } else {
			 StudentNode ptr = root;
			 while (ptr != null) {
				 if (ptr.getUsername() == username) {
					 System.out.println("Credits of " + username + "= " +ptr.getCredits() );
					 return ptr.getCredits();
				 }
				 if (ptr.getUsername().compareTo(username) > 0) {
					 if (ptr.getLeft() == null) {
						 return -1;
					 } else {
						 ptr = ptr.getLeft();
					 }
				 } else {
					 if (ptr.getRight() == null) {
						 return -1;
					 } else {
						 ptr=ptr.getRight();
					 }
				 }
				 
			 }
		 }
		 return -1;
	 }
	 /**
	  * Updates the credits of username with newCredits.
	  * After entry is found and credits are updated, 
	  * it is removed from the linked list and
	  * inserted again. 
	  * @param username: username whose credits are updated
	  * @param newCredits: new values of credits
	  * @return true if update was successful/ false if
	  * username is not in registrar.
	  */
	 public boolean updateCredits (String username, double newCredits) {
		 StudentNode ptr;
		 if (root == null) {
			 return false;
		 } else {
			 ptr = root;
			 while (ptr != null) {
				 if (ptr.getUsername() == username) {
	
					 ptr.setCredits(newCredits);
					 break;
				 } else if (ptr.getUsername().compareTo(username) >= 0) {
					 if (ptr.getLeft() == null) {
						 return false;
					 } else {
						 ptr = ptr.getLeft();
					 }
				 } else {
					 if (ptr.getRight() == null) {
						 return false;
					 } else {
						 ptr=ptr.getRight();
					 }
				 }
				 
			 }
		 }
		 updateLinkedListLocation(ptr);
		 return true;
	 }
	 
	 
	 /**
	  * Updates the location of entry in the linked list.
	  * Since we do not know the value of updated 
	  * credits (it could be greater than or smaller 
	  * than old value due to different circumstances),
	  * to find the new position in the linked list, 
	  * the entry is removed from the linked list and
	  * inserted again.
	  * @param entry
	  */
	 public void updateLinkedListLocation(StudentNode entry) {
		 StudentNode ptrThis = first;
		 StudentNode ptrNext = first;
		 
	     while (ptrNext != null ) {
		 if (ptrNext.getUsername() != entry.getUsername()) {
			 ptrThis = ptrNext;
			 ptrNext = ptrNext.getNext();
		 } else {
			 ptrThis.setNext(ptrNext.getNext());
			 entry.setNext(null);
			 insertList(entry);
			 return;
		 }
	 }
		 
		 
	 }
	 

	 /**
	  * Prints all entries in the registrar
	  * in ascending order of usernames.
	  * This happens by following the tree.
	  */
    public void printByUsername () {
        System.out.println ("Registrar listing by username");
        printKernelUsername (root);
        System.out.println ();
        System.out.println ("End of Listing");
    }

    private void printKernelUsername (StudentNode base) {
        if (base != null) {
            printKernelUsername (base.getLeft());
            System.out.println(base);
            printKernelUsername (base.getRight());
        }
    }
    
    /**
     * Print all entries of the registrar in 
     * ascedning order of credits. This 
     * happens by following the linked list.
     */
    public void printByCredits() {
    	StudentNode ptr = first;
    	System.out.println ("Registrar listing by credits");
    	while (ptr != null) {
    		System.out.println(ptr);
    		ptr = ptr.getNext();
    	}
    	System.out.println ("End of Listing");
    }
	 
    
    /**
     * Testing
     */
    public static void main (String args[]) {
    	Registrar reg = new Registrar();
    	
    	reg.insert("firstUser", 20);
    	reg.insert("secondUser", 18);
    	reg.insert("thirdUser", 25);
    	reg.insert("fourthUser", 30);
    	reg.insert("lastUser", 22);
    
    	
    	reg.printByUsername();
    	reg.printByCredits();
    	
    	reg.updateCredits("firstUser", 30);
    	reg.updateCredits("fourthUser", 23);
    	reg.updateCredits("lastUser", 20);
    	
    	System.out.println("Nonexisting user updated?: " + reg.updateCredits("NoSuchUser", 30));
    	System.out.println("Nonexisting user's credits found?: " + reg.findCredits("NoSuchUser"));
    	
    	reg.findCredits("thirdUser");
    	reg.findCredits("lastUser");
    	reg.printByCredits();
    }
	 
	 
	 
}
