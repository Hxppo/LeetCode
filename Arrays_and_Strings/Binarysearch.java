package Arrays_and_Strings;

public class Binarysearch {
	public int binarySearch_iterative(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public int findPivot(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (arr[mid] > arr[high]) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	public int binarySearch(int[] array, int target) {
		return binarySearchHelper(array, 0, array.length - 1, target);
	}

	public int binarySearchHelper(int[] array, int low, int high, int target) {
		if(low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if(array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				return binarySearchHelper(array, low, mid - 1, target);
			} else {
				return binarySearchHelper(array, mid + 1, high, target);
			}
		}
	}
	
	public static void main(String[] args) {
	      Binarysearch bin =
	         new Binarysearch();
	      int[] a =
	        { 2, 8,12,14,16,19,24,28,31,33,// 0-9
	         39,40,45,49,51,53,54,56,57,60,// 10-19
	         63,69,77,82,88,89,94,96,97};  // 20-28
	      for (int i = 0; i < a.length; i++)
	         System.out.print(bin.binarySearch(a,
	            a[i]) + " ");
	      System.out.println();
	      System.out.print(bin.binarySearch(a,2) +" ");
	      System.out.print(bin.binarySearch(a,26)+" ");
	      System.out.print(bin.binarySearch(a,85)+" ");
	      System.out.print(bin.binarySearch(a,99)+" ");
	      System.out.println();
	   }
}
