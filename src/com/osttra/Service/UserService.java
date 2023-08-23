package com.osttra.Service;

import com.osttra.DAO.UserDAO;
import com.osttra.TO.User;

import java.sql.ResultSet;
import java.util.Scanner;

public class UserService {
    static Scanner sc = new Scanner(System.in);
    UserDAO userDAO =  new UserDAO();
    User user;
    public void register(){
        System.out.println("Please Enter you username");
        String userName = sc.next();
        System.out.println("Please enter you password");
        String password = sc.next();
//        System.out.println("Please re-enter you password");
//        String passwodCheck = sc.next();
        System.out.println("Please enter you email id");
        String email = sc.next();
        System.out.println("Please enter you role");
        String userType = sc.next();

        user = new User(userName,password,email,userType);
        userDAO.add(user);
    }

    public User login() {
        System.out.println("Please Enter you username");
        String userName = sc.next();
        System.out.println("Please enter you password");
        String password = sc.next();

        user = new User(userName,password);
        userDAO.checkUser(user);
        System.out.println("Press \"ENTER\" to continue...");
        sc.nextLine();
//        sc.nextLine();
        return user;
    }

    public boolean isAdmin(){
        boolean status =  false;
        status  = userDAO.isAdmin(user);
        return status;
    }

    public String getUserName(){
        return user.getUsername();
    }
}
