/**
 * Project Euler problem #14
 * Longest Collatz Sequence
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * 	n->n/2 (n is even)
 * 	n->3n+1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 	13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 items.  * Although it has not yet proved yet (Collatz Problem),
 * it is thought that all starting * numbers finish at .
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chaing starts the terms are allowed to go above one million.
 */

public class CollatzSequence {

	private static int StartingNumber = 1000000;
	
	public static void main(String[] args) {
		Stopwatch.start();
		CollatzSequence cs = new CollatzSequence();
		cs.process();
		System.out.println(
				String.format("maxCollatzNbr_ = %,d maxCollatzCount_ = %d took %,dns",
					cs.maxCollatzNbr_, 
					cs.maxCollatzCount_,
					Stopwatch.elapsedTime()));
	}

	/**
   * The maximum number less than StartingNumber that yielded the largest
   * Collatz sequence.
	 */
	private long maxCollatzNbr_ = 0;
	
	/**
	 * Number items in Collatz sequence.
	 */
	private long maxCollatzCount_ = 0;
	
	/**
	 * process drives to a solution.
	 */
	private void process() {
		for (long i=StartingNumber; i > 0; i--) {
			long nbr = i, count=1;
			while (nbr > 1) {
				nbr = nextNumberInSequence(nbr);
				count++;
			}
			checkAndSetNewMax(i, count);
		}
	}
	
	/**
	 * Calculate the next number in a Collatz sequence.
	 * @param n starting number.
	 * @return next number in sequence.
	 */
	private long nextNumberInSequence(long n) {
		return (isEven(n) 
				? evenNumber(n) 
				: oddNumber(n)); 
	}
	
	/**
	 * Starting with an odd number, calculate the next number in a Collatz sequence.
	 * @param n starting odd number.
	 * @return 3n+1
	 */
	private long oddNumber(long n) {
		return 3*n+1;
	}
	
	/**
	 * Starting with an even number, calculate the next number in a Collatz sequence.
	 * @param n starting even number.
	 * @return n/2.
	 */
	private long evenNumber(long n) {
		return n/2;
	}
	
	/**
	 * @return true when n is even.
	 */
	private boolean isEven(long n) {
		return (0 == (n % 2));
	}
	
	/**
	 * Update maximum count and number when a new maximum has been reached.
	 * @param i the number that started this Collatz sequence.
	 * @param count of number in this Collatz sequence.
	 */
	private void checkAndSetNewMax(long i, long count) {
		if (count > maxCollatzCount_) {
			maxCollatzCount_ = count;
			maxCollatzNbr_ = i;
		}
	}
}
