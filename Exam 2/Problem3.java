package codeproblems;

public class Problem3 {

	
	/**
	 * My implementation of binary search with the 
	 * following loop invariant:
	 * left is the index such that for all 
	 * indices i <= left, arr[i] < item
	 * right is the index such that for all
	 * indices j >=right, arr[j] > item.
	 * Thus, left is initialized to -1, 
	 * and right is initialized to  arr.length,
	 * since initially there are no examined elements.
	 * The loop stops as soon as we examine the 
	 * last element when left + 1 = right,
	 * so our loop continues while left+1 < right.
	 * @param arr: array of elements to search. 
	 * @precond: arr is sorted!
	 * @param item: item to find
	 * @return/@postcond: index of element if it is
	 * found/where it would be if it was found in arr 
	 */
	public static int binarySearch(int arr[], int item) {
	   int left = -1;   // left = last of small items
	   int right = arr.length;  //right = first of big items
	   int middle = (left + right+1) / 2;   
	   while (left+1 < right && arr[middle] != item)  {  
		   if (arr[middle] < item) // if item is greater than middle
	         left = middle;       // set new left
		   else
	         right = middle;       // or set a new right
	      middle = (left + right+1) / 2;   //update middle
	   }   //keep going 
	   System.out.println("Index for item "+ item +" is: " + middle); // print index 
	   return middle;  //index of item/index where item would be
	}
	
	
	/**
	 * The following program tests binary search. 
	 * It considers all lists sorted in ascending order
	 * of different length and different "gaps" between
	 * numbers. Binary search successfully finds all
	 * numbers in the list and returns their index.
	 * Then, the program tests searching for numbers
	 * that are not present in the list: number too 
	 * big, too small and of medium values. Binary search 
	 * prints that the item is not found, as expected. 
	 * Thus, i believe the program works as expected
	 */
	public static void main (String args[]) {

		
		System.out.println("Testing ascending numbers, length of the list even");
		int arr[] = {1,3,5,6,7,8,11,14,17,21};
		for(int i: arr) {
			binarySearch(arr,i);
		}

		System.out.println("Testing identical numbers");
		int arr2[] = {1,1,1,1,1,1,1,1};
		for(int i: arr2) {
			binarySearch(arr2,i);
		}
		
		System.out.println("Testing ascending numbers, length of the list odd");
		int arr3[] = {1,2,3,4,5,6,7,8,9,10,11};
		for(int i: arr3) {
			binarySearch(arr3,i);
		}
		
		System.out.println("non existing el-s");
		binarySearch(arr, 100);
		binarySearch(arr, -100);
		binarySearch(arr,15);
		binarySearch(arr,2);
		System.out.println("Done");
	}
}
