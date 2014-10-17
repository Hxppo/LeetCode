/**
 * Next Permutation
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @author huangxin
 *
 */
public class Solution83 {
    private void swap(int[] num, int index1, int index2) {
		int temp = num[index1];
		num[index1] = num[index2];
		num[index2] = temp;
	}

	private void reverse(int[] num, int start, int end) {
		while (start < end) {
			swap(num, start++, end--);
		}
	}

	public void nextPermutation(int[] num) {
		// Special case
		if(num.length <= 1){  
            return;  
        } 

		// Find the partitionIndex
		int partitionIndex = -1;
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i + 1] > num[i]) {
				partitionIndex = i;
				break;
			}
		}

		// Find the changeIndex
		// Do not forget weather if all permutations are traverse
		if (partitionIndex >= 0) {
            int changeIndex = 0;
    		for (int i = num.length - 1; i > partitionIndex; i--) {
    			if (num[i] > num[partitionIndex]) {
    				changeIndex = i;
    				break;
    			}
    		}
    		// Swap partitionIndex and changeIndex
    		swap(num, partitionIndex, changeIndex);
		}
		// reverse all the element since changeIndex
		reverse(num, partitionIndex + 1, num.length - 1);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 2};
		Solution83 test = new Solution83();	
		test.nextPermutation(array);
		System.out.println(array);
	}
}
