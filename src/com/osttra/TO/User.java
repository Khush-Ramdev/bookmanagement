package com.osttra.TO;

import java.util.ArrayList;

public class User {
    String username, emailID, firstName, lastName, password, userType;
    ArrayList<Book> wishlist, favorite, completed;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String emailID, String userType) {
        this.username = username;
        this.emailID = emailID;
        this.password = password;
        this.userType = userType;
    }

    public User(String username, String emailID, String firstName, String lastName, String password, String userType, ArrayList<Book> wishlist, ArrayList<Book> favorite, ArrayList<Book> completed) {
        this.username = username;
        this.emailID = emailID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userType = userType;
        this.wishlist = wishlist;
        this.favorite = favorite;
        this.completed = completed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public ArrayList<Book> getWishlist() {
        return wishlist;
    }

    public void setWishlist(ArrayList<Book> wishlist) {
        this.wishlist = wishlist;
    }

    public ArrayList<Book> getFavorite() {
        return favorite;
    }

    public void setFavorite(ArrayList<Book> favorite) {
        this.favorite = favorite;
    }

    public ArrayList<Book> getCompleted() {
        return completed;
    }

    public void setCompleted(ArrayList<Book> completed) {
        this.completed = completed;
    }
}
