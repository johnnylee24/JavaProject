import java.util.HashMap;

/**
 *
 */
public class test {
    public static void main(String[] args) {
        String[] authors1 = {"amber","bob"};
        String[] authors2 = {"anna","bob"};

        Book b1 = new Book("book1","tututu",2018,authors1,2);
        Book b2 = new Book("book2","biubiu",2017,authors2,2);
        Book b3 = new Book("book3","biubiu",2017,authors2,2);

        System.out.println(b1.toString());

        if(b3.equals(b2)){
            System.out.println("yes,right");
        }

        BookDatabase bd = new BookDatabase();
        bd.addBook(b1);
        bd.addBook(b2);
        bd.addBook(b3);

        System.out.println(bd.searchByAuthor("anna"));
        System.out.println(bd.searchByTitle("book1"));
        System.out.println(bd.searchByPublisher("biubiu"));
    }
}
