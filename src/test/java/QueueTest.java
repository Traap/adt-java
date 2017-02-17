import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
  private String s0;
  private String s1;
  private String s2;
  private Node n0;
  private Node n1;
  private Node n2;

  @Before
  public void setUp() {
    // Setup three test nodes.
    s0 = "This is the first meaningless string.";
    n0 = new Node(s0);

    s1 = "This is the second meaningless string.";
    n1 = new Node(s1);

    s2 = "This is the third meaningless string.";
    n2 = new Node(s2);

    assertNotEquals(n0, n1);
    assertNotEquals(n0, n2);
    assertNotEquals(n1, n2);
  }

  @Test
  public void testIsEmpty() {
    Queue queue = new Queue();

    assertTrue(queue.isEmpty());
  }

  @Test
  public void testEnqueueAndDequeue() {
    Queue q = new Queue();
    q.enqueue(n0);
    q.enqueue(n1);
    q.enqueue(n2);

    Node m0 = q.dequeue();
    Node m1 = q.dequeue();
    Node m2 = q.dequeue();

    assertEquals(n0, m0);
    assertEquals(n1, m1);
    assertEquals(m2, m2);

    assertTrue(q.isEmpty());
  }
}
