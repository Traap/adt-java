public abstract class GraphTraversal {

  private Graph G_;                 // The graph
  private int start_;               // Which vertex to start search with.  

  public void search() {}
  public void processVertexEarly(Vertex  v) {}
  public void processVertexLate(Vertex v) {}
  public void processEdge(Vertex x, Vertex y) {}
  
  public GraphTraversal(Graph g, int start) {
    G_ = g;
    start_ = start;        
  }

  final protected Graph getG() {
    return G_;
  }
  
  final protected int getStart() {
    return start_;
  }
}
