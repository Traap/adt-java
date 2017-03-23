public class HashEntry {
  private int key;
  private int value;
  private HashEntry next;

  HashEntry() {
    this.key = 0;
    this.value = 0;
    this.next = null;
  }

  public HashEntry(int key, int value) {
    this.key = key;
    this.value = value;
  }

  public int       getKey()                { return this.key; }
  public void      setKey(int key)         { this.key = key; }

  public int       getValue()              { return this.value; }
  public void      setValue(int value)     { this.value = value; }
  
  public HashEntry getNext()               { return this.next; }
  public void      setNext(HashEntry next) { this.next = next; }
}
