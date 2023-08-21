import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import Service.BookService;
import Service.UserService;
import TO.User;

public class Main {
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

            switch (choice) {
                case 1:
                    userService.register();
                    break;
                case 2:
                    User user = userService.login();
                    loginScreen(user);
                    break;
                case 3:
                    choice = 3;
                    break;
            }
        }

    }

    static boolean loginScreen(User user) {
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
                    i = 1;
                    ArrayList<String> books = bookService.getAllBooks();
                    for (String book :
                            books) {
                        System.out.println(i + ". " + book);
                        i++;
                    }
                    System.out.println("Press \"ENTER\" to continue...");
                    sc.nextLine();
                    break;
                case 2:
                    user = bookService.getCompletedBooks(user);
                    i = 1;
//                    System.out.println(completedBooks.size());
                    if (user.getCompleted().isEmpty()) {
                        System.out.println("List is Empty");
                    }
                    for (String book :
                            user.getCompleted()) {
                        System.out.println(i + ". " + book);
                        i++;
                    }
                    System.out.println("Press \"ENTER\" to continue...");
                    sc.nextLine();
                    break;
                case 3:
                    user = bookService.getFavoriteBooks(user);
                    i = 1;
//                    System.out.println(completedBooks.size());
                    if (user.getFavorite().isEmpty()) {
                        System.out.println("List is Empty");
                    }
                    for (String book :
                            user.getFavorite()) {
                        System.out.println(i + ". " + book);
                        i++;
                    }
                    System.out.println("Press \"ENTER\" to continue...");
                    sc.nextLine();
                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 6:
                    if (user.getUserType().equalsIgnoreCase("admin")) {
                        break;
                    } else {
                        System.out.println("Not an admin");
                        break;
                    }

            }
        }
        return false;
    }
}

// DAO is for database calls
// TO is for transferring data between layers (class schemas goes here)
// service functions called by controller are stored here