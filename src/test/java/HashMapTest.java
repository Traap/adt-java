import org.junit.Test;
import static org.junit.Assert.*;

public class HashMapTest {

  @Test
  public void testBasic() {
      HashMap hashMap = new HashMap();
      hashMap.put(10, 20);
      hashMap.put(20, 11);
      hashMap.put(21, 1);
      hashMap.put(20, 10);

      int value = hashMap.get(20);
      assertEquals(10, value);
  }
}
