/**
 * Graph is modeled after "The algorithm design manual".
 */
import java.util.List;

public class Graph {
  public static void main(String[] args) {
    Graph g = new Graph();
    g.initialize();
    g.printVertices();
    g.printEdges();
    g.printVerticesOutLinks();
    g.bfs(g);
    g.resetVerticesStates();
    g.dfs(g);
  }

  // Graph size instance variables.
  private static int MAX_VERTICES = 9;
  private static int MAX_EDGES = 12;
  private static boolean DIRECTED = true;

  // Graph instance variables.
  private Vertex[] vertices_;	// vertex info
  private Edge[] edges_;		// adjacency info.
  private int nVertices_; 	// number of vertices in graph.
  private int nEdges_; 		// number of edges in graph.
  boolean directed_; 			// is the graph directed?

  public Graph() {
    this(MAX_VERTICES, MAX_EDGES, DIRECTED);
  }

  public Graph(int vectors, int edges, boolean directed) {
    nVertices_ = vectors;
    nEdges_ = edges;
    directed_ = directed;
  }

  /**
   * Graph is directed 3x3.  Adjacent nodes are right and down.
   * 00 01 02
   * 03 04 05
   * 06 07 08
   */
  private void initialize() {
    initializeVertices();
    initializeEdges();
  }

  private void initializeVertices() {
    vertices_ = new Vertex[nVertices_];
    for (int i = 0; i < nVertices_; i++) {
      vertices_[i] = new Vertex(i);
    }
  }

  private void resetVerticesStates() {
    for (int i = 0; i < nVertices_; i++) {
      vertices_[i].resetStates();
    }
  }

  private void initializeEdges() {
    edges_ = new Edge[nEdges_];
    for (int i = 0; i < nEdges_; i++) {
      edges_[i] = new Edge(i);
    }

    updateEdge(edges_[0], vertices_[0], vertices_[1]);	// e0
    updateEdge(edges_[1], vertices_[0], vertices_[3]);	// e1
    updateEdge(edges_[2], vertices_[1], vertices_[2]);	// e2
    updateEdge(edges_[3], vertices_[1], vertices_[4]);	// e3
    updateEdge(edges_[4], vertices_[2], vertices_[5]);	// e4
    updateEdge(edges_[5], vertices_[3], vertices_[4]);	// e5
    updateEdge(edges_[6], vertices_[3], vertices_[6]);	// e6
    updateEdge(edges_[7], vertices_[4], vertices_[5]);	// e7
    updateEdge(edges_[8], vertices_[4], vertices_[7]);	// e8
    updateEdge(edges_[9], vertices_[5], vertices_[8]);	// e9
    updateEdge(edges_[10], vertices_[6], vertices_[7]);	// e10
    updateEdge(edges_[11], vertices_[7], vertices_[8]);	// e11
  }

  private void updateEdge(Edge e, Vertex vx, Vertex vy) {
    e.setWeight(e.getNumber()*3);     // A meaningless random weight.
    e.setVertexX(vx);
    e.setVertexY(vy);
    vx.incrementDegrees();
    vx.addEdge(e);
    if (!isDirected()) {
      updateEdge(e, vy, vx);
    }
  }

  public boolean isDirected() {
    return directed_;
  }

  private void bfs(Graph g) {
    SysOut.PrintSeparator();
    System.out.println("Breath Firsst Search");
    BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);
    bfs.search();
   }

  private void dfs(Graph g) {
    SysOut.PrintSeparator();
    System.out.println("Depth First Search");
    DepthFirstSearch dfs = new DepthFirstSearch(g, 0);
    dfs.search();
  }

  private void printVertices() {
    SysOut.PrintSeparator();
    System.out.println("List Vertices");
    for (int i=0; i < nVertices_; i++) {
      Vertex v = vertices_[i];
      System.out.println(
      String.format("v=%02d degrees=%02d isDiscovered=%s isProcessed=%s",
      v.getNumber(),
      v.degreeCount(),
      v.isDiscovered(),
      v.isProcessed()
      ));
    }
  }

  System.out.println("List Edges");
    for (int i=0; i < nEdges_; i++) {
      printEdge(edges_[i], false);
    }
  }

  private void printVerticesOutLinks() {
    SysOut.PrintSeparator();
    System.out.println("List Vertices Outlinks");
    for (int i=0; i < nVertices_; i++) {
      Vertex v = vertices_[i];
      System.out.print(String.format("v=%02d edges { ", v.getNumber()));
      List<Edge> edges = v.getEdges();
      for (int j=0; j < edges.size(); j++) {
        Edge e = edges.get(j);
        System.out.print( String.format("%02d ", e.getNumber()));
      }
      System.out.println("}");
    }
  }

  private void printEdge(Edge e, boolean sameLine) {
    Vertex x = e.getVertexX();
    Vertex y = e.getVertexY();
    System.out.print(
        String.format("e=%02d (x=%02d, y=%02d) weight=%02d",
          e.getNumber(),
          (x == null) ? null : x.getNumber(),
          (y == null) ? null : y.getNumber(),
          e.getWeight()
          )
        );
    if (sameLine) {
      System.out.print(" | ");
    }
    else {
      System.out.println();
    }
  }

  public int vectorCount() {
    return nVertices_;
  }

  public int edgeCount() {
    return nEdges_;
  }

  public Vertex vertexAt(int n) {
    return vertices_[n];
  }

  public Edge edgeAt(int n) {
    return edges_[n];
  }
}
