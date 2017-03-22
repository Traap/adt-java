/**
 * Project Euler problem #15
 * Lattice Paths
 *
 * https://projecteuler.net/problem=15
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to
 * the right * and down, there are exactly 6 routes to the bottom right corner.
 *
 * Grid:
 * {0,0} {1,0} {2,0}
 * {0,-1}{1,-1}{2,-1}
 * {0,-2}{1,-2}{2,-1}
 *
 * 9 Vertices
 * 12 edges

 * Routes:
 * 1) r -> r -> d -> d
 * 2) r -> d -> r -> d
 * 3) r -> d -> d -> r
 * 4) d -> r -> r -> d
 * 5) d -> r -> d -> r
 * 6) d -> r -> r -> d
 */
public class LatticePaths {

	public static void main(String[] args) {
	  Stopwatch.start();

		LatticePaths lp = new LatticePaths(5, 5);
		lp.process();

    System.out.println(
        String.format("Lattice Paths took %,dns to find %,d paths",
          Stopwatch.elapsedTime(), lp.maxFound()));
  }

  private LatticeNode[][] grid_;
  private LatticeNode[][] adj_;
  private int rows_;
  private int cols_;
  private long paths_;

  // Enable debug detailed output.
  private boolean showResults_ = true;
  private boolean showPaths_ = false;

	public LatticePaths (int rows, int cols) {
    rows_ = rows;
    cols_ = cols;
    grid_= new LatticeNode[rows_][cols_];
    adj_ = new LatticeNode[rows_*cols_][2];
	}

	private void process() {
    initializeGrid();
    initializeNodes();
    calcualtePaths();
    printTheGrid();
    recordPathsThroughGrid();
	}

	private long maxFound() {
	  return paths_;
	}

	private void initializeGrid() {
    for (int row = 0; row < rows_; row++) {
      for (int col=0; col < cols_; col++) {
        grid_[row][col] = new LatticeNode(row, col, calcualteVertexNumber(row, col));
      }
    }
	}

	private int calcualteVertexNumber(int row, int col) {
	  return row + col + row * (rows_-1) + 0;
	}

	private void initializeNodes() {
    for (int row = 0; row < rows_; row++) {
      for (int col=0; col < cols_; col++) {
        initializeLinkage(row, col);
      }
    }
	}

	private void initializeLinkage(int row, int col) {
    LatticeNode n = grid_[row][col];
    LatticeNode r = (col+1 < cols_) ? grid_[row][col+1] : null;
    LatticeNode d = (row+1 < rows_) ? grid_[row+1][col] : null;
    n.setRight(r);
    n.setDown(d);
    n.setNext(r);

    // adjacent list.
    adj_[n.getVertex()][0] = r;
    adj_[n.getVertex()][1] = d;
	}

	/**
	 * N-chose-k combinatorics: Using multiplicative formula n-(k-i)/i
	 * @see http://en.wikipedia.org/wiki/Binomial_coefficient
	 */
	private void calcualtePaths() {
		int n = rows_*2;      // Number of moves
		int k = cols_;        // Number of columns.
		if (k > (n-k)) {
			k = n - k;
		}
		long  c = 1;
		for (int i = 0; i < k; i++) {
			c = c * (n-i);
			c = c / (i+1);
		}
		paths_ = c;

	}

	private void recordPathsThroughGrid() {
    if (!showPaths_) return;
    // TODO: Write algorithm record each path.
    for (long i=0; i < paths_; i++) {
      LatticeNode node = grid_[0][0];
      while (node!= null) {
        node=move(node, i);
      }
    }
	}

	/**
	 * Move to next node (vertex).
	 * @param n current node (vertex)
	 * @param path
	 * @return
	 */
	private LatticeNode move(LatticeNode n, long path) {
    if (n == null) return null;

    // TODO: Write algorithm to alternate left & right move.
    System.out.println(String.format("Node=%08x",n.hashCode()));
    LatticeNode right = n.getRight();
    LatticeNode down = n.getDown();
    LatticeNode node = null;

    if (right != null) {
      node = right;
    }
    else if (down != null) {
      node = down;
    }
    return node;
	}

	/**
	 * Show the grid linkage.
	 */
	private void printTheGrid() {
    printGridLinkage();
    printAdjacentyList();
    printVerticies();
	}

  private void printGridLinkage() {
    if (!showResults_) return;

    System.out.println("Lattice Grid Linkage");
    SysOut.PrintSeparator();
    String fmt = "Node=%08x row=%02d col=%02d v=%02d right=%08x down=%08x";

    for (int row = 0; row < grid_[0].length; row++) {
      for (int col=0; col < grid_.length; col++) {
        LatticeNode n = grid_[row][col];
        System.out.println(
                String.format(fmt,
                        n.hashCode(),
                        n.getRow(),
                        n.getCol(),
                        n.getVertex(),
                        (n.getRight()==null) ? null : n.getRight().hashCode(),
                        (n.getDown()==null) ? null : n.getDown().hashCode()
                        ));
      }
      SysOut.PrintSeparator();
    }
  }

  private void printAdjacentyList() {
    if (!showResults_) return;

    System.out.println("Lattice Grid Adjacency List");
    SysOut.PrintSeparator();

    for (int i=0; i < adj_.length; i++) {
        System.out.println(
            String.format(
              "right=%08x \tdown=%08x",
              (adj_[i][0] == null) ? null : adj_[i][0].getVertex(),
              (adj_[i][1] == null) ? null : adj_[i][1].getVertex()
              )
            );
    }
    SysOut.PrintSeparator();
  }

  /**
    * printVerticies
    */
  private void printVerticies() {
    if (!showResults_) return;

    System.out.println("Lattice Verticies");
    SysOut.PrintSeparator();

    for (int row = 0; row < grid_[0].length; row++) {
      for (int col=0; col < grid_.length; col++) {
        LatticeNode n = grid_[row][col];
        System.out.print(String.format("%02d ", n.getVertex()));
      }
      System.out.println();
    }
    SysOut.PrintSeparator();
  }
}
