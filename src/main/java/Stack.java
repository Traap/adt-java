public class Stack {
  public static int MAX = 10;
  private int size_;
  private Object[] stack_;

  public Stack() {
    stack_ = new Object[Stack.MAX];
  }

  public boolean isEmpty() {
    return size_ == 0;
  }

  public void push(Object o) { 
    if (size_ < Stack.MAX) { 
      stack_[size_] = o;
      size_++;
    }
    else {
      System.out.println("Stack full.  Not pushed: " + o);
    }
  }

  public Object pop() {
    Object o = null;
    if (!isEmpty()) {
      int i = size_ - 1;
      o = stack_[i];
      stack_[i] = null;
      size_--;
    }
    else {
      System.out.println("Stack empty null returned");
    }
    return o;
  }

  public int size(){
    return size_;
  }

}

