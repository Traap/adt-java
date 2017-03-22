public class Finally {
	private static boolean DONT_DO_THIS_01 = false;
	private static boolean DONT_DO_THIS_02 = false;

	public static void main(String[] args) {
		System.out.println("Main: Start");
		Finally.Foobar();
		System.out.println("Main: End");
	}

	public static void Foobar() {
		System.out.println("Foobar: Start");
		try {
			System.out.println("Foobar: Hello World!");
			throw new Exception();
		}
		catch (Exception e) {
			System.out.println("Foobar: catch(Exception)");
			if (Finally.DONT_DO_THIS_01) System.exit(1);
		}
		finally {
			System.out.println("Foobar: finally");
			if (Finally.DONT_DO_THIS_02) System.exit(1);
		}
		System.out.println("Foobar: End");
	}
}
