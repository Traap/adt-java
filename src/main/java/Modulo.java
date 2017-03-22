public class Modulo {

	public static void main(final String[] args) {
		Stopwatch.start();
		for (long ii = 1; ii < Math.pow(10, 5); ii *= 10) {
			System.out.println(String.format(
            "left side %,d right side range 1 - %,d remainders found %,d took %,dns",
						ii, ii, modulo(ii), Stopwatch.elapsedTime()));
		}
	}

	public static long modulo(final long max) {
		long rem = 0, total = 0;
		for (long ii = 1; ii <= max; ii++) {
			rem = max % ii;
			if (0 == rem) {
				total++;
			}
		}
		return total;
	}
}
