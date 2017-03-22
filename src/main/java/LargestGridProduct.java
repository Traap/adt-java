/**
 * Project Euler Problem #11.
 * Largest Product in Grid.
 *
 * What is the greatest product of four adjacent numbers in the same direction 
 * (up, down, left, right, or diagonally) in a 20x20 grid?
 * Answer: 70,600,674
 */
public class LargestGridProduct {
	
	public static void main(String[] args) {
		Stopwatch.start();
		
		LargestGridProduct lgp = new LargestGridProduct();
		lgp.process();
		lgp.determineMax();
		lgp.showResults();
		
		System.out.println(
				String.format("LargestGridProduct took %,dns to find %,d", 
						Stopwatch.elapsedTime(), 
						lgp.maxFound()));
	}
	
	/**
	 * Enable debug detailed output.
	 */
	private boolean showResults_ = true;
	
	/**
	 * The Grid.
	 */
	private int[][] grid_ = {
    { 8,  2, 22, 97, 38, 15,  0, 40,  0, 75,  4,  5,  7, 78, 52, 12, 50, 77, 91,  8}, 
    {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48,  4, 56, 62,  0}, 
    {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30,  3, 49, 13, 36, 65}, 
    {52, 70, 95, 23,  4, 60, 11, 42, 69, 24, 68, 56,  1, 32, 56, 71, 37,  2, 36, 91}, 
    {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80}, 
    {24, 47, 32, 60, 99,  3, 45,  2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50}, 
    {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70}, 
    {67, 26, 20, 68,  2, 62, 12, 20, 95, 63, 94, 39, 63,  8, 40, 91, 66, 49, 94, 21}, 
    {24, 55, 58,  5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72}, 
    {21, 36, 23,  9, 75,  0, 76, 44, 20, 45, 35, 14,  0, 61, 33, 97, 34, 31, 33, 95}, 
    {78, 17, 53, 28, 22, 75, 31, 67, 15, 94,  3, 80,  4, 62, 16, 14,  9, 53, 56, 92}, 
    {16, 39,  5, 42, 96, 35, 31, 47, 55, 58, 88, 24,  0, 17, 54, 24, 36, 29, 85, 57}, 
    {86, 56,  0, 48, 35, 71, 89,  7,  5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58}, 
    {19, 80, 81, 68,  5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77,  4, 89, 55, 40}, 
    { 4, 52,  8, 83, 97, 35, 99, 16,  7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66}, 
    {88, 36, 68, 87, 57, 62, 20, 72,  3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69}, 
    { 4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18,  8, 46, 29, 32, 40, 62, 76, 36}, 
    {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74,  4, 36, 16}, 
    {20, 73, 35, 29, 78, 31, 90,  1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57,  5, 54}, 
    {01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52,  1, 89, 19, 67, 48}
	};
	
	/**
	 * Products calculated and indexes.
	 */
	private int products_[]= {0, 0, 0, 0, 0, 0, 0};
	private int up_ = 0;
	private int down_ = 1;
	private int left_ = 2;
	private int right_ = 3;
	private int dnDiag_ = 4;
	private int upDiag_ = 5;
	private int max_ = 6;
	
	/**
	 * Calculate the product of 4 adjacent numbers moving down through a Grid.
	 */
	private void process() {
		productGoingUp();
		productGoingDown();
		productGoingLeft();
		productGoingRight();
		processGoingDownDiagonally();
		processGoingUpDiagonally();
	}
	
	/**
	 * Calculate the product of 4 adjacent numbers moving up through a Grid.
	 */
	private void productGoingUp() {
		products_[up_] = 0;
		for (int col = 0; col < grid_[0].length; col++) {
			for (int row = grid_.length-1; row >= 3; row--) {
				calcualteProduct(row, col, up_, -1, 0);
			}
		}
	}
	
	/**
	 * Calculate the product of 4 adjacent numbers moving down through a Grid.
	 */
	private void productGoingDown() {
		products_[down_] = 0;	
		for (int col = 0; col < grid_[0].length; col++) {
			for (int row = 0; row < grid_.length - 3; row++) {
				calcualteProduct(row, col, down_, 1, 0);
			}
		}
	}
	
	/**
	 * Calculate the product of 4 adjacent numbers moving left through a Grid.
	 */
	private void productGoingLeft() {
		products_[left_] = 0;
		for (int row = 0; row < grid_.length; row++) {
			for (int col = grid_[0].length-1; col >= 3; col--) {
				calcualteProduct(row, col, left_, 0, -1);
			}
		}
	}
	
	/**
	 * Calculate the product of 4 adjacent numbers moving right through a Grid.
	 */
	private void productGoingRight() {
		products_[right_] = 0;
		for (int row = 0; row < grid_.length; row++) {
			for (int col = 0; col < grid_[0].length - 3; col++) {
				calcualteProduct(row, col, right_, 0, 1);
			}
		}
	}
	
	/**
	 * Calculate the product of 4 adjacent numbers moving down diagonally through a Grid.
	 */
	private void processGoingDownDiagonally() {
		products_[dnDiag_] = 0;
		for (int row = 0; row < grid_.length-3; row++) {
			for (int col = 0; col < grid_[0].length-3; col++) {
				calcualteProduct(row, col, dnDiag_, 1, 1);
			}
		}
	}
	
	/**
	 * Calculate the product of 4 adjacent numbers moving up diagonally through a Grid.
	 */
	private void processGoingUpDiagonally() {
		products_[upDiag_] = 0;
		for (int row = grid_.length-1; row >= 3; row--) {
			for (int col = 0; col < grid_[0].length-3; col++) {
				calcualteProduct(row, col, upDiag_, -1, 1);
			}
		}
	}
	
	/**
	 * Calculates the product of 4 adjacent numbers in a Grid.
	 * @param row the starting row.
	 * @param col the starting col.
	 * @param dir the direction: up, down, right, left, down diagonal, or up diagonal.
	 * @param r increment row by r.
	 * @param c increment col by c.
	 */
	private void calcualteProduct(int row, int col, int dir, int r, int c) {
		int nbr=1;
		for (int i = 0; i < 4; i++) {
			nbr *= grid_[row][col];
			row += r;
			col += c;
		}
		if (nbr > products_[dir]) {
			products_[dir] = nbr;
		}
	}
	
	/**
	 * Determine which direction: up, down, right, left, down diagonal or up diagonal
	 * had the greatest product of 4 adjacent numbers.
	 */
	private void determineMax() {
		for (int i = 0; i <= products_.length-2; i++) {
			if (products_[i] > products_[max_]) {
				products_[max_] = products_[i];
			}
		}
	}

	/**
	 * @return the greatest product of 4 adjacent numbers in a Grid.
	 */
	private int maxFound() {
		return products_[max_];		
	}

	/**
	 * Show the direction results for the product of 4 adjacent numbers.
	 */
	private void showResults() {
		if (!showResults_) return;
		String fmt = "up_\t=%,10d\ndown_\t=%,10d\nleft_\t=%,10d\nright_\t=%,10d\nDnDiag_\t=%,10d\nUpDiag_\t=%,10d\nMax_\t=%,10d";
		System.out.println(String.format(fmt,
      products_[up_], 
      products_[down_], 
      products_[left_], 
      products_[right_], 
      products_[dnDiag_],
      products_[upDiag_],
      products_[max_]));
	}
}
