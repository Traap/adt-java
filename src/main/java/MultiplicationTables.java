class MultiplicationTables {
	public static void main(final String[] args) {
		multiplicationTables(12);
	}

	static void multiplicationTables(final int max) {
		for (int ii = 1; ii <= max; ii++) {
			for (int jj = 1; jj <= max; jj++) {
				System.out.print(String.format("%4d", jj * ii));
			}
			System.out.println();
		}
	}
}
