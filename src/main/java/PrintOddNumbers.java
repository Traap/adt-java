public class PrintOddNumbers {

	public static void main(final String[] args) {
		printOddNumbers(100);
	}

	public static void printOddNumbers(final int max) {
		for (int ii = 1; ii < max; ii += 2) {
			System.out.println(ii);
		}
	}
}
