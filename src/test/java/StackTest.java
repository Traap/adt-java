import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

  @Test
  public void testPushPopIsEqual() {
    Stack stack = new Stack();

    String a0 = "A";
    stack.push(a0);
    String a1 = (String) stack.pop();
    assertEquals(a0, a1);
  }

  @Test
  public void testIsEmpty() {
    Stack stack = new Stack();

    assertTrue(stack.isEmpty());
  }

  @Test
  public void testStackSizeIsThree() {
    Stack stack = new Stack();
    String s0 = "A";
    stack.push(s0);
    stack.push(s0);
    stack.push(s0);
    int a0  = stack.size();
    assertEquals(a0, 3);
  }

  @Test
  public void testStackIsFull() {
    Stack stack = new Stack();
    String s0 = "A";
    // Fill the stack.
    for (int i = 0; i < Stack.MAX; i++) {
      assertTrue(stack.push(s0));
    }
    // Attmpt to overfill.
    assertFalse(stack.push(s0));
  }

  @Test
  public void testStackBecomesEmpty() {
    Stack stack = new Stack();
    String s0 = "A";
    // Fill the stack.
    for (int i = 0; i < Stack.MAX; i++) {
      assertTrue(stack.push(s0));
    }
    // Empty the stack.
    for (int i = 0; i < Stack.MAX; i++) {
      assertNotNull(stack.pop());
    }
    // The stack is empty.
    assertTrue(stack.isEmpty());
  }
}
