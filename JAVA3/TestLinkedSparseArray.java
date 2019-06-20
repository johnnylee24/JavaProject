public class TestLinkedSparseArray {
  
  public static void main(String[] args) {
    System.out.println("Constructing LinkedSparseArray ...");
    LinkedSparseArray sparseArray = new LinkedSparseArray();
    System.out.println("sparseArray.size(): " + sparseArray.size());
    System.out.println("sparseArray.isEmpty(): " + sparseArray.isEmpty());
    System.out.println("Setting 9 elements ...");
    for (int i = 0; i < 9; i++) {
      sparseArray.set(i, 9-i);
      System.out.println(sparseArray.toString());
    }
    System.out.println("sparseArray.size(): " + sparseArray.size());
    System.out.println("sparseArray.isEmpty(): " + sparseArray.isEmpty());
    System.out.println("Getting 9 elements ...");
    for (int i = 0; i < 9; i++) {
      System.out.println("sparseArray.get(" + i + "): " + sparseArray.get(i));
    }
    System.out.println("sparseArray.size(): " + sparseArray.size());
    System.out.println("sparseArray.isEmpty(): " + sparseArray.isEmpty());
  }
  
}