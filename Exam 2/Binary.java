package codeproblems;

public class Binary {
	
	public static int binarySearch(int a[], int item) {
	
	   int left = 0;
	   int right = a.length;
	   int middle = (left + right) / 2;  /* rounding does not matter here, so we round down for simplicity */
	   while (left < right) {
		   if (a[middle] == item) {
			   System.out.println("Item " + item + " found under index " + middle);
			   return middle;
		   }
	      if (a[middle] < item) 
	         left = middle + 1;
	      else
	         right = middle;
	      middle = (left + right) / 2;
	   }
	   return -1;
	}
	
	public static void main (String args[]) {
		
		System.out.println("Testing descending numbers");
		int arr2[] = {30,29,24,20,17,16,14,9,5};
		for(int i: arr2) {
			binarySearch(arr2,i);
		}
		
		System.out.println("Testing ascending numbers");
		int arr[] = {1,3,5,6,7,8,11,14,17,21};
		for(int i: arr) {
			binarySearch(arr,i);
		}

		
		System.out.println("Testing random numbers");
		int arr3[] = {5,3,7,9,12,65,21,1,4};
		for(int i: arr3) {
			binarySearch(arr3,i);
		}
		
		binarySearch(arr, 100);
		binarySearch(arr, -100);
		binarySearch(arr2,15);
		binarySearch(arr3,2);
	}
}
