package com.osttra.Main;

import com.osttra.Service.BookService;
import com.osttra.TO.User;

import java.util.Scanner;

public class LoginController {
    static Scanner sc = new Scanner(System.in);

    static public void loginScreen(User user) {
//        System.out.println(user.getUsername());
        int choice = -1;
        while (choice != 5) {
            System.out.println("========================================");
            System.out.println("Welcome to book management Software");
            System.out.println("Choose an option");
            System.out.println("1. All Books \n2. Completed books \n3. Favorite books \n4. Search books\n5. Logout");
            if (user.getUserType().equalsIgnoreCase("admin")) {
                System.out.println("6. Add a Book");
            }
            System.out.println("========================================");
            choice = sc.nextInt();
            sc.nextLine();

            BookService bookService = new BookService();
            int i = 1;
            switch (choice) {
                case 1:
                    bookService.getAllBooks();
                    break;
                case 2:
                    bookService.getCompletedBooks(user);
                    break;
                case 3:
                    bookService.getFavoriteBooks(user);
                    break;
                case 4:
                    bookService.checkBook();
                    break;
                case 5:
                    break;
                case 6:
                    if (user.getUserType().equalsIgnoreCase("admin")) {
                        bookService.addBook();
                        break;
                    } else {
                        System.out.println("Not an admin");
                        break;
                    }

            }
        }
    }
}
