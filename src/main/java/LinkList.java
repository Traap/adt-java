public class LinkList {
  private Node head_;
  private Node tail_;

  public LinkList() {
    this.head_ = null;
    this.tail_ = null;
  }

  public Node getHead() {
    return this.head_;
  }

  public void add(Node node) {
    if (null == this.head_) {
      // Empty list.
      this.head_ = node;
      this.tail_ = node;
    }
    else {
      this.tail_.setNext(node);
      this.tail_ = node;
    }
  }

  public void addAtEnd(Node node) {
    add(node);
  }

  public void addAtFront(Node node) {
    if (null == this.head_) {
      // Empty list.
      this.head_ = node;
      this.tail_ = node;
    }
    else {
      node.setNext(this.head_);
      this.head_ = node;
    }
  }

  public boolean remove(Node node) {
    boolean b = false;

    // Avoid searching when node is null or LinkList is empty.
    if ((null != node) && !isEmpty()) {
      // Search for node.
      Node prev = head_;
      Node next = head_;

      while(null != next && false == b) {
        if (next == node) {
          prev.setNext(next.getNext());
          prev = next.getNext();
          if (this.head_ == node) {
            this.head_ = prev;
          }
          if (this.tail_ == node) {
            this.tail_ = prev;
          }
          b = true;
        }
        else {
          prev = next;
          next = next.getNext();
        }
      }
    }
    return b;
  }

  public Node removeAtEnd() {
    Node node  = null;
    if (!isEmpty()) {
      // Find End - 1.
      Node next = this.head_;
      Node prev = null;

      while(null != next && null == node) {
        if (next == this.tail_) {
          node = this.tail_;
          if (this.head_ == this.tail_) {
            this.head_ = null;
            this.tail_ = null;
          }
          else {
            this.tail_ = prev;
            this.tail_.setNext(null);
          }
        }
        else {
          prev = next;
          next = next.getNext();
        }
      }
    }
    return node;
  }

  public Node removeAtFront() {
    Node node = null;
    if (!isEmpty()) {
      node = this.head_;
      if (this.head_ == this.tail_) {
        this.head_ = null;
        this.tail_ = null;
      }
      else {
        this.head_ = this.head_.getNext();
      }
      // Node returned cannot refer to another node.
      node.setNext(null);
    }
    return node;
  }

  public boolean isEmpty() {
    return null == this.head_;
  }

  public boolean find(Node node) {
    boolean b = false;

    // Avoid searching when node is null or LinkList is empty.
    if ((null != node) && !isEmpty()) {
      // Search for node.
      Node next = head_;

      while(null != next && false == b) {
        if (next == node) {
          b = true;
        }
        else {
          next = next.getNext();
        }
      }
    }
    return b;
  }

}
