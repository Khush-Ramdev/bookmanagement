package com.osttra.DAO;

import com.osttra.TO.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.osttra.Utilities.DBUtil.getConnection;

public class BookDAO {
    Connection con = getConnection();

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        try{
            PreparedStatement statement = con.prepareStatement("Select * from books");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                books.add(book);
            }
        }
        catch(Exception e){
            System.out.println("Failed to fetch books from Database..");
            return null;
        }
        return books;
    }

    public ArrayList<Book> getCompletedBooks(String userName) {
        ArrayList<Book> books = new ArrayList<Book>();
        try{
            PreparedStatement statement = con.prepareStatement("select * from books where bookID in (Select bookID from userRead where userName = ?);");
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                books.add(book);
            }
        }
        catch(Exception e){
            System.out.println("Failed to fetch completed books..");
            e.printStackTrace();
        }
        return books;
    }

    public ArrayList<Book> getFavoriteBooks(String userName) {
        ArrayList<Book> books = new ArrayList<Book>();
        try{
            PreparedStatement statement = con.prepareStatement("select * from books inner joins books where bookID in (Select bookID from userFavorites where userName = ?);");
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                books.add(book);
            }
        }
        catch(Exception e){
            System.out.println("Failed to fetch completed books..");
            e.printStackTrace();
        }
        return books;
    }

    public Book findBook(String keyword) {
        Book book = new Book();
        try {
            PreparedStatement statement = con.prepareStatement("select * from books where bookID = ? or bookName = ?);");
            statement.setString(1, keyword);
            statement.setString(2, keyword);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                book.setBookName(rs.getString(1));
                book.setAuthorName(rs.getString(2));
                book.setDescription(rs.getString(3));
                book.setBookID(rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("Failed to fetch completed books..");
            e.printStackTrace();
        }
        return book;
    }

    public void add(Book book) {
        try {
            PreparedStatement statement = con.prepareStatement("insert into books value (?,?,?,?)");
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getAuthorName());
            statement.setInt(4, book.getBookID());
            statement.setString(3, book.getDescription());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Failed to add book to the database");
            e.printStackTrace();
        }
    }
}
