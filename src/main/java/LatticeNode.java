/**
 * Project Euler problem 15.
 * Node class used by Lattice Paths.
 */
public class LatticeNode {
  private LatticeNode right_;
  private LatticeNode down_;
  // TODO: Remove right_ & left_ when next_ is completely operational.
  private LatticeNode next_;
  private int row_;
  private int col_;
  private int vertex_;
  private boolean root_;
  private int state_;
  private static int UNDISCOVERED = 0;
  private static int DISCOVERED = 1;
  private static int PROCESSED = 2;

  public LatticeNode(int row, int col) {
    this(row, col, 0);
  }
  
  public LatticeNode(int row, int col, int vertex) {
    row_ = row;
    col_ = col;
    vertex_ = vertex;
    state_ = UNDISCOVERED;
    root_ = false;
  }

  public int         getRow()                { return row_; }
  public int         getCol()                { return col_; }
  public int         getVertex()             { return vertex_; }
  public LatticeNode getRight()              { return right_; }
  public void        setRight(LatticeNode n) { right_ = n; }
  public LatticeNode getNext()               { return next_; }
  public void        setNext(LatticeNode n)  { next_ = n; }
  public LatticeNode getDown()               { return down_; }
  public void        setDown(LatticeNode n)  { down_ = n; }
  public void        setUndiscovered()       { state_ = UNDISCOVERED; }
  public boolean     isDiscovered()          { return state_ == DISCOVERED; }
  public void        setDiscovered()         { state_ = DISCOVERED; }
  public boolean     isProcessed()           { return state_ == PROCESSED; }
  public void        setProcessed()          { state_ = PROCESSED; }
  public void        setRoot(boolean flag)   { root_ = flag; }
  public boolean     isRoot()                { return root_; }
}
