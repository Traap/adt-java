/**
 * Projet Euler Problem #7
 * 10,001st Prime
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * Problem #10
 * Summation of primes.
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below 2 million.
 */

/**
 * Input: an integer n > 1
 * Let A be an array of Boolean values, indexed by integers 2 to n,
 * initially all set to true.
 *
 * for i = 2, 3, 4, ..., not exceeding √n:
 * if A[i] is true:
 *   for j = i2, i2+i, i2+2i, ..., not exceeding n :
 *     A[j] := false
 *
 * Now all i such that A[i] is true are prime.
 * http://en.wikipedia.org/wiki/Sieve%5Fof%5FEratosthenes
 */
public class PrimeNumbers {

	private static boolean PrintPrimes = false;
	private boolean[] bits_;
	private int max_;
	private int primesFound_;
	private long sumPrimesFound_;
	
	public static void main(String[] args) {
		PrimeNumbers primeNumbers = new PrimeNumbers(2000000);
		primeNumbers.process();
	}
	
	public PrimeNumbers(int max) {
		max_ = max;
		primesFound_ = 0;
		sumPrimesFound_= 0;
		bits_ = new boolean[max+1];
	}

	public void process() {
		Stopwatch.start();
		
		resetPrimeBits();
		findPrimesToMax();
		countPrimesFound();
		sumPrimesFound();
		showPrimes();
		
		System.out.println(
        String.format("Found %,d primes upto %,d with sum %,d took %,dns", 
					primesFound_, 
					max_, 
					sumPrimesFound_,
					Stopwatch.elapsedTime()));
		
		int nth = 10001;
		System.out.println(
        String.format("%,dth Prime is %,d", 
          nth, whatIsTheNthPrimeNumber(nth)));
	}
	
	private void findPrimesToMax() {
		for (int ii=1; ii <= max_; ii++) {
			if (isPrime(ii)) {
				bits_[ii] = true;
			}			
		}
	}
	
	private boolean isPrime(int n) {
		if (n <= 1) return false;	
		if (2 != n) {
			if (0 == n % 2) return false;
			int max = (int) Math.pow(n, 0.5);
			for (int ii = 3; ii <= max; ii += 2) {
				if (0 == n % ii) return false;
			}
		}
		return true;
	}
	
	private void resetPrimeBits() {
		for (int ii = 0; ii < max_; ii++) {
			bits_[ii] = false;
		}
	}

	private void showPrimes() {
		if (!PrimeNumbers.PrintPrimes) return;
		int printCount = 0;
		for (int ii= 0; ii < max_+1; ii++) {
			if (bits_[ii]) {
				System.out.print(String.format("%9d ", ii));					
				printCount++;
				if (8 == printCount) {
					System.out.println();
					printCount=0;
				}
			}
		}
		System.out.println();
	}
	
	private void countPrimesFound() {
		for (int ii = 0; ii < max_ + 1; ii++) {
			if (bits_[ii]) {
				primesFound_++;
			}
		}
	}
	
	private void sumPrimesFound() {
		int maxII = 0;
		for (int ii = 0; ii < max_ + 1; ii++) {
			if (bits_[ii]) {
				sumPrimesFound_ += ii;
				maxII =ii;
			}
		}
		System.out.println(String.format("maxII=%,d", maxII));
	}
	
	private int whatIsTheNthPrimeNumber(int number) {
		int counter = 0;
		for (int ii = 0; ii < max_ + 1; ii++) {
			if (bits_[ii]) {
				if (++counter == number) {
					return ii;
				}
			}
		}
		return 0;
	}
}
