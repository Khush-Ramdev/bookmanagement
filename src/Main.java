import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import Service.BookService;
import Service.UserService;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserService userService = new UserService();
    public static void main(String[] args) {
        int choice = -1;
        boolean loggedIn = false;
        while(choice!=3 && !loggedIn){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("========================================");
            System.out.println("Welcome to book management Software");
            System.out.println("Choose an option");
            System.out.println("1. Register \n2. Login \n3. Exit");
            System.out.println("========================================");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    userService.register();
                    break;
                case 2:
                    loggedIn = userService.login();
                    loggedIn = loginScreen(loggedIn);
                    break;
                case 3:
                    choice=3;
                    break;
            }
        }

    }
    static boolean loginScreen(boolean loggedIn){

        int choice =-1;
        while (loggedIn){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("========================================");
            System.out.println("Welcome to book management Software");
            System.out.println("Choose an option");
            System.out.println("1. All Books \n2. Completed books \n3. Favorite books \n4. Wishlisted books\n5. Logout");
            if(userService.isAdmin()){
                System.out.println("6. Add a Book");
            }
            System.out.println("========================================");

            choice = sc.nextInt();

            BookService bookService =new BookService();
            int i =1;
            switch (choice){
                case 1:
                    i=1;
                    ArrayList<String> books = bookService.getAllBooks();
//                    FileReader reader = new FileReader()
                    for (String book:
                         books) {
                        System.out.println(i+". "+book);
                        i++;
                    }
                    sc.next();
                    break;
                case 2:
                    ArrayList<String> completedBooks = bookService.getCompletedBooks(userService.getUserName());
                    i=1;
//                    System.out.println(completedBooks.size());
                    for (String book:
                            completedBooks) {
                        System.out.println(i+". "+book);
                        i++;
                    }
                    sc.next();
                    break;
                case 3:
                    ArrayList<String> favoriteBooks = bookService.getFavoriteBooks(userService.getUserName());
                    i=1;
//                    System.out.println(completedBooks.size());
                    for (String book:
                            favoriteBooks) {
                        System.out.println(i+". "+book);
                        i++;
                    }
                    sc.next();
                    break;
                case 4:

                    break;
                case 5:
                    loggedIn =false;
                    break;
                case 6:
                    if(userService.isAdmin()){
                                break;
                    }else{
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