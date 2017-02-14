public class Queue {
  public static int MAX = 10;
  private int size_;
  private Object[] queue_;

  public Queue() {
    queue_ = new Object[Queue.MAX];
  }

  public boolean isEmpty() {
    return size_ == 0;
  }

  public boolean enqueue(Object o) {
    boolean b = false;
    return b;
  }

  public Object dequeue() {
    Object o = null;
    return o;
  }

  public int size(){
    return size_;
  }

}

