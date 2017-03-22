/**
 * Project Euler Problem #4
 * Largest Palindrome Product
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class PalindromicNumber {

	public static void main(String[] args) {
		int nbr = 0, nbrJ = 0, nbrI= 0, MAX = 999, MIN = 99, temp=0, found = 0;
		Stopwatch.start();
		
		for (int ii = MAX; ii > MIN; ii--) {
			for (int jj = MAX; jj > MIN; jj--) {
				
				temp = jj*ii;
			
				if (Palindrome.isPalindrome(new Integer(temp).toString())) {
					System.out.println(
              String.format("Palindrome found: %s. Product of %d * %d", 
                temp, ii, jj));
					found++;
					if (temp > nbr) {
						nbr = temp;
						nbrI = ii;
						nbrJ = jj;
					}
				}
			}			
		}
		System.out.println(
		        String.format("Max palindrome found = %,d using %,d * %,d\nTotal found: %,d\nAlgorithm time = %,dns", 
				nbr, nbrI, nbrJ, found, Stopwatch.elapsedTime()));
	}
}
