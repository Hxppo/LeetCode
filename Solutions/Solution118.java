/**
 * Add Binary
 * 
 * Given two binary strings, return their sum (also a binary string).
 * @author huangxin
 *
 */

public class Solution118 {
	public static String addBinary(String a, String b) {
		StringBuilder buffer = new StringBuilder();
		
		int cin = 0;
		int pointer1 = a.length() - 1;
		int pointer2 = b.length() - 1;
			
		while (pointer1 >= 0 && pointer2 >= 0) {
			int digit1 = Integer.parseInt(a.substring(pointer1, pointer1 + 1));
			int digit2 = Integer.parseInt(b.substring(pointer2, pointer2 + 1));
			int resDigit = digit1 ^ digit2 ^ cin;
			cin = (digit1 & digit2) | (digit1 & cin) | (digit2 & cin) ;
			
			buffer.append(String.valueOf(resDigit));
			pointer1--;
			pointer2--;
		}
		
		// check if we have finished
		if (pointer1 >= 0) {
			while (pointer1 >= 0) {
				int digit1 = Integer.parseInt(a.substring(pointer1, pointer1 + 1));
				int resDigit = digit1 ^ cin;
				cin = digit1 & cin;
				
				buffer.append(String.valueOf(resDigit));
				pointer1--;
			}
		}
		
		if (pointer2 >= 0) {
			while (pointer2 >= 0) {
				int digit2 = Integer.parseInt(b.substring(pointer2, pointer2 + 1));
				int resDigit = digit2 ^ cin;
				cin = digit2 & cin;
				
				buffer.append(String.valueOf(resDigit));
				pointer2--;
			}
		}
		
		if (cin != 0) {
			buffer.append("1");
		}
		
		buffer.reverse();
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(addBinary("1", "111"));
	}
}
