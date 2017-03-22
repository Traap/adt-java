/**
 * Project Euler Problem #9
 * Special Pythagorean triplet
 * 
 * A Pythagorean triplet is a set of three natural numbers, 
 *   a < b < c, for which a^2 + b^2 = c^2
 *      
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class PythagoreanTriplet {
	
	public static void main(String[] args) {
		int TARGET = 1000;

		for (int a = 1; a <= (TARGET-1)/2; a++) {
			for (int b = a + 1; b <= (TARGET-a)/2; b++) {
				if (a + b < TARGET) {
						if (PythagoreanTriplet.IsPythagorean(a, b)) {
							break;
					}
				}
			}
		}
		System.out.println("All done!");
	}

	public static boolean IsPythagorean(int a, int b) {
		boolean retStat = false;
		int a2 = (int) Math.pow(a, 2);
		int b2 = (int) Math.pow(b, 2);
		int c = (int) Math.sqrt(a2 + b2);
		int c2 = (int) Math.pow(c, 2);
		
		if ((a + b + c == 1000) && (a2 + b2 == c2)) {
			System.out.println(
          String.format("WINNER: a=%,d b=%,d c=%,d product=%,d", 
            a, b, c, a*b*c));
			retStat = true;
		}

		return retStat;
	}
}
