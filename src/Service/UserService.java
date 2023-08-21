package Service;
import DAO.UserDAO;
import TO.User;

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
        boolean status = false;
        System.out.println("Please Enter you username");
        String userName = sc.next();
        System.out.println("Please enter you password");
        String password = sc.next();

        user = new User(userName,password);
        ResultSet rs = userDAO.checkUser(user);
        try {
            while (rs.next()) {
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setEmailID(rs.getString(3));
                System.out.println(rs.getString(6));
                user.setUserType(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.nextLine();
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
