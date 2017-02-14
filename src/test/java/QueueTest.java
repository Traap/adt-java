import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

  @Test
  public void testIsEmpty() {
    Queue queue = new Queue();

    boolean a0 = queue.isEmpty();
    assertEquals(a0, true);
  }

}
