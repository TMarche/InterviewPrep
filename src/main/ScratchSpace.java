package main;

public class ScratchSpace {
	
	public static void main(String[] args) {
		char a = 'a';
		Character obj1 = 'c';
		testCharacter(a);
		System.out.println(a);
		testCharacter(obj1);
		System.out.println(obj1);
		
		char x = 'i';
		Character obj2 = 'k';
		testChar(x);
		System.out.println(x);
		testChar(obj2);
		System.out.println(obj2);
		
	}
	
	public static void testCharacter(Character c) {
		c = 'a';
	}
	
	public static void testChar(char c) {
		c = 'a';
	}
	
	int[] test = new int[] {5, 20, 500, 5};
	
	// Start: Sieve of Eratosthenes
	boolean[] sieveOfEratosthenes(int max) {
		boolean[] flags = new boolean[max + 1]; // Max + 1 accounts for 0 index?
		int count = 0;
		
		init(flags); // Set all flags to true other than 0 and 1;
		int prime = 2;
		
		int sqrt = (int) Math.sqrt(max);
		while (prime <= sqrt) {
			/* Cross off remaining multiples of prime */
			crossOff(flags, prime);
			
			/* Find next value which is true */
			prime = getNextPrime(flags, prime);
		}
		
		return flags;
	}
	
	void crossOff(boolean[] flags, int prime) {
		/* Cross off remaining multiples of prime. We can start with (prime*prime)
		 * because if we have a k * prime, where k < prime, this value would have
		 * already been crossed off in a prior iteration */
		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}
	
	int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while (next < flags.length && !flags[next]) {
			next++;
		}
		return next;	
	}
	
	void init(boolean[] flags) {
		if (flags.length <= 2) return;
		for (int i = 2; i < flags.length; i++) {
			flags[i] = true;
		}
	}
	
	
	
	
	// End: Sieve of Eratosthenes
	
	boolean primeSlightlyBetter(int n) {
		if (n < 2) {
			return false;
		}
		
		int sqrt = (int) Math.sqrt(n);
		for (int i = 0; i <= sqrt; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
	
	int binarySearch(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		int mid;
		
		while (low <= high) {
			mid = (low + high) /2;
			if (a[mid] < x) {
				low = mid + 1;
			} else if (a[mid] > x) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1; // Error
	}
	
	int binarySearchRecursive(int[] a, int x, int low, int high) {
		if (low > high) return -1; // Error
		
		int mid = (low + high) / 2;
		if (a[mid] < x) {
			return binarySearchRecursive(a, x, mid + 1, high);
		} else if (a[mid] > x) {
			return binarySearchRecursive(a, x, low, mid -1);
		} else {
			return mid;
		}
	}
	
	void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1) { // Sort left half
			quickSort(arr, left, index - 1);
		}
		if (index < right) { // Sort right half
			quickSort(arr, index, right);
		}
	}
	
	int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) /2]; // Pick pivot point
		while (left <= right ) {
			// Find element on left that should be on right
			while (arr[left] < pivot) left++;
			
			// Find element on right that should be on left
			while (arr[right] > pivot) right--;
			
			// Swap elements, and move left and right indices
			if (left <= right) {
				swap(arr, left, right); // swaps elements
				left++;
				right--;
			}
		}
		return left;
	}
	
	void swap(int[] arr, int left, int right) {
		int buffer = arr[left];
		arr[left] = arr[right];
		arr[right] = buffer;
	}
	
	void mergeSort(int[] array) {
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
	}
	
	void mergeSort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) /2;
			mergeSort(array, helper, low, middle); // Sort left half
			mergeSort(array, helper, middle+1, high); // Sort right half
			merge(array, helper, low, middle, high); // Merge them
		}
	}
	
	void merge (int[] array, int[] helper, int low, int middle, int high) {
		/* Copy both halves into a helper array */
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		/* Iterate through helper array. Compare the left and right half, copying back
		 * the smaller element from the two halves into the original array */
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // If right element is smaller than left element
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		/* Copy the rest of the left side of the array into the target array */
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}
}