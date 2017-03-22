/**
 * Depth First Search is a Java implementation DFS algorithm documented
 * discussed in "The Algorithm Design Manual".  
 *
 * @see http://www.amazon.com/Algorithm-Design-Manual-Steve-Skiena/dp/0387948600.
 * As * well as an implementation presented @see http://algs4.cs.princeton.edu/
 * 
 * Any errors combining these techniques is mine.
 */
import java.util.List;

public class DepthFirstSearch extends GraphTraversal {
  private Vertex[] stack_;          // Stack of vertices to visit
  private int onStack_;             // Items in stack.
  private boolean[] marked_;        // marked[v] if there is a s-v path
  private int count_;

	
	public DepthFirstSearch(Graph g, int start) {
    super(g, start);
    initializeStack();
  }

	private void initializeStack() {
	 onStack_ = -1;		
    stack_ = new Vertex[getG().edgeCount()];
		Vertex v = getG().vertexAt(getStart());
		marked_ = new boolean[getG().edgeCount()];
		count_ = 0;
		push(v);    	
	}

  private final void dfs(Graph g, int start) {
    Vertex x = pop();   
    processVertexEarly(x);

    List<Edge> edges = x.getEdges();
    for (int i=0; i < edges.size(); i++ ) {
      Vertex y = edges.get(i).getVertexY();
      if (!y.isDiscovered()) {
        y.setParent(x);
          processEdge(x, y);
          push(y);
          dfs(getG(), y.getNumber());
      }
      else if ((!y.isProcessed() && !y.getParent().equals(x)) 
              || getG().isDirected()) {
          processEdge(x, y);
      }                
    }
    processVertexLate(x);
    SysOut.PrintSeparator();
  }
  
  private final void dfs2(Graph g, int start) {
    count_ += 1;
    marked_[start] = true;
    List<Edge> edges = g.vertexAt(start).getEdges();
    for (int i=0; i < edges.size(); i++) {
      Edge e = edges.get(i);
      if (!marked_[e.getNumber()]) {
        dfs2(g, e.getVertexY().getNumber());
      }
    }
  }
    
  @Override
  public final void search() {
    dfs(getG(), getStart());
    dfs2(getG(), getStart());
    printMarked();
  }
  
  @Override 
  public void processVertexEarly(Vertex v) {
    v.setDiscovered();
    v.incrementEntryTime();
    System.out.println(String.format("processVertexEarly: %d ", v.getNumber()));
  }

  @Override 
  final public void processVertexLate(Vertex v) {
    v.incrementExitTime();
    v.setProcessed();
    System.out.println(String.format("processVertexLate: %d", v.getNumber())); 
  }
  
  @Override 
  final public void processEdge(Vertex x, Vertex y) {
    System.out.println( String.format("processEdge: %d", y.getNumber()));
  }

  protected boolean isStackEmpty() {
    return onStack_ < 0;
  }
  
  
  protected void push(Vertex v) {
    stack_[++onStack_] = v;
    v.setDiscovered();
  }
  
  protected Vertex pop() {
    Vertex v = stack_[onStack_];
    stack_[onStack_--] = null;
    return v;
  }	

  private void printStack() {
    System.out.print(String.format("onStack_=%02d items= { ", onStack_));
    for (int i = 0; i <= onStack_; i++) {
      System.out.print(String.format("%02d ", stack_[i].getNumber()));            
    }
    System.out.println("}");
  }

  private void printMarked() {
    System.out.print(String.format("count_=%2d {", count_));
    for (int i=0; i < marked_.length; i++) {
      System.out.print(String.format("%s:%02d ", marked_[i], i));
    }
    System.out.println("}");
  }
}
