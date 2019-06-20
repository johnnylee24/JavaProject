import java.util.*;

public interface SparseArray {
  public int size();
  public boolean isEmpty();
  public int get(int index);
  public int set(int index, int value);
}