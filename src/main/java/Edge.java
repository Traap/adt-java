/**
 * Edge is modeled after "The algorithm design manual".
 *
 */

public class Edge {

  private int number_;
  private int weight_;      // edge weight, if any.
  private Vertex vX_;			  // x Vector
  private Vertex vY_;			  // y Vector

  public Edge(int number) {
    number_ = number;
    weight_ = 0;
  }

  public int getNumber() {
    return number_;
  }

  public int setNumber(int number) {
    return number_ = number;
  }

  public int getY() {
    return vY_.getNumber();
  }

  public int getWeight() {
    return weight_;
  }

  public void setWeight(int weight) {
    weight_ = weight;
  }

  public void setVertexX(Vertex vertex) {
    vX_ = vertex;
  }

  public Vertex getVertexX() {
    return vX_;
  }

  public void setVertexY(Vertex vertex) {
    vY_ = vertex;
  }

  public Vertex getVertexY() {
    return vY_;
  }

  public Vertex opposite(Vertex v) {
    if (isConnected(v)) {
      return (v.equals(vX_)) ? vY_ : vX_;
    }
    else {
      return null;
    }
  }

  public boolean isConnected(Vertex v) {
    return vX_.equals(v) || vY_.equals(v);
  }
}
