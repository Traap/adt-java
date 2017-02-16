import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkListTest {
  private String s0;
  private String s1;
  private String s2;
  private Node n0;
  private Node n1;
  private Node n2;

  @Before
  public void setUp() {
    // Setup three test nodes.
    s0 = "This is a meaningless string.";
    n0 = new Node(s0);

    s1 = "This is a meaningless string.";
    n1 = new Node(s1);

    s2 = "This is a meaningless string.";
    n2 = new Node(s2);

    assertNotEquals(n0, n1);
    assertNotEquals(n0, n2);
    assertNotEquals(n1, n2);
  }

  @Test
  public void testIsEmpty() {
    LinkList ll = new LinkList();
    assertTrue(ll.isEmpty());
  }

  @Test
  public void testAddNodes() {
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

  @Test
  public void testFindNode() {
    // Add nodes to LinkList
    LinkList ll = new LinkList();
    ll.add(n0);
    ll.add(n1);
    ll.add(n2);

    // Find n0, n1, and  n2.
    assertTrue(ll.find(n0));
    assertTrue(ll.find(n1));
    assertTrue(ll.find(n2));

    // Remove n1 and then 
    assertTrue(ll.remove(n1));
    assertFalse(ll.find(n1));
  }

  @Test
  public void testAddAtEnd() {
    // Add nodes to LinkList
    LinkList ll = new LinkList();
    ll.addAtEnd(n0);
    ll.addAtEnd(n1);
    ll.addAtEnd(n2);

    // Find n0, n1, and  n2.
    assertTrue(ll.find(n0));
    assertTrue(ll.find(n1));
    assertTrue(ll.find(n2));
  }

  @Test
  public void testAddAtFront() {
    // Add nodes to LinkList
    LinkList ll = new LinkList();
    ll.addAtFront(n0);
    ll.addAtFront(n1);
    ll.addAtFront(n2);

    // Find n0, n1, and  n2.
    assertTrue(ll.find(n0));
    assertTrue(ll.find(n1));
    assertTrue(ll.find(n2));
  }

  @Test
  public void testRemoveAtEnd() {
    // Add nodes to LinkList
    LinkList ll = new LinkList();
    ll.addAtEnd(n0);
    ll.addAtEnd(n1);
    ll.addAtEnd(n2);

    // Find n0, n1, and  n2.
    assertTrue(ll.find(n0));
    assertTrue(ll.find(n1));
    assertTrue(ll.find(n2));

    // Remove n2.
    assertTrue(ll.removeAtEnd());
    assertFalse(ll.find(n2));

    // Remove n1.
    assertTrue(ll.removeAtEnd());
    assertFalse(ll.find(n1));

    // Remove n0.
    assertTrue(ll.removeAtEnd());
    assertFalse(ll.find(n0));

    // Should be empty.
    assertTrue(ll.isEmpty());
  }

  @Test
  public void testRemoveAtFront() {
    // Add nodes to LinkList
    LinkList ll = new LinkList();
    ll.addAtFront(n0);
    ll.addAtFront(n1);
    ll.addAtFront(n2);

    // Find n0, n1, and  n2.
    assertTrue(ll.find(n0));
    assertTrue(ll.find(n1));
    assertTrue(ll.find(n2));

    // Remove n2.
    assertTrue(ll.removeAtFront());
    assertFalse(ll.find(n2));

    // Remove n1.
    assertTrue(ll.removeAtFront());
    assertFalse(ll.find(n1));

    // Remove n0.
    assertTrue(ll.removeAtFront());
    assertFalse(ll.find(n0));

    // Should be empty.
    assertTrue(ll.isEmpty());
  }
}
