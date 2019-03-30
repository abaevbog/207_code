package myArrayList;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.ConcurrentModificationException;
/** 
 * re-implementation of an ArrayList  
 * @author walker
 */
public class MyArrayList <E>  implements Iterable<E>{
	
	private int modCount;
   private E myArray [];
    private int numStored;  // the number of items actually stored in myArray
 
      /***
       * the default constructor
       */
    /* Aside:  The compiler should allocate an initial array of type E
       in the constructor.  However, the compiler cannot know the
       the nature of E objects, so it cannot check what will actually
       be placed in the array, and this generates an error.
       Java's solution is to create an array of Objects rather than
       than array of class E items.  However, Java raises a concern that
       actual objects may not be of type E, and thus the compiler
       raises an "unchecked" warning.
       the following line supresses this warning
    */ 
    @SuppressWarnings({"unchecked"})
    public MyArrayList ()
	{
        // initially, the internal array has room for 10 items,
        // but no items have actually been inserted
        myArray = (E[]) new Object [10];
        numStored = 0;
        modCount =0;
	}
    
    public void add (E e)
    {
       // check if myArray must be expanded
       if (numStored == myArray.length)
          {
              /* the following code follows approach A in the lab */
             E newArray [] = (E[]) new Object [myArray.length*2];
             for (int i = 0; i < numStored; i++)
                 newArray[i] = myArray[i];
             myArray = newArray; 
          }

    // insert the given element into myArray
    myArray[numStored] = e;
    numStored++;
    modCount++;
    }
    /**
     * Function to add an item to array at
     * a specified index 
     * @param index: index to insert element to
     * @param e: element to be inserted
     */
    public void add (int index, E e) {
    	// create new array if needed
    	if (numStored == myArray.length) {	
			E newArray [] = (E[]) new Object [myArray.length*2];
			//copy el-s before index
			for (int i = 0; i < index; i++) 
				newArray[i] = myArray[i];
			//insert new element
			newArray[index] = e;
			//copy the rest of elements
			for (int i = index; i < numStored; i++) 
				newArray[i+1] = myArray[i];
			myArray = newArray;
    	} else {
    		// shift all elements after index to the right
    		for (int i = numStored-1; i >=index; i--) 
    			myArray[i+1] = myArray[i];
    		//insert element
    		myArray[index] = e;
    	}
    	numStored++;
    	modCount++;
    }
    
    public E remove (int index) {
    	//check if index is within bounds
        if (myArray.length <= index)
        	throw new ArrayIndexOutOfBoundsException();
        
        E oldValue = myArray[index];
        
        // find where elements to copy begin
        int rightSide = myArray.length - index - 1;
        if (rightSide > 0)
        	//shift elements after index to the lef
        	for (int i = index; i < myArray.length - 1; i ++) {
        		myArray[i] = myArray[i+1];
        	}
        //nullify last element
        myArray[myArray.length-1] = null; // clear to let GC do its work
        numStored--;
        modCount++;
        return oldValue;
    }
    
    E get (int index)
    {
    	return myArray[index];
    }
    
    public void print ()
    {
    	System.out.println ("Listing of array elements");
    	int i;
    	/*
    	 * only cycle through array elements with stored data 
    	 */
    	for (i = 0; i < numStored; i++)
    	{
    		System.out.println ("\t" + myArray[i]);
    	}
    	System.out.println ("End of listing");
   	
    }
    
	// Iterator material starts here
	public Iterator<E> iterator() {
	    return new MyArrayListIterator ();
	}
	/**
	 * our implementation of the iterator 
	 */
	private class MyArrayListIterator implements Iterator<E> {
		public int count;
		public int lastRet;
		//expectedModCount is the expected number of
		//modifications
		int expectedModCount = modCount;
		
		public MyArrayListIterator() {
			count = 0;
			lastRet = -1;
		}
		
		@Override
		public boolean hasNext() {
			return count < numStored;
		}

		@Override
		public E next() {
			// if count is too big, throw exception
			if(count >= numStored){
				throw new NoSuchElementException();
			}
			//if count is too big or modCount doesn't match what's expected
			// throw exception
			if (count >= myArray.length || modCount != expectedModCount)
				throw new ConcurrentModificationException();
			lastRet = count++;
			return (E) myArray[count];
		}
         
		
        public void remove() {
        	//if there's no elements left, throw exception
            if (lastRet < 0)
                throw new IllegalStateException();
            // check for concurrent modification
            if (expectedModCount != modCount)
            	throw new ConcurrentModificationException();
            try {
            	MyArrayList.this.remove(lastRet);
                count = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
		
		
	}

    public static void main (String args [])
    {
      	MyArrayList <Integer> intArr = new MyArrayList <Integer>();
      	MyArrayList <String> strArr = new MyArrayList <String>();
          	
      	/*
      	 * test of constructor
      	 */
      	System.out.println ("Initialized array lists");
      	System.out.print("Integer:  ");
      	intArr.print();
      	System.out.print("String:  ");
      	strArr.print();
      	
      	/*
      	 * add some items to array list
      	 */
     	for (int i = 1; i <= 22; i++)
      		intArr.add(i);

      	/*
      	 * check contents of array list
      	 */
      	strArr.add("a");
      	strArr.add("bc");
      	strArr.add("def");
      	strArr.add("ghij");
      	strArr.add("klmno");
      	
      	System.out.println ("Array lists with 22 and 5 items, respectively");
      	System.out.print("Integer:  ");
      	intArr.print();
      	System.out.print("String:  ");
      	strArr.print();
      
      	/*
      	 * check iterator construction and use
      	 */
   
      	System.out.println ("print integer data via iterator");
      	for (Integer intItem: intArr)
      	{
      		System.out.println ("\t" + intItem);
      	}
      	
      	System.out.println ("print String data via iterator");
      	for (String strItem: strArr)
      	{
      		System.out.println ("\t" + strItem);
      	}
      	
      	intArr.remove(5);
      	intArr.remove(10);
      	intArr.remove(15);
      	System.out.println ("print integer data after deletions");
      	intArr.print();
      	
      	strArr.remove(2);
      	strArr.remove(2);
      	System.out.println ("print string data after deletions");
      	strArr.print();
      	
    }	
}	