package com.practice.bookcase;

import org.sqlite.SQLiteConfig;

import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class InitialiseDB {

    public static void main(String[] args) {
        InitialiseDB initDB = new InitialiseDB();
        initDB.createTables(initDB.connectDB());
    }

    private Connection connectDB() {
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            con = DriverManager.getConnection("jdbc:sqlite:" +
                    "C:/users/user/IdeaProjects/sayHello/lib/BooksDatabase.db",
                    config.toProperties());
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }
        return con;
    }

    private void createTables(Connection con) {

        try {
            Statement stmnt = con.createStatement();
            String createBooksTable = "CREATE TABLE IF NOT EXISTS tblBooks " +
                    "(book_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " book_title TEXT NOT NULL," +
                    " book_author TEXT NOT NULL," +
                    " book_released TEXT NOT NULL," +
                    " book_blurb TEXT NOT NULL," +
                    " book_cover TEXT NOT NULL)";
            stmnt.executeUpdate(createBooksTable);
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }
    }

    public void addNewBook(Connection con, Book book) {
        try {
            String addBooks = "INSERT INTO tblBooks (book_title, book_author, book_released, book_blurb, book_cover) VALUES " +
                    "(?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(addBooks);
            pst.setString(1, book.getBookTitle());
            pst.setString(2, book.getBookAuthor());
            pst.setString(3, book.getBookYear());
            pst.setString(4, book.getBookBlurb());
            pst.setString(5, book.getCoverURL());

            pst.executeUpdate();
            pst.close();
        }
        catch(Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Book> getBooks(Connection con) {

        ArrayList<Book> books = new ArrayList<>();
        Statement stmnt = null;

        try {
            String getBooksQuery = "SELECT * FROM tblBooks";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getBooksQuery);

            while (rs.next()) {
                Book book = new Book();
                book.setBookID(rs.getInt("book_id"));
                book.setBookTitle(rs.getString("book_title"));
                book.setBookAuthor(rs.getString("book_author"));
                book.setBookYear(rs.getString("book_released"));
                book.setBookBlurb(rs.getString("book_blurb"));
                book.setCoverURL(rs.getString("book_cover"));

                books.add(book);
            }

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmnt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    public boolean updateBookRecord(Connection con, Book book){
        try {
            String updateRecord = "UPDATE tblBooks SET book_title = ?, book_author = ?, book_released = ?," +
                    "book_blurb = ?, book_cover = ? WHERE book_id = ?";

            PreparedStatement pst = con.prepareStatement(updateRecord);

            pst.setString(1, book.getBookTitle());
            pst.setString(2, book.getBookAuthor());
            pst.setString(3, book.getBookYear());
            pst.setString(4, book.getBookBlurb());
            pst.setString(5, book.getCoverURL());
            pst.setInt(6, book.getBookID());

            pst.executeUpdate();
            pst.close();
        }
        catch(Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean removeBook(Connection con, Book book){
        try {
            String removeBook = "DELETE FROM tblBooks WHERE book_id = ?";
            PreparedStatement pst = con.prepareStatement(removeBook);

            pst.setInt(1, book.getBookID());
            pst.executeUpdate();

            pst.close();
        }
        catch(Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
            return false;
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public Connection getDBConnetion() {
        Connection con = connectDB();
        createTables(con);
        return con;
    }
}
