public class LinkedSparseArray {
  
  private static class SListNode {
    private int index;
    private int value;
    private SListNode next;
    
    SListNode(int index, int value, SListNode next) {
      this.index = index;
      this.value = value;
      this.next = next;
    }
  }
  
  private SListNode head;
  
  public int size() {
    int n = 0;
    SListNode current = head;
    while (current != null) {
      n++;
      current = current.next;
    }
    return n;
  }
  
  public boolean isEmpty() {
    return this.head == null;
  }
  
  //return 0 if index is not there. If it is there return the associated value.
  public int get(int index) {
    SListNode current = head;
    while (current != null) {
      if (current.index == index)
        return current.value;
      current = current.next;
    }
    return 0;
  }
  
  //if index is there, change the associated value and return the old value.
  //If index is not there, create a new node and attach it
  //to the list at the beginning of the list. 
  public int set(int index, int value) {
    SListNode current = head;
    while (current != null) {
      if (current.index == index) {
        int result = current.value;
        current.value = value;
        return result;
      }
      current = current.next;
    }
    head = new SListNode(index, value, head);
    return value;
  }
  
  //create a representation for the SparseArray. 
  public String toString() {
    String result = "[";
    int elements = 0;
    int i = 0;
    while (elements < this.size()) {
      if (this.get(i) != 0)
        elements++;
      result += this.get(i) + ", ";
      i++;
    }
    if (result.length() > 2)
      result = result.substring(0, result.length()-2);
    result += "]";
    return result;
  }
}