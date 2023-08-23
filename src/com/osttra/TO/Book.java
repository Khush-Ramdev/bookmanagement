package com.osttra.TO;

public class Book {
    String bookName,authorName,description;
    int bookID;

    public Book() {
    }

    public Book(String bookName, String authorName, String description, int bookID) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
