import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

  @Test 
  public void testDefaultNodeConsructor() {
    Node n = new Node();
    assertNull(n.getData());
    assertNull(n.getNext());
  }

  @Test 
  public void testNodeConsructorWithObject() {
    String a0 = "A meaningless string.";
    Node n = new Node(a0);

    String a1 = (String) n.getData();
    assertEquals(a0, a1);

    Object n0 = n.getNext();
    assertNull(n0);
  }

  @Test 
  public void testSetAndGetNodeData() {
    String a0 = "A meaningless string.";
    Node n = new Node(a0);

    String a1 = (String) n.getData();
    assertEquals(a0, a1);

    String a2 = "This is a second meaningless string.";
    assertNotEquals(a2, a0);

    n.setData(a2);

    String a3 = (String) n.getData();
    assertNotEquals(a3, a0);
    assertEquals(a3, a2);
  }


  @Test 
  public void testSetAndGetNextNode() {
    // Create two different nodes.
    String a0 = "A meaningless string.";
    Node n0 = new Node(a0);

    String a1 = "This is a second meaningless string.";
    Node n1 = new Node(a1);

    assertNotEquals(n0, n1);

    // Point n0 to n1 and n1 to n0. (Yes it's circular.)
    n0.setNext(n1);
    n1.setNext(n0);

    // Node n3 is n1 and n4 is n0.
    Node n3 = n0.getNext();
    Node n4 = n1.getNext();

    assertNotEquals(n3, n0);
    assertNotEquals(n4, n1);

    assertEquals(n3, n1);
    assertEquals(n4, n0);
  }
}
