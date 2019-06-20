import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class BookDatabase {
    private Map<String, Book> bookData;

    /**
     * constructor of BookDatabase
     */
    private BookDatabase() {
        this.bookData = new HashMap<String, Book>();
    }

    /**
     * search bookdatabase by book title
     * @param title String
     * @return Book
     */
    Book searchByTitle(String title) {
        if (bookData.containsKey(title)) {
            return bookData.get(title);
        }
        return null;
    }

    /**
     * search bookdatabase by book Author
     * @param author String
     * @return Book Set
     */
    Set<Book> searchByAuthor(String author) {
        Set<Book> bookset = new HashSet<>();
        for (Book book : bookData.values()) {
            String[] authors = book.getAuthors();
            for (int i = 0; i < book.getNumAuthors(); i++) {
                if (authors[i].equals(author)) {
                    bookset.add(book);
                }
            }
        }
        return bookset;
    }

    /**
     * search bookdatabase by book publication year
     * @param year int
     * @return Book set
     */
    Set<Book> publishedBefore(int year) {
        Set<Book> bookset = new HashSet<>();
        for (Book book : bookData.values()) {
            if (year == book.getYearOfPublication()) {
                bookset.add(book);
            }
        }
        return bookset;
    }

    /**
     * search bookdatabase by book publisher
     * @param publisher String
     * @return Book set
     */
    Set<Book> searchByPublisher(String publisher) {
        Set<Book> bookset = new HashSet<Book>();
        for (Book book : bookData.values()) {
            if (publisher.equals(book.getPublisher())) {
                bookset.add(book);
            }
        }
        return bookset;
    }

    /**
     * add book to book database
     * @param book Book
     */
    void addBook(Book book) {
        String title = book.getTitle();
        if(!this.bookData.containsKey(title)){
            this.bookData.put(title,  book);
        }
    }

    /**
     * remove book from book database
     * @param title String
     */
    void removeBook(String title) {
        if (this.bookData.containsKey(title)) {
            this.bookData.remove(title);
        }
    }

    /**
     * Detail information of book database object
     * @return String
     */
    @Override
    public String toString() {
        return "BookDatabase{" +
                "bookData=" + bookData +
                '}';
    }
}
