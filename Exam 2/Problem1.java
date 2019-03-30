package codeproblems;

/**
 * Solution to problem 1 of exam 2.
 */
public class Problem1 {

	/**
	 * My implementation of partition.
	 * Selects the element with index left as pivot,
	 * iterates through the array to establish and maintain 
	 * the following loop invariant: all elements between 
	 * left and l_spot are less than element left, all 
	 * elements between r_spot and right are greater than 
	 * element left. In the end, the pivot is placed so that
	 * all el-s on the left of it in the array are smaller, and all
	 * elements on the right are greater than the pivot.
	 * @param arr: array of integers to be partitioned
	 * @param left: smallest index in the part of the 
	 * array to be examined.
	 * @param right: largest index in the part of the 
	 * array to be examined.
	 * @precond: arr is an initialized array
	 * @postcond: el-s of arr are reordered so that the first element
	 * is at the position where all el-s on the left are smaller
	 * and all el-s on the right are greater than this pivot
	 */
	public static void partition(int arr[], int left, int right) {
		
		int pivot = arr[left];
		int l_spot = left;  //l_spot = last element of those <= pivot
		int r_spot = right+1; //r_spot = first element of those => pivot
		int temp;
		
		while (l_spot+1 < r_spot) {
		
			//search right side to find smaller item
		 while ((r_spot > l_spot+1) && (pivot <= arr[r_spot-1]))
	            r_spot--;
	        // search left side to find larger array item
	     while ((r_spot > l_spot+1) && (pivot >= arr[l_spot+1]))
	            l_spot++;
	        // swap large left item and small right item, if needed
	        if (r_spot > l_spot+1)  {
	            temp = arr[l_spot+1];
	            arr[l_spot+1] = arr[r_spot-1];
	            arr[r_spot-1] = temp;
	            l_spot += 1;
	            r_spot -=1;
	            
	        }
		}
		//place the pivot to its right place
	    temp = pivot;
	    arr[left] = arr[l_spot];
	    arr[l_spot] = temp;
	}
	
	/**
	 * Testing my partition. The examples below 
	 * consider lists of random numbers, 
	 * numbers in ascending order, numbers 
	 * in descending order, 
	 * repeating numbers, and partly sorted numbers. This 
	 * is supposed to emulate lists a quicksort would be used
	 * to sort. In all cases, partition yields the correct result,
	 * and maintains the correct loop invariant without redundant
	 * iterations (checked with the debuger).
	 * Therefore, I believe the function works as intended.
	 * 
	 */
	public static void main (String args[]) {
		System.out.println("Decending numbers test");
		// we expect list: {1,8,7,6,5,4,3,2,9}
		int arr3[] = {9,8,7,6,5,4,3,2,1};
		partition(arr3,0,arr3.length-1);
		for (int i: arr3) {
			System.out.println(i);
		}
		
		System.out.println("Random numbers test");
		// we expect: {0,4,2,1,6,7,9,13,8}
		int arr1[] = {7,4,2,1,8,9,0,13,6};
		partition(arr1,0,arr1.length-1);
		for (int i: arr1) {
			System.out.println(i);
		}
		System.out.println("Ascending numbers test");
		// we expect: {1,2,3,4,5,6,7,8}
		int arr2[] = {1,2,3,4,5,6,7,8};
		partition(arr1,0,arr1.length-1);
		for (int i: arr2) {
			System.out.println(i);
		}
		
		System.out.println("Repeating numbers test");
		//we expect: {3,3,2,3,3,3,2,5,5}
		int arr4[] = {5,3,2,3,3,3,2,3,5};
		partition(arr4,0,arr4.length-1);
		for (int i: arr4) {
			System.out.println(i);
		}
		
		System.out.println("Almost sorted numbers test");
		//we expect: {4,1,2,3,5,6,7,8,9}
		int arr5[] = {5,1,2,3,4,6,7,8,9};
		partition(arr5,0,arr5.length-1);
		for (int i: arr5) {
			System.out.println(i);
		}
	}
}




