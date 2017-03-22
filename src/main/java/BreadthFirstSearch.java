import java.util.List;

public class BreadthFirstSearch extends GraphTraversal {
  private Vertex[] queue_;          // queue of vertices to visit
  private int inQueue_;             // Items in queue.

  public BreadthFirstSearch(Graph g, int start) {
    super(g, start);
    initializeQueue();
  }


  private void initializeQueue() {
    queue_ = new Vertex[getG().edgeCount()];
    inQueue_ = -1;
    Vertex v = getG().vertexAt(getStart());
    enqueue(v);
  }

  @Override
  public final void search() {
    while (!isQueueEmpty()) {
        Vertex x = dequeue();
        processVertexEarly(x);

        List<Edge> edges = x.getEdges();
        for (int i=0; i < edges.size(); i++ ) {
          Vertex y = edges.get(i).getVertexY();
          if (!y.isProcessed() || getG().isDirected()) {
            processEdge(x, y);
          }
          if (!y.isDiscovered()) {
            enqueue(y);
          }
        }
        processVertexLate(x);
        SysOut.PrintSeparator();
    }
  }

  @Override
  public void processVertexEarly(Vertex v) {
    System.out.println( String.format("processVertexEarly: %d", v.getNumber()));
    v.setProcessed();
  }

  @Override
  final public void processVertexLate(Vertex v) {
    System.out.println( String.format("processVertexLate: %d", v.getNumber()));
  }

  @Override
  final public void processEdge(Vertex x, Vertex y) {
   System.out.println( String.format("processEdge: %d", y.getNumber()));
  }

  protected boolean isQueueEmpty() {
   return inQueue_ < 0;
  }


  protected void enqueue(Vertex v) {
  queue_[++inQueue_] = v;
  v.setDiscovered();
  }

  protected Vertex dequeue() {
    Vertex v = queue_[0];
    for (int i = 0; i <= inQueue_; i++) {
      queue_[i] = queue_[i+1];
      queue_[i+1] = null;
    }
    inQueue_--;
    return v;
  }
  private void printQueue() {
    System.out.print(String.format("inQueue_=%02d items= { ", inQueue_));
    for (int i = 0; i <= inQueue_; i++) {
      System.out.print(String.format("%02d ", queue_[i].getNumber()));
    }
    System.out.println("}");
  }
}
