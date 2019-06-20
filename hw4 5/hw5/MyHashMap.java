import java.util.*;

 
public class MyHashMap {
    /**
     * inner static class
     */
    static class Pair {
        private String key;
        private Integer value;

        /**
         * Constructs a pair
         *
         * @param str
         * @param value
         */
        Pair(String str, Integer value) {
            this.key = str;
            this.value = value;
        }

        /**
         * Returns the key
         *
         * @return String
         */
        public String getKey() {
            return this.key;
        }

        /**
         * Returns the value
         *
         * @return integer
         */
        public Integer getValue() {
            return this.value;
        }

        /**
         * Changes the value to a new value and returns the old value.
         *
         * @param value
         */
        public void setValue(Integer value) {
            this.value = value;
        }
    }

    private ArrayList<LinkedList<Pair>> theTable;

    private int size;
    private int cap;
    private int threshold;
    private float loadFactor;

    /**
     * MyHashMap constructor
     * input an initial capacity ,choose the nearest prime as the capacity
     *
     * @param initialCapacity int
     */
    public MyHashMap(int initialCapacity) {
        this.size = 0;
        this.loadFactor = 0.75f;
        this.cap = nextPrime(initialCapacity);
        this.threshold = (int) (cap * loadFactor);
        this.theTable = new ArrayList<LinkedList<Pair>>();
        for (int i = 0; i < this.cap; i++) {
            this.theTable.add(new LinkedList<Pair>());
        }
    }

    /**
     * decide whether a number is prime
     *
     * @param n int
     * @return boolean
     */
    private boolean isPrime(int n) {
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        int step = 4, m = (int) Math.sqrt(n) + 1;
        for (int i = 5; i < m; step = 6 - step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * return the nearest prime bigger than n
     *
     * @param n int
     * @return int
     */
    private int nextPrime(int n) {
        boolean prime = isPrime(n);
        while (!prime) {
            prime = isPrime(n++);
        }
        return n;
    }

    /**
     * insert this key-value pair into the map under the following rules:
     * If key already exists in the map, change its value to value, overwriting what was there
     * If key is not already there, insert this key-value pair into the map.
     *
     * @param key   String
     * @param value Integer
     */
    public void put(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        int index = Math.abs(key.hashCode()) % this.cap;
        LinkedList<Pair> datalist = this.theTable.get(index);

        // check whether the pair exists in the data list
        for (int i = 0; i < datalist.size(); i++) {
            // find the data
            if (datalist.get(i).getKey().equals(key)) {
                datalist.remove(i);
                this.size -= 1;
                break;
            }
        }

        datalist.add(new Pair(key, value));
        this.size++;

        //reshape hashtable
        if (this.size > this.threshold) {
            this.cap = nextPrime(cap * 2);
            this.threshold = (int) (this.cap * this.loadFactor);
            //table list expansion
            ArrayList<LinkedList<Pair>> temp = new ArrayList<LinkedList<Pair>>();
            for (int i = 0; i < this.cap; i++) {
                temp.add(new LinkedList<Pair>());
            }
            for (LinkedList<Pair> linkedList : this.theTable) {
                if (linkedList != null) {
                    for (Pair p : linkedList) {
                        int idx = Math.abs(p.getKey().hashCode()) % cap;
                        LinkedList<Pair> newlist = temp.get(idx);
                        if (newlist == null) {
                            newlist = new LinkedList<Pair>();
                            temp.set(idx, newlist);
                        }
                        newlist.add(new Pair(p.getKey(), p.getValue()));
                    }
                }
            }
            this.theTable = temp;
        }
    }

    /**
     * returns true if key already exists in the map.
     *
     * @param key String
     * @return boolean
     */
    public boolean containsKey(String key) {
        int index = Math.abs(key.hashCode()) % this.cap;
        LinkedList<Pair> list = this.theTable.get(index);
        for (Pair p : list) {
            if (p.getKey().equals(key))
                return true;
        }
        return false;
    }

    /**
     * returns true if value appears in the map
     *
     * @param value Integer
     * @return boolean
     */
    public boolean containsValue(Integer value) {
        for (LinkedList<Pair> list : this.theTable) {

            for (Pair p : list) {
                if (p.getValue() == value)
                    return true;
            }

        }
        return false;
    }

    /**
     * If key is in the map, remove it.
     *
     * @param key String
     * @return boolean
     */
    public boolean remove(String key) {
        int index = Math.abs(key.hashCode()) % this.cap;
        LinkedList<Pair> list = this.theTable.get(index);

        for (Pair p : list) {
            if (p.getKey().equals(key)) {
                list.remove(p);
                this.size--;
                return true;
            }

        }
        return false;
    }

    /**
     * If key is in the map, return the associated value.
     * If key is NOT in the map, return null.
     *
     * @param key String
     * @return Integer
     */
    public Integer get(String key) {
        int index = Math.abs(key.hashCode()) % this.cap;
        LinkedList<Pair> list = this.theTable.get(index);
        for (Pair p : list) {
            if (p.getKey().equals(key))
                return p.value;
        }
        return null;
    }

    /**
     * Returns a Set of all pairs in the map.
     *
     * @return Set<Pair>
     */
    public Set<Pair> entrySet() {
        Set<Pair> data = new HashSet<>();
        for (LinkedList<Pair> list : this.theTable) {
            for (Pair p : list) {
                data.add(p);
            }
        }
        return data;
    }

    /**
     * Returns a list of all of the associated values in the map.
     *
     * @return List<Integer>
     */
    public List<Integer> values() {
        List<Integer> value = new ArrayList<>();
        for (LinkedList<Pair> list : this.theTable) {
            for (Pair p : list) {
                value.add(p.value);
            }
        }
        return value;
    }

    /**
     * Returns a set of all keys in the map.
     *
     * @return Set<String>
     */
    public Set<String> keySet() {
        Set<String> key = new HashSet<>();
        for (LinkedList<Pair> list : this.theTable) {
            for (Pair p : list)
                key.add(p.getKey());
        }
        return key;
    }

    /**
     * returns true if the number of elements in the map is 0
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * returns the size of table
     *
     * @return int
     */
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "theTable=" + theTable.toString() +
                ", size=" + size +
                ", cap=" + cap +
                ", threshold=" + threshold +
                ", loadFactor=" + loadFactor +
                '}';
    }
}