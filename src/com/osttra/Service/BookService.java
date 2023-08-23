package com.osttra.Service;

import com.osttra.DAO.BookDAO;
import com.osttra.TO.Book;
import com.osttra.TO.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BookService {
    static Scanner sc = new Scanner(System.in);
    BookDAO bookDAO = new BookDAO();

    public void getAllBooks() {
        ArrayList<Book> books = bookDAO.getAllBooks();
        int i = 1;
        if (Objects.nonNull(books)) {
            if (books.isEmpty()) {
                System.out.println("List is Empty");
            } else {
                for (Book book : books) {
                    System.out.println(i + ". " + book.getBookName());
                    i++;
                }
            }
        }
        System.out.println("Press \"ENTER\" to continue...");
        sc.nextLine();
    }

    public void getCompletedBooks(User user) {
        ArrayList<Book> books = bookDAO.getCompletedBooks(user.getUsername());
        user.setCompleted(books);
        int i = 1;
        if (Objects.nonNull(books)) {
            if (user.getCompleted().isEmpty()) {
                System.out.println("List is Empty");
            }
            for (Book book : user.getCompleted()) {
                System.out.println(i + ". " + book);
                i++;
            }
        }
        System.out.println("Press \"ENTER\" to continue...");
        sc.nextLine();
    }

    public void getFavoriteBooks(User user) {
        ArrayList<Book> books = bookDAO.getFavoriteBooks(user.getUsername());
        user.setFavorite(books);
        int i = 1;
        if (Objects.nonNull(books)) {
            if (user.getFavorite().isEmpty()) {
                System.out.println("List is Empty");
            }
            for (Book book : user.getFavorite()) {
                System.out.println(i + ". " + book);
                i++;
            }
        }
        System.out.println("Press \"ENTER\" to continue...");
        sc.nextLine();
    }

    public void checkBook() {
        System.out.println("Enter the book name or ID");
        String keyword = sc.nextLine();
        Book book = bookDAO.findBook(keyword);
        if (Objects.nonNull(book)) {
            System.out.println(book.getBookName());
        }
        System.out.println("Press \"ENTER\" to continue...");
        sc.nextLine();
    }

    public void addBook() {
        System.out.println("Enter the book name");
        String name = sc.nextLine();
        System.out.println("Enter the book author");
        String author = sc.nextLine();
        System.out.println("Enter the book ID");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the book description");
        String description = sc.nextLine();
        Book book = new Book(name, author, description, ID);
        bookDAO.add(book);
        System.out.println("Press \"ENTER\" to continue...");
        sc.nextLine();
    }
}
