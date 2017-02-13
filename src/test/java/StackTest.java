import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
  @Test
  public void testPushPopA(){
    Stack stack = new Stack();

    String a0 = "A";
    stack.push(a0);
    String a1 = (String) stack.pop();
    assertEquals(a0, a1);
  }
}
