package DAO;

import TO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Utilities.DBUtil.getConnection;

public class UserDAO {

    Connection con = getConnection();
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
            e.printStackTrace();
            System.out.println("Failed to add user..");
        }
    }

    public boolean checkUser (User user){
        boolean status = false;
        try{
            PreparedStatement statement = con.prepareStatement("Select * from user where userName = ? && userPassword = ?;");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            status = rs.next();
        }
        catch(Exception e){
            System.out.println("Failed to fetch user..");
            e.printStackTrace();
        }
        return status;
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
