package com.osttra.Main;

import java.util.Scanner;

import com.osttra.Service.UserService;
import com.osttra.TO.User;

import static com.osttra.Main.LoginController.loginScreen;

public class MainController {
    static Scanner sc = new Scanner(System.in);
    static UserService userService = new UserService();

    public static void main(String[] args) {
        int choice = -1;
//        boolean loggedIn = false;
        while (choice != 3) {
            System.out.println("========================================");
            System.out.println("Welcome to book management Software");
            System.out.println("Choose an option");
            System.out.println("1. Register \n2. Login \n3. Exit");
            System.out.println("========================================");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    userService.register();
                    break;
                case 2:
                    User user = userService.login();
                    if (user != null) {
                        loginScreen(user);
                    }
                    break;
                case 3:
//                    choice = 3;
                    System.out.println("Application Ended Successfully");
                    break;
            }
        }

    }
}

// DAO is for database calls
// com.osttra.TO is for transferring data between layers (class schemas goes here)
// service functions called by controller are stored here