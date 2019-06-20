import java.util.HashMap;

/**
 *
 */
public class test {
    public static void main(String[] args) {

        MyHashMap my = new MyHashMap(4);
        my.put("one",1);
        my.put("two",2);
        my.put("two",3);
        my.put("three",3);
        my.put("four",4);
        my.put("five",5);
        my.put("six",6);
        my.put("seven",7);

        System.out.println(my.toString());
        System.out.println(my.containsKey("two"));
        System.out.println(my.containsValue(2));
        System.out.println(my.get("two"));

        System.out.println(my.size());
        System.out.println(my.keySet());
        System.out.println(my.entrySet());
        System.out.println(my.remove("one"));
        System.out.println(my.size());

        System.out.println(my.remove("111"));
        System.out.println(my.size());

    }
}
