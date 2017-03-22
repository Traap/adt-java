/**
 * A very simple recursive factorial example.
 */

public class Factorial {
	public static double MAX_VALUE = 20.0;
	public static void main(final String[] args) {
		Stopwatch.start();

		final double nbr = Factorial.factorial(Factorial.MAX_VALUE);

		System.out.println(
        String.format("%.0f! = %,.0f reached in %,dns.",
          MAX_VALUE, nbr, Stopwatch.elapsedTime()));
	}

	public static double factorial(final double max) {
		return (max >= 1) ? Factorial.factorial(max - 1.0) * max : 1.0;
	}
}
