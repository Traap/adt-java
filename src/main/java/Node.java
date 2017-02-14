public class Node {
  private Object data_;
  private Node next_;

  public Node() {
    this.data_ = null; 
    this.next_ = null;
  }

  public Node(Object o) {
    this.data_ = o;
    this.next_ = null;
  }

  public Object getData() {
    return this.data_;
  }

  public void setData(Object o) {
    this.data_ = o;
  }

  public Node getNext() {
    return this.next_;
  }

  public void setNext(Node n) {
    this.next_ = n;
  }

}
