package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Utilities.DBUtil.getConnection;

public class BooksDAO {
    Connection con = getConnection();
    public ResultSet getAllBooks(){
        try{
            PreparedStatement statement = con.prepareStatement("Select * from books");
            ResultSet rs = statement.executeQuery();
            return rs;
        }
        catch(Exception e){
            System.out.println("Failed to fetch user..");
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getCompletedBooks(String userName){
        try{
            PreparedStatement statement = con.prepareStatement("select * from books where bookID in (Select bookID from userRead where userName = ?);");
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            return rs;
        }
        catch(Exception e){
            System.out.println("Failed to fetch completed books..");
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getFavoriteBooks(String userName){
        try{
            PreparedStatement statement = con.prepareStatement("select * from books where bookID in (Select bookID from userFavorites where userName = ?);");
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            return rs;
        }
        catch(Exception e){
            System.out.println("Failed to fetch completed books..");
            e.printStackTrace();
        }
        return null;
    }
}
