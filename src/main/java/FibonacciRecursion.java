/**
 * Calculate Fibonacci sequence using recursion.
 */
public class FibonacciRecursion {
  private static long MAX_VALUE = 30;
  private static long TOTAL = 0;
  private static long GRAND_TOTAL = 0;

	public static void main(final String[] args) {
	    test01();	    
	    TOTAL = GRAND_TOTAL = 0;    
	    test02();
	}

	/**
	 * Control calculate Fibonacci numbers using a brute force algorithm. 
	 */
	private static void test01() {
    Stopwatch.start();
    SysOut.PrintSeparator();
    System.out.println("Fibonacci w/ brute force algorithm.");
    
    long nbr = 0;
    for (long ii = 0; ii <= MAX_VALUE; ii++) {
      nbr = fibonacciBruteForce(ii);
      printNumber(nbr, ii);
      TOTAL = 0;
    }
    printTotal();
}

  /**
   * Control calculating Fibonacci numbers using a divide and conquer algorithm
   */
  private static void test02() {
      Stopwatch.reset();
      Stopwatch.start();
      SysOut.PrintSeparator();
      System.out.println("Fibonacci w/ divide and conqure algorithm");
      long nbr = 0;
      for (long ii = 0; ii <= MAX_VALUE; ii++) {
        nbr = fibonacciDividAndConqure(ii);
        printNumber(nbr, ii);
        TOTAL = 0;
      }
      printTotal();           
  }

  /**
   * Calculate Fibonacci number using a recursive brute force algorithm.
   */
  public static long fibonacciBruteForce(final long n) {
    GRAND_TOTAL++;
    TOTAL++;
    return (n <= 1 ? n : fibonacciBruteForce(n - 1) + fibonacciBruteForce(n - 2));
  }

  /**
   * Calculate Fibonacci number using a divide and conqure algorithm.
   */
  public static long fibonacciDividAndConqure(long n) {
    GRAND_TOTAL++;
    TOTAL++;
    
    if (n== 0 || n==1) return n;
  
    long a = fibonacciDividAndConqure ((n+1)/2);
    long b = fibonacciDividAndConqure ((n+1)/2-1);
    if (n %2 == 0) {
      return a * (a + 2 * b);
    }
    else {
      return a * a + b * b;
    }
 }

  private static void printTotal() {
    System.out.println(
        String.format("total recursions used %,d taking %,dns", 
          GRAND_TOTAL, Stopwatch.elapsedTime()));
  }

  private static void printNumber(long nbr, long ii) {
    System.out.println(
        String.format("ii=%d found %,d using %,d recursions", 
          ii, nbr,TOTAL));
  }
}
