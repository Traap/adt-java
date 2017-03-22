import java.util.ArrayList;

/**
 * A simple stop watch implementation that mimics a stop watch capable of
 * recording a * main lap and several lap timers.  {@see System.nanoTime} is
 * used to record nano second * times.
 *
 * @author gary.a.howard@mac.com
 */
public class Stopwatch {

  /**
   * Start stop watch.
   * @return ns time stop watch was started for the main lap.
   */
  public static long start() {
    return (!Stopwatch.IS_RUNNING_)
           ? Stopwatch.startMainLapTimer_()
           : Stopwatch.updateMainLapTimer_();
  }

  /**
   * Stop stop watch.
   * @return ns time stop watch stopped for the main lap.
   */
  public static long stop() {
    return (Stopwatch.IS_RUNNING_)
          ? Stopwatch.stopMainLapTimer_()
          : Stopwatch.getMainLapTimer_();
  }

  /**
   * @return elapsed ns time stop watch was running for the main lap.
   */
  public static long elapsedTime() {
    return (Stopwatch.IS_RUNNING_)
          ? Stopwatch.calculateMainLapElapsedTime_()
          : Stopwatch.getMainLapTimer_();
  }

  /**
   * Record a new lap.
   * @return ns time lap was run.
   */
  public static long lap() {
      return (Stopwatch.IS_RUNNING_)
              ? Stopwatch.recordLap_()
              : 0;
  }

  /**
   * @param lap to get.
   * @return ns time lap was run.
   */
  public static long lapTime(int lap) {
      return (lap < LAPS_.size())
            ? Stopwatch.LAPS_.get(lap).time_
            : 0;
  }

  /**
   * Reset main lap and lap times.
   */
  public static void reset() {
    Stopwatch.IS_RUNNING_ = false;
    Stopwatch.LAPS_.clear();
    Stopwatch.LAPS_.add(new Stopwatch.LapTime());
  }

  /**
   * Record a new lap and return its time.
   * @return ns time lap was run.
   */
  private static long recordLap_() {
    long lap =  Stopwatch.calculateMainLapElapsedTime_();
    Stopwatch.LAPS_.add(new Stopwatch.LapTime(lap));
    return lap;
  }

  /**
   * @return the main lap time.
   */
  private static long getMainLapTimer_() {
    return Stopwatch.mainLap().time_;
  }

  /**
   * Start stop watch and record the main lap time.
   * @return main lap time.
   */
  private static long startMainLapTimer_() {
    Stopwatch.IS_RUNNING_ = true;
    return Stopwatch.mainLap().time_ = System.nanoTime();
  }

  /**
   * Update main lap time.
   * @return return main lap time.
   */
  private static long updateMainLapTimer_() {
    return Stopwatch.mainLap().time_ += Stopwatch.elapsedTime();
  }

  /**
   * Stop main lap time.
   * @return main lap time.
   */
  private static long stopMainLapTimer_() {
    Stopwatch.IS_RUNNING_ = false;
    return Stopwatch.mainLap().time_ = calculateMainLapElapsedTime_();
  }

  /**
   * Calculate main lap elapsed time.
   * @return elapsed time for the main lap time.
   */
  private static long calculateMainLapElapsedTime_() {
    return System.nanoTime() - Stopwatch.mainLap().time_;
  }

  /**
   * @return main lap LapTime object.
   */
  private static LapTime mainLap() {
    return Stopwatch.LAPS_.get(ORIGIN_);
  }

  /**
   * LapTime is used to record the time for reach lap.
   */
  private static class LapTime {
    public LapTime()          { time_ = 0; }
    public LapTime(long time) { time_ = time; }
    public long time_;
  }

  /*
   * true when stop watch is running.
   */
  static private boolean IS_RUNNING_ = false;

  /*
   * An array of laps.  Lap 0 is the main lap.
   */
  static private ArrayList<LapTime> LAPS_;

  /*
   * Mail lap index.
   */
  static private int ORIGIN_ = 0;

  /*
   * Statically initialize LAPS_ and seed it with main lap.
   */
  static {
    LAPS_ = new ArrayList<LapTime>();
    LAPS_.add(new Stopwatch.LapTime());
  }
}
