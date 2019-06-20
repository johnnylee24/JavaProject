public class ArraySparseArray implements SparseArray {
  
  private static class Pair {
    private int index;
    private int value;
    
    public Pair(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
  
  //will reference the array that will store the data items.
  private Pair[] arr;
  private int numElements;
  
  //creates the array behind the scenes to hold initSize elements
  public ArraySparseArray(int initSize) {
    this.arr = new Pair[initSize];
    this.numElements = 0;
  }
    
  // returns how many (meaningful) elements are being held by the array
  public int size() {
    return this.numElements;
  }
  
  public boolean isEmpty() {
    return this.numElements == 0;
  }
  
  //return 0 if index is not there and the associated value if it is there.
  public int get(int index) {
    for (int i = 0; i < this.numElements; i++) {
      if (this.arr[i] != null && this.arr[i].index == index)
        return this.arr[i].value;
    }
    return 0;
  }
   
  //if index is in the array, then change the associated value and return the old value.
  //If it isn‘t there, add it in sorted order by index into the array.
  public int set(int index, int value) { 
    for (int i = 0; i < this.numElements; i++) {
      if (this.arr[i] != null && this.arr[i].index == index) {
        int result = this.arr[i].value;
        this.arr[i].value = value;
        return result;
      }
    }
    this.arr[this.numElements] = new Pair(index, value);
    this.numElements++;
    for (int i = 0; i < this.numElements; i++) {
      for (int j = 0; j < this.numElements-1; j++) {
        Pair p1 = this.arr[j];
        Pair p2 = this.arr[j+1];
        if (p1.index > p2.index) {
          this.arr[j] = p2;
          this.arr[j+1] = p1;
        }
      }
    }
    return value;
  }
  
  //remove the index from the array.
  public int remove(int index) {
    int result = this.get(index);
    for (int i = 0; i < this.numElements; i++) {
      if (this.arr[i] != null && this.arr[i].index == index) {
        for (int j = i; j < this.numElements-1; j++) {
          this.arr[j] = this.arr[j+1];
        }
        this.arr[this.numElements-1] = null;
        this.numElements--;
        break;
      }
    }
    return result;
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