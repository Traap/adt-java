public class StaticBlocks {
	// Static initialization is used to initialize static final variables.
	// StaticBlocks.MAX_VALUE is the static final variable. It cannot
	// be initialized with the declaration statement and be given a definition
	// in this static block. Nor MAX_VALUE use the class name when giving
	// the variable a definition. Instance variables cannot be set in static
	// initialization block.
	static {
		System.out.println("Step 1: static initialization block");
		YEAR_OF_BIRTH = 1962;
	}

	// Now the main is staring.
	public static void main(final String[] args) {
		System.out.println("Step 2: StaticBlocks main is starting");

		final StaticBlocks sb = new StaticBlocks();

		System.out.println("Step 5: All initialization blocks are complete!");
		System.out.println(String.format("\tYEAR_OF_BIRTH = %d",
				StaticBlocks.YEAR_OF_BIRTH));
		System.out.println(String.format("\tmonth_of_birth_ = %d",
				sb.monthOfBirth_));
		System.out.println(String.format("\tmonth_of_birth_ = %d",
				sb.dayOfBirth_));

		sb.echoBirthDate();
	}

  // An initialization block is similar to a static initialization block 
  // except it is executed prior to class constructor. Instance variables can
  // be set.
  {
		System.out.println("Step 3: instance initialization block");
		monthOfBirth_ = 12;
	}

	// no-arg constructor
	public StaticBlocks() {
		System.out.println("Step 4: no-arg constructor");
		dayOfBirth_ = 26;
	}

	public void echoBirthDate() {
		System.out.println("Step 6: echoing birth date");
		System.out.println(String.format("\tYou birth date was %d-%d-%d",
				StaticBlocks.YEAR_OF_BIRTH, monthOfBirth_, dayOfBirth_));
	}

	// class and instance variables.
	public static final long YEAR_OF_BIRTH;
	private long monthOfBirth_;
	private final long dayOfBirth_;
}
