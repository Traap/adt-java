/**
 * Project Euler Problem #5
 * Smallest Multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from
 * 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 */
public class SmallestMultiple {
	public static void main(String[] args) {
		int[] divs = {20, 19, 18, 17, 16, 14, 13, 12, 11, 7};
		int k = 0, n = 0;

		Stopwatch.start();
		do {
			n++;
			k = 0;
			for (int j = 0; j < divs.length; j++) {
				k += n % divs[j];
				if (k != 0) break;
			}
			if (k == 0) break;
		} while (true);

		System.out.println(
				String.format("Smallest postitive integer %,d found that is evenly divisible 1..20. Took %,dns",
						n, Stopwatch.elapsedTime()));
	}
}
