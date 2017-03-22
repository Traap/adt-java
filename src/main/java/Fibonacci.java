public class Fibonacci {
	public static long MAX_VALUE = 30;

	public static void main(final String[] args) {
		Stopwatch.start();

		long nbr = 0;

		for (long ii = 0; ii <= Fibonacci.MAX_VALUE; ii++) {
			Stopwatch.lap();

			nbr = fibonacci(ii);

			final long lapTime = Stopwatch.lapTime((int)ii);

			System.out
					.println(String
							.format("ii=%d %,dns to find %,d using %,d recursions [elapsedtime %,dns]",
									ii, lapTime, nbr, Fibonacci.TOTAL,
									Stopwatch.elapsedTime()));
			Fibonacci.TOTAL = 0;
		}

		Stopwatch.stop();
		System.out.println(
        String.format("%,dns to execute %,d recursions", 
          Stopwatch.elapsedTime(), 
          Fibonacci.GRAND_TOTAL));
	}

	public static long fibonacci(final long n) {
		Fibonacci.GRAND_TOTAL++;
		Fibonacci.TOTAL++;
		return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static long TOTAL = 0;
	public static long GRAND_TOTAL = 0;
}
