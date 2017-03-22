/**
 * Project Euler problem #1.
 * Multiples of 3 and 5.
 * 
 * If we list all natural numbers below 10 that are multiples of 3 or 5, we get
 * 3, 5, 6, and 9.  The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 and 5 below 1000.
 */
public class Multiplesof3and5 {
	public static void main(final String[] args) {
		final int MAX = 1000;
		int sum = 0;

		Stopwatch.start();
		for (int ii = 1; ii < MAX; ii++) {
			if (0 == (ii % 5) || 0 == (ii % 3)) {
				sum += ii;
			}
		}
		System.out.println(String.format("Sum= %4d. Took %,dns", 
          sum, Stopwatch.elapsedTime()));
	}
}
