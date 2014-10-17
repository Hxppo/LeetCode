/**
 * Multiply Strings
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 */
public class Solution134 {
	public static String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		
		if (num1.equals("0") || num2.equals("0")) return "0";
		
		int[] number1 = new int[len1];
		int[] number2 = new int[len2];
		for (int i = 0; i < len1; i++) {
			number1[i] = Integer.parseInt(num1.substring(i, i + 1));
		}
		for (int i = 0; i < len2; i++) {
			number2[i] = Integer.parseInt(num2.substring(i, i + 1));
		}
		
		// define result array
		int[] resArray = new int[len1 + len2];
		
		for (int i = len1 - 1; i >= 0; i--) {
			int cin = 0;
			int j = len2 - 1;
			for (j = len2 - 1; j >= 0; j--) {
				int temp = cin + number1[i] * number2[j] + resArray[i + j + 1];
				cin = temp / 10;
				resArray[i + j + 1] = temp % 10;
			}
			
			// check if there remains the carryin
			if (cin != 0) {
				for (int pos = i + j + 1; pos >= 0; pos--) {
					int temp = cin + resArray[pos];
					cin = temp / 10;
					resArray[pos] = temp % 10;
				}
			}
		}
		
		StringBuffer buffer = new StringBuffer();
		int index = 0;
		for (index = 0; index < resArray.length; index++) {
			if (resArray[index] != 0) break;
		}
		
		for (; index < resArray.length; index++) {
			buffer.append(resArray[index]);
		}
		
		return buffer.toString();
    }
	
	public static void main(String[] args) {
		String s1 = "9";
		String s2 = "9";
		
		System.out.print(multiply(s1, s2));
	}
}
