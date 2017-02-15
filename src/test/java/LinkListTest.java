import org.junit.Test;
import static org.junit.Assert.*;

public class LinkListTest {

  @Test
  public void testIsEmpty() {
    LinkList ll = new LinkList();
    assertTrue(ll.isEmpty());
  }

  @Test
  public void testAddNodes() {
    // Setup three test nodes.
    String s0 = "This is a meaningless string.";
    Node   n0 = new Node(s0);

    String s1 = "This is a meaningless string.";
    Node   n1 = new Node(s1);

    String s2 = "This is a meaningless string.";
    Node   n2 = new Node(s2);

    assertEquals(n0, n0);
    assertEquals(n1, n1);
    assertEquals(n2, n2);

    assertNotEquals(n0, n1);
    assertNotEquals(n0, n2);

    assertNotEquals(n1, n2);

    // Add nodes to LinkList
    LinkList ll = new LinkList();
    ll.add(n0);
    ll.add(n1);
    ll.add(n2);

    // Nodes m0, m1, and, m2 equals n0, n1, and n2, respectively.
    Node m0 = ll.getHead();
    Node m1 = m0.getNext();
    Node m2 = m1.getNext();

    assertEquals(m0, n0);
    assertEquals(m1, n1);
    assertEquals(m2, n2);

    // Node m2 is the tail.
    assertNull(m2.getNext());
  }

  @Test
  public void testRemoveNode() {
    // Setup three test nodes.
    String s0 = "This is a meaningless string.";
    Node   n0 = new Node(s0);

    String s1 = "This is a meaningless string.";
    Node   n1 = new Node(s1);

    String s2 = "This is a meaningless string.";
    Node   n2 = new Node(s2);

    assertEquals(n0, n0);
    assertEquals(n1, n1);
    assertEquals(n2, n2);

    assertNotEquals(n0, n1);
    assertNotEquals(n0, n2);

    assertNotEquals(n1, n2);

    // Add nodes to LinkList
    LinkList ll = new LinkList();
    ll.add(n0);
    ll.add(n1);
    ll.add(n2);

    // remove node n1 after verifing n4 cannot be removed.
    Node n4 = new Node();
    assertFalse(ll.remove(n4));
    assertTrue(ll.remove(n1));

    // Node m0 = n0, m1 = n2, and m2 = null;
    Node m0 = ll.getHead();
    Node m1 = m0.getNext();
    Node m2 = m1.getNext();

    assertEquals(m0, n0);
    assertEquals(m1, n2);
    assertNull(m2);
  }
}
