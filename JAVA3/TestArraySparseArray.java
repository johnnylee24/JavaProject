public class TestArraySparseArray {
 
  public static void main(String[] args) {
    System.out.println("Constructing ArraySparseArray ...");
    ArraySparseArray sparseArray = new ArraySparseArray(9);
    System.out.println("sparseArray.size(): " + sparseArray.size());
    System.out.println("sparseArray.isEmpty(): " + sparseArray.isEmpty());
    System.out.println("Adding 9 elements ...");
    for (int i = 0; i < 9; i++) {
      sparseArray.set(i, i+1);
      System.out.println(sparseArray.toString());
    }
    System.out.println("Setting 9 elements ...");
    for (int i = 0; i < 9; i++) {
      sparseArray.set(i, 9-i);
      System.out.println(sparseArray.toString());
    }
    System.out.println("sparseArray.size(): " + sparseArray.size());
    System.out.println("sparseArray.isEmpty(): " + sparseArray.isEmpty());
    System.out.println("Removing 9 elements ...");
    for (int i = 0; i < 9; i++) {
      sparseArray.remove(i);
      System.out.println(sparseArray.toString());
    }
    System.out.println("sparseArray.size(): " + sparseArray.size());
    System.out.println("sparseArray.isEmpty(): " + sparseArray.isEmpty());
  }
  
}