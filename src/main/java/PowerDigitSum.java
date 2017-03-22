/**
 * Project Euler Problem #16
 * Power Digit Sum
 * 
 * 2^15 = 32,768 and the sum of its digits is 3+2+7+6_8=26.
 * 
 * What is the sum of the digits of the number 2^1000.
 */
import java.math.BigInteger;

public class PowerDigitSum {

	public static void main(String[] args) {
		int n = 2;
		int p = 1000;
		
		BigInteger nbr = RaiseToPower(n,p);
		long sum = SumOfDigits(nbr);
				
		System.out.print(
				String.format(
						"%d^%d=%,d\nsum of digits=%,d", 
						n, p, nbr, sum));
	}
	
	public static BigInteger RaiseToPower(int n, int power) {
		return new BigInteger(new Integer(n).toString()).pow(power);
  }
	
	public static long SumOfDigits(BigInteger n) {		
		long nbr = 0;
		StringBuffer sb = new StringBuffer(n.toString());
		
		for (int i = 0; i<sb.length(); i++) {		
			nbr += (new Integer(sb.charAt(i))) - 48;	// ASCII math
		}
		
		return nbr;
	}
}
