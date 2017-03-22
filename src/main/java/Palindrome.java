public class Palindrome {

	public static void main(String[] args) {
		System.out.println(String.format("Radar : %s", Palindrome.isPalindrome("Radar")));
		System.out.println(String.format("987654321123456789 : %s", Palindrome.isPalindrome("987654321123456789")));
		System.out.println(String.format("98765432123456789 : %s", Palindrome.isPalindrome("98765432123456789")));
		System.out.println(String.format("The Three Stooges : %s", Palindrome.isPalindrome("The Three Stooges")));

	}

	public static boolean isPalindrome(String str) {
		if (null == str) return false;
		
		StringBuffer sb = new StringBuffer(str.toLowerCase());
		if (sb.length() < 2) return false;
		
		boolean retVal = true;
		
		for (int ii = 0, jj = sb.length()-1;
				ii < sb.length()/2; 
				ii++, jj--) {
						
			if (sb.charAt(ii) != sb.charAt(jj)) {
				retVal = false;
				break;
			}
		}
		
		return retVal;
	}  
}
