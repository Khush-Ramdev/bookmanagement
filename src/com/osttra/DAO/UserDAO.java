package com.osttra.DAO;

import com.osttra.TO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import static com.osttra.Utilities.DBUtil.getConnection;

public class UserDAO extends Exception {

    Connection con = getConnection();
    static Scanner sc = new Scanner(System.in);
    public void add (User user){
        try{
            PreparedStatement statement = con.prepareStatement("insert into user (userName,userPassword,email,userType) values (?,?,?,?);");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmailID());
            statement.setString(4, user.getUserType());
            statement.executeUpdate();
        }
        catch (Exception e){
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("\n !!! Username already in use !!! \n");
                System.out.println("Press \"ENTER\" to continue...");
                sc.nextLine();
            } else if (e instanceof NullPointerException) {
                System.out.println("Username already");
            } else {
                e.printStackTrace();
                System.out.println("Failed to add user..");
            }
        }
    }

    public User checkUser(User user) {
        try{
            PreparedStatement statement = con.prepareStatement("Select * from user where userName = ? && userPassword = ?;");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setEmailID(rs.getString(3));
                System.out.println(rs.getString(6));
                user.setUserType(rs.getString(6));
            } else {
                System.out.println("User not found please try again ...");
            }
        }
        catch(Exception e){
            System.out.println("Failed to fetch user..");
            e.printStackTrace();
        }
        return user;
    }

    public boolean isAdmin (User user){
//        System.out.println(user.getPassword()+user.getUsername());
        try{
            PreparedStatement statement = con.prepareStatement("Select userType from user where userName = ? && userPassword = ?;");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getString(1).equalsIgnoreCase("admin");
            }
        }
        catch(Exception e){
            System.out.println("Failed to fetch userType..");
            e.printStackTrace();
        }
        return false;
    }
}
