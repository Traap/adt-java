public class PrimeFactor {

	public static void main(String[] args) {
		long MAX = 600851475143L;

		Stopwatch.start();
		
		long lpf = PrimeFactor.largestPrimeFactor(MAX);
		
		System.out.println(
        String.format("Largest prime factor of %,d is %,d. Took %,dns",
          MAX, lpf, Stopwatch.elapsedTime()));	
	}
	
	public static long largestPrimeFactor(long nbr) {
    // largest composite factor must be smaller than sqrt
    long sqrt = (long)Math.ceil(Math.sqrt((double)nbr));
    long largest = -1;

    for (long ii = 2; ii <= sqrt; ii++) {
      if (nbr % ii == 0) {
        System.out.println(
            String.format("Nbr %,d sqrt %,d nbr/ii %,d ii %,d", 
              nbr, sqrt, nbr/ii, ii));	
        long test = largestPrimeFactor(nbr/ii);
        if(test > largest) {
          largest = test;
        }
      }
    }

    if (largest != -1) {
      return largest;
    }

    // number is prime
    return nbr;
  } 
}
