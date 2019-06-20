import java.util.Arrays;
import java.util.Objects;

/**
 *
 */
public class Book implements Comparable<Book> {
    private String title;
    private String publisher;
    private int yearOfPublication;
    private String[] authors;
    private int numAuthors;

    /**
     * constructor of Book class
     * @param title
     * @param publisher
     * @param yearOfPublication
     * @param authors
     * @param numAuthors
     */
    private Book(String title, String publisher, int yearOfPublication, String[] authors, int numAuthors) {
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.authors = authors;
        this.numAuthors = numAuthors;
    }

    /**
     * return title of the book
     * @return String
     */
    public String getTitle() {
        return title;
    }


    /**
     * set book title
     * @param title String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * return publisher of the book
     * @return String
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * set book publisher
     * @param publisher String
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * return book publication year
     * @return int
     */
    public int getYearOfPublication() {
        return yearOfPublication;
    }

    /**
     * set book publication year
     * @param yearOfPublication int
     */
    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    /**
     * return book authors
     * @return String[]
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     * set book authores
     * @param authors String[]
     */
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    /**
     * return number of authors
     * @return int
     */
    public int getNumAuthors() {
        return numAuthors;
    }

    /**
     * set number of authers
     * @param numAuthors int
     */
    public void setNumAuthors(int numAuthors) {
        this.numAuthors = numAuthors;
    }

    /**
     * compare two object to decide whether they are same or not
     * @param o book object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }


    /**
     * Detail information of book object
     * @return String
     */
    @Override
    public String toString() {
        String authorsinfo = "";
        for(int i = 0;i< this.authors.length;i++)
            if (i != this.authors.length - 1) {
                authorsinfo += this.authors[i] + " and ";
            } else {
                authorsinfo += this.authors[i];
            }
        return "Title: " + title + '\n' +
                "Authors: " + authorsinfo+"\n"+
                "Publisher: " + publisher + '\n' +
                "Year: " + yearOfPublication +"\n";
    }

    /**
     * compare this object with other
     * @param o book object
     * @return int
     */
    @Override
    public int compareTo(Book o) {
        if (this.title.equals(o.title)){
            return 0;
        }
        return -1;
    }
}
