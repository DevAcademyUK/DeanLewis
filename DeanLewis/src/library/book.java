package library;

import java.util.Comparator;

public class book implements Comparable<book> {

    public book(int ID, String title, String author, String year) {
        bookID = ID;
        bookTitle = title;
        bookAuthor = author;
        bookYear = year;
    }

    public int bookID;
    public String bookTitle;
    public String bookAuthor;
    public String bookYear;

    @Override
    public int compareTo(book o) {

        String title = o.bookTitle;

        return this.bookTitle.compareTo(title);
    }

    public static Comparator<book> bookAuthorComparator = new Comparator<book>() {
        @Override
        public int compare(book b1, book b2) {

            String author1 = b1.bookAuthor.toUpperCase();
            String author2 = b2.bookAuthor.toUpperCase();

            return author1.compareTo(author2);
        }
    };
}
