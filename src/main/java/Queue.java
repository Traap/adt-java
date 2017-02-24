public class Queue {
  private LinkList ll_;

  public Queue() {
    ll_ = new LinkList();
  }

  public boolean isEmpty() {
    return ll_.isEmpty();
  } 
  public void enqueue(Node node) {
    ll_.addAtEnd(node);
  }

  public Node dequeue() {
    return ll_.removeAtFront();
  }
}
