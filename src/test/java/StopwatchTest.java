import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class StopwatchTest {

	@Before
    public void setUp() {
    	Stopwatch.reset();
    }

	@Test
	public void testStart() {
		org.junit.Assert.assertTrue("\ntestStart", true);
		Stopwatch.start();
		org.junit.Assert.assertTrue("Stopwatch has started", Stopwatch.elapsedTime() > 0);
	}

	@Test
	public void testTwoStarts() {
		org.junit.Assert.assertTrue("\ntestTwoStarts", true);
		long start0, start1;
		System.out.println(String.format("Start  0: %,dns", start0=Stopwatch.start()));
		System.out.println(String.format("Stop   0: %,dns", Stopwatch.stop()));

		try { Thread.sleep(1500); } catch (InterruptedException e) {}

		System.out.println(String.format("Start  1: %,dns", start1=Stopwatch.start()));
		System.out.println(String.format("Elapsed1: %,dns", Stopwatch.elapsedTime()));

		System.out.println(String.format("Sleep   : %,dns", start1-start0));
	}

	@Test
	public void testStartStopElapsed() {
		org.junit.Assert.assertTrue("\ntestStartStopElapsed", true);
		System.out.println(String.format("Start   : %,dns", Stopwatch.start()));
		System.out.println(String.format("Stop    : %,dns", Stopwatch.stop()));
		System.out.println(String.format("Elapsed : %,dns", Stopwatch.elapsedTime()));
	}

	@Test
	public void testStartElapsed() {
		org.junit.Assert.assertTrue("\ntestStartElapsed", true);
		System.out.println(String.format("Start   : %,dns", Stopwatch.start()));
		System.out.println(String.format("Elapsed : %,dns", Stopwatch.elapsedTime()));
	}

	@Test
	public void testMultipleLaps() {
    org.junit.Assert.assertTrue("\ntestMultipleLaps", true);
    System.out.println(String.format("Start   : %,dns", Stopwatch.start()));

    int sleep = 100;
    for (int i = 0; i <= 10; i++) {
      Stopwatch.lap();
      try { Thread.sleep(sleep*i); } catch (InterruptedException e) {}
    }

    for (int i = 0; i < 10; i++) {
      Stopwatch.lap();
      System.out.println(String.format("lapTime %d: %,dns", i, Stopwatch.lapTime(i)));
    }

    System.out.println(String.format("Stop    : %,dns", Stopwatch.stop()));
    System.out.println(String.format("Elapsed : %,dns", Stopwatch.elapsedTime()));

	}
}
