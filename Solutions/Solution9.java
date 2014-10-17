/**
 * Merge Two Sorted Array
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * @author huangxin
 *
 */

public class Solution9 {
    public static int[] merge_1(int A[], int m, int B[], int n) {  	
        int[] result = new int[m + n];
        int i = 0; 
        int j = 0;
        int k = 0;
        
        while (i < m && j < n){
            if (A[i] < B[j]) {
                result[k] = A[i];
                i++;
                k++;
            } else {
                result[k] = B[j];
                j++;
                k++;
            }
        }
        
        while (j < n) {
            result[k] = B[j];
            k++;
            j++;
        }
        
        while (i < m) {
            result[k] = A[i];
            k++;
            i++;
        }
        A = new int[result.length];
        System.out.println(A.hashCode());
        System.arraycopy(result, 0, A, 0, result.length);
        return result;
    }
    
    static void printArray(int[] array) {
    	if (array.length == 0) {
    		System.out.println("Empty Arraty");
    		return;
    	}
    	
    	for (int i = 0; i < array.length; i++) {
    		System.out.print(array[i] + " ");
    	}
    	System.out.println();
    }
    
    public static void merge(int[] A, int m, int[] B, int n) {
    	int indexA = m - 1;
    	int indexB = n - 1;
    	int index = indexA + indexB + 1;
    	
    	while (indexA >= 0 && indexB >= 0) {
    		if (A[indexA] > B[indexB]) {
    			A[index--] = A[indexA--];
    		} else {
    			A[index--] = B[indexB--];
    		}
    	}
    	
    	while (indexA >= 0) {
    		A[index--] = A[indexA--];
    	}
    	
    	while (indexB>= 0) {
    		A[index--] = B[indexB--];
    	}
    }
    
    
    
    public static void main(String[] args) {
    	int[] a = new int[3];
    	a[0] = 2;
    	a[1] = 3;
    	int[] b = {1};
    	printArray(a);
    	printArray(b);
    	merge(a, 2, b, 1);
    	printArray(a);
    	
    }
    
}