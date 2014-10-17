/**
 * Palindrome Number 
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer"
 * , you know that the reversed integer might overflow. 
 * How would you handle such case?
 * There is a more generic way of solving this problem.
 * 
 * @author huangxin
 *
 */
public class Solution61 {
	/*
	 * 解题思路：从整数的头和尾开始扫描，检查数字是否相同
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	
	public static boolean isPalindrome(int x) {
		//If a number is negative, then it is not 
		if (x < 0) {
			return false;
		}
		//找到取最高位所需要的除数的大小
		int div = 10;
		while (x / div >= 10) {
			div *= 10;
		}
		//小于10的正整数都是回文的
		while(x >= 10){
			int ld = x / div;
			int rd = x % 10;
			if(ld != rd) {
				return false;
			}
			//去除最高、最低位
			x = (x % div) / 10;
			div  /= 100;	//调整除数的大小
		}
		return true;
    }
	
	public static void main(String[] args) {
		System.out.print(isPalindrome(121));
	}
}
