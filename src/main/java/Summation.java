/**
 * Project Euler Problem #6
 * Sum square difference.
 * 
 * The sum of the squares of the first ten natural numbers is,
 *      12 + 22 + ... + 102 = 385
 *  The square of the sum of the first ten natural numbers is,
 *      (1 + 2 + ... + 10)2 = 552 = 3025
 *  Hence the difference between the sum of the squares of the first ten natural
 *  numbers and the square of the sum is 3025 − 385 = 2640.
 *  
 *  Find the difference between the sum of the squares of the first one hundred
 *  natural numbers and the square of the sum.
 */
public class Summation {
	public static void main(String[] args) {
		int n = 100;
		long v = Summation.sum(n);
		long w = Summation.square(n);
		
		long x = Summation.sumOfSquares(n);
		long y = Summation.squareOfSum(n);
		long z = y - x;
		
		System.out.println(String.format("        Sum of 1 to %,d = %,d", n, v));
		System.out.println(String.format("          Square of %,d = %,d", n, w));
		System.out.println();
		System.out.println(String.format("Sum of squares 1 to %,d = %,d", n, x));
		System.out.println(String.format(" Square of sum 1 to %,d = %,d", n, y));
		System.out.println(String.format("         Difference     %,d", z));
		
		// Self Powers
		double a = 100, b = 0, c = 0;
		for (long i=1; i <= a; i++) {
			b = Summation.selfPowers(i);
			System.out.println(String.format("Self power %,d = %,.0f", i, b));
			c += b;
		}
		System.out.println(String.format("Self power of series 1 to %,f = %,f", a, c));
	}	
	
	public static long square(long n) {
		return n*n;
	}
	
	public static long sum(long n) {
		return (n==0 ? n : n+sum(n-1));
	}
	
	public static long sumOfSquares(long n) {
		return (n==0 ? n : square(n)+sumOfSquares(n-1));
	}

	public static long squareOfSum(long n) {
		return Summation.square(Summation.sum(n));
	}
	
	public static double selfPowers(long n) {
		double m = n;
		for (long i = n-1; i > 0; i--) {
			m *= n;
		}
		return m;		
	}
}
