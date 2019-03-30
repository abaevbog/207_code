package codeproblems;
/*****************************************************************
 *Bogdan Abaev                                              *
 * PO Box 3003                                           *
 * Program for CSC 207                                           *
 *   Exam2 problem 2                                    *
 * Assignment for November 14                           *
 *****************************************************************/


/* ***************************************************************
 * Academic honesty certification:                               *
 *   Written/online sources used:                                *
 *     none                       *
 *   Help obtained                                               *
 *     none            *
 *   My signature below confirms that the above list of sources  *
 *   is complete AND that I have not talked to anyone else       *
 *   [e.g., CSC 161 students] about the solution to this problem *
 *                                                               *
 *   Signature:                                                  *
 *****************************************************************/


import codeproblems.Entry;
import codeproblems.Student;
import codeproblems.Faculty;

import java.lang.invoke.MethodHandles.Lookup;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SchoolDirectoryAlt<e> implements Iterable<Entry> {

    private int maxSize;
    private int currentSize;
    private Entry [] entryArray;

    SchoolDirectoryAlt () {
        maxSize = 4;  // initial maximum
        currentSize = 0;
        entryArray = new Entry[maxSize];
    }

    public void add (Entry person) {
        // check if room in array, and double array size if needed
        if (currentSize == maxSize) {
            maxSize = 2*maxSize; 
            Entry [] temp = new Entry[maxSize];
            for (int i = 0; i < currentSize; i++)
                temp[i] = entryArray[i];
            entryArray = temp;  // update entryArray to the new, larger array
        }

        // add person to array, maintaining alphabetical order
        int i = currentSize;
        while (i > 0 && person.comesBefore(entryArray[i-1])) {
            entryArray[i] = entryArray[i-1];
            i--;
        }
        entryArray[i] = person;
        currentSize++;
    }

    public void print () {
        System.out.println ("Directory Listing");
        for (int i = 0; i < currentSize; i++) 
            System.out.print(entryArray[i]);
        System.out.println ("End of Listing");
    }

    public Entry lookup (String first, String second) {
        int lo = 0;
        int hi = currentSize;
        int mid = (hi + lo)/2;

        while (lo < hi) {
            if (entryArray[mid].equals(first, second))
                return entryArray[mid];
            if (entryArray[mid].comesBefore(first, second))
                lo = mid + 1;
            else hi = mid;
            mid = (hi + lo)/2;
        }
        // if person not found, generate an exception
        throw new NoSuchElementException(); 
    }
    
    
//////////////////////////////////////////////////
// Exam2 work starts here //////////
    /**
     * Helper function that finds the index of the item 
     * to be removed
     * @param first first name of the person
     * @param last last name of the person
     * @return index of the element
     * @throws NoSuchElementException if person not found
     */
    public int lookupOfIndex (String first, String last) {
        int lo = 0;
        int hi = currentSize;
        int mid = (hi + lo)/2;

        while (lo < hi) {
            if (entryArray[mid].equals(first, last))
                return mid;
            if (entryArray[mid].comesBefore(first, last))
                lo = mid + 1;
            else hi = mid;
            mid = (hi + lo)/2;
        }
        // if person not found, generate an exception
        throw new NoSuchElementException(); 
    }
    
    /**
     * Class Function to remove person from directory 
     * @param first first name of the person
     * @param last last name of the person
     * @return removed entry
     * @throws ArrayIndexOutOfBoundsException if element
     * is not found
     */
    public Entry remove (String first, String last) {
    	//check if index is within bounds
    	try {
	    	int index = lookupOfIndex(first,last);
	    	
	        if (entryArray.length <= index)
	        	throw new ArrayIndexOutOfBoundsException();
	        
	        Entry oldValue = entryArray[index];
	        
	        // find where elements where copying begins
	        int rightSide = entryArray.length - index - 1;
	        if (rightSide > 0)
	        	//shift elements after index to the lef
	        	for (int i = index; i < entryArray.length - 1; i ++) {
	        		entryArray[i] = entryArray[i+1];
	        	}
	        //nullify last element
	        entryArray[entryArray.length-1] = null; 
	        currentSize--;
	        return oldValue;
    	} catch (NoSuchElementException e ) {
    		System.out.println("Element is not in the directory");
    	}
    	return null;
    }
    
    
    /**
     * @return iterator for the school directory
     */
    public Iterator<Entry> iterator() {
		return new LocalIterator ();
	}
    
    /**
     * Class implementing the Iterator interface
     */
	private class LocalIterator implements Iterator<Entry> {
		
		private int count;  // index of currently examined element
		public int lastRet;  //last returned element
		
		public LocalIterator () {
			count=0;
			lastRet = -1;
		}

		/**
		 * Check if there is an element whose 
		 * lengths of first and last names together 
		 * are less than email length - 5.
		 * @return true if there is such element or
		 * false if there is no such element after
		 * the current one
		 */
		public boolean hasNext() {
			boolean found = false;
				for (int i = count; i <currentSize;i++) {
					if (entryArray[i].firstName.length()
							+ entryArray[i].lastName.length()
							+ 5 < entryArray[i].eMail.length()){
								found = true;
							}
				}
			return found;
		}
		 
		/**
		 * @return the next element such that the length of its
		 * first and last names + 5 are less than length of
		 * the email
		 */
		public Entry next() {
			if(count >= currentSize){
				throw new NoSuchElementException();
			}
			count++;
			while (entryArray[count-1].firstName.length()
					+ entryArray[count-1].lastName.length()
					+ 5 >= entryArray[count-1].eMail.length()) {
			
				count++;
			}
			lastRet = count-1;
			return  entryArray[lastRet];
		}	


		/**
		 * Iterator's implementation of remove.
		 * Removes the current element from the list.
		 * @throws IllealStateException is there is no current
		 * element
		 */
        public void remove() {
        	//if there's no elements left, throw exception
            if (lastRet < 0)
                throw new IllegalStateException();
            	Entry person = entryArray[lastRet];
            	SchoolDirectoryAlt.this.remove(person.firstName, person.lastName);
                count = lastRet;
                lastRet = -1;
        }
//////////////////////////////////////////////////
//Exam2 work ends here //////////
		// method added per Forum's discussion
		public void reset() {
			count = 0;
		}
		
	}
	//////////////////////////////////////////////////
    public static void main (String [] argv) {
        // test of various methods
        // constructors
        SchoolDirectoryAlt<Entry> dir = new SchoolDirectoryAlt<Entry>();

        Student stu1 = new Student("Terry", "Walker", "walkert@math.grinnell.edu",
                                   1970, "off-campus");
        Student stu2 = new Student("Barbara", "Ellen", "barbara@cs.grinnell.edu",
                                   2002, "12-34-56");
        Student stu3 = new Student("Donna", "Marie", "donna@math.grinnell.edu",
                                   1998, "3.1415926535");
        Student stu4 = new Student("Shamrock", "The Cat", "none",
                                   3000, "varies");
        Student stu5 = new Student("Muffin", "The Cat", "none",
                                   3000, "varies");

        Faculty fac1 = new Faculty("John", "Stone", "stone@math.grinnell.edu",
                                 "Science 2418", 3181,
                                 "Mathematics and Computer Science", 1983);
        Faculty fac2 = new Faculty("Henry", "Walker", "walker@cs.grinnell.edu",
                                 "Science 2420", 4208, 
                                 "Mathematics and Computer Science", 1973);
        Faculty fac3 = new Faculty("Janet", "Gibson", "gibson@grinnell.edu",
                                 "Science 0420", 3168,
                                 "Psychology", 1989);
        Faculty fac4 = new Faculty("Samuel", "Rebelsky","rebelsky@cs.grinnell.edu",
                                 "Science 2427", 4410,
                                 "Mathematics and Computer Science", 1997);

        // add entries to directory
        dir.add(stu1);
        dir.add(fac1);
        dir.add(stu2);
        dir.add(fac2);
        dir.add(stu3);
        dir.add(fac3);
        dir.add(stu4);
        dir.add(fac4);
        dir.add(stu5);
        dir.remove(stu5.firstName, stu5.lastName);
        dir.remove(stu5.firstName, stu5.lastName);
        // print directory
        

        System.out.println("Iterate");
        
        Iterator itr = dir.iterator();
        
        while (itr.hasNext()) {
        	Entry ent = (Entry) itr.next();
        	System.out.println(ent.firstName + " " + ent.lastName);
        	if (ent.firstName == "Terry") {
        		itr.remove();
        		System.out.println("Terry removed");
        	}
        	//System.out.println(ent);
        	
        }
        System.out.println("done");
        dir.print();
        // check lookup
        Entry ent;
        try {
            System.out.println ("\nSearching for Barbara Ellen -- first entry");
            ent = dir.lookup("Barbara", "Ellen");
            System.out.print(ent);

            System.out.println ("\nSearching for Terry Walker -- last entry");
            ent = dir.lookup("Terry", "Walker");
            System.out.print(ent);

            System.out.println ("\nSearching for Muffin, The Cat");
            ent = dir.lookup("Muffin", "The Cat");
            System.out.print(ent);

            System.out.println ("\nSearching for Muffin, The Dog");
            ent = dir.lookup("Muffin", "The Dog");
            System.out.print(ent);
        } catch 
            (NoSuchElementException e) {
                System.out.println("Directory Entry not found:  ");
                System.out.println("   Exception caught:  " + e);
        }
    }


}