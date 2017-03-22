import java.io.BufferedReader;
import java.io.FileReader;

class SumIntegersFromFile {
	public static void main(final String[] args) {
		System.out.println(sumIntegersFromFile("Integers.txt"));
	}

	public static long sumIntegersFromFile(final String fileName) {
		long total = 0;
		try {
      
			final BufferedReader in = new BufferedReader(
                                new FileReader(fileName));
      
			for (String str = in.readLine(); str != null; str = in.readLine()) {
				total += Integer.parseInt(str);
			}

			in.close();
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return total;
	}
}
