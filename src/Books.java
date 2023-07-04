import java.util.Comparator;
import java.util.Date;

public class Books
{
    private String name;
    private String author;
    private String genre;
    private int count;
    private Date dueDate;
    private boolean overDue;

    /**
     * Constructor that takes the name, author, genre, and amount of a book
     * Preconditions: parameter a >= 0
     * PostCondition: A Book is created with the name n, author, genre g, amount a
     * @param n name
     * @param author author
     * @param g genre
     * @param a amount
     */
    public Books(String n, String author, String g, int a) {
        name = n;
        this.author = author;
        genre = g;
        count = a;
    }
    /**
     * Constructor that takes the name, author, genre, due date, and amount of a book
     * Preconditions: parameter a >= 0
     *      parameter d follows the format, MM/dd/yyyy HH:mm:ss
     * Postcondition: A Book is created with the name n, author, genre g, amount a, dueDate d
     * @param n name
     * @param author author
     * @param g genre
     * @param a amount
     * @param d due date
     */
    public Books(String n, String author, String g, int a, Date d) {
        name = n;
        this.author = author;
        genre = g;
        count = a;
        dueDate = d;
    }

    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public int getCount() {
        return count;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public boolean getOverDue() {
        return overDue;
    }
    public void removeCount(int c) {
        count += negative(c);
    }
    public void addCount(int c) {
        count += c;
    }
    public void setDueDate(Date d) {
        dueDate = d;
    }
    public void setOverDue(boolean o) {
        overDue = o;
    }
    private static int negative(int d) {
        return d * -1;
    }

    public static Comparator<Books> bookNameComparator = new Comparator<Books>() {
        public int compare(Books b1, Books b2) {
            String booksName1 = b1.getName().toUpperCase();
            String booksName2 = b2.getName().toUpperCase();
            return booksName1.compareTo(booksName2);
        }
    };
    public static Comparator<Books> bookAuthorComparator = new Comparator<Books>() {
        public int compare(Books b1, Books b2) {
            String booksAuthor1 = b1.getAuthor().toUpperCase();
            String booksAuthor2 = b2.getAuthor().toUpperCase();
            return booksAuthor1.compareTo(booksAuthor2);
        }
    };
    public static Comparator<Books> bookGenreComparator = new Comparator<Books>() {
        public int compare(Books b1, Books b2) {
            String booksGenre1 = b1.getGenre().toUpperCase();
            String booksGenre2 = b2.getGenre().toUpperCase();
            return booksGenre1.compareTo(booksGenre2);
        }
    };
    public static Comparator<Books> bookGreatestLeast = new Comparator<Books>() {
        public int compare(Books b1, Books b2) {
            int bookCount1 = b1.getCount();
            int bookCount2 = b2.getCount();
            return bookCount1 - bookCount2;
        }
    };
    public static Comparator<Books> bookLeastGreatest = new Comparator<Books>() {
        public int compare(Books b1, Books b2) {
            int bookCount1 = b1.getCount();
            int bookCount2 = b2.getCount();
            return bookCount2 - bookCount1;
        }
    };
}