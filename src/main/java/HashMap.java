public class HashMap {
  int SIZE_OF_TABLE = 128;
  HashEntry[] table;

  HashMap() {
    table = new HashEntry[SIZE_OF_TABLE];
    for (int i = 0; i < SIZE_OF_TABLE; i++) {
        table[i] = null;
    }
  }

  public void put(int key, int value) {
    int index = hashCodeNew(key);
    System.out.println(index);
    HashEntry hashEntry = new HashEntry(key, value);
    if (table[index] == null) {
        table[index] = hashEntry;
    }
    else {
      HashEntry runner = table[index];
      while (runner.getNext() != null) {
        if (runner.getKey() == hashEntry.getKey()) {
          runner.setValue(hashEntry.getValue());
          break;
        }
        else {
          runner = runner.getNext();
        }
      }
      if (runner.getNext() == null) {
        if (runner.getKey() == hashEntry.getKey()) {
          runner.setValue(hashEntry.getValue());
        } 
        else {
          runner.setNext(hashEntry);
        }
      }
    }
  }

  public int get(int key) {
    int index = hashCodeNew(key);
    if (table[index] == null) {
        return -1;
    }
    else {
      HashEntry runner = table[index];
      if (runner.getKey() == key) {
        return runner.getValue();
      }
      while (runner.getNext() != null) {
        if (runner.getKey() == key) {
          return runner.getValue();
        }
      }
      return -1;
    }
  }

  public int hashCodeNew(int h) {
    h ^= (h >>> 20) ^ (h >>> 12);
    int hashCode = h ^ (h >>> 7) ^ (h >>> 4);
    return hashCode % SIZE_OF_TABLE;
  }
}
