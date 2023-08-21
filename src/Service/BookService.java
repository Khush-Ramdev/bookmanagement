package Service;
import DAO.BooksDAO;
import TO.User;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BookService {

    BooksDAO booksDAO = new BooksDAO();

    public ArrayList<String> getAllBooks() {
        ResultSet rs  = booksDAO.getAllBooks();
        ArrayList<String> books = new ArrayList<String>();
        try{
            while(rs.next()){
                books.add(rs.getString(1));
            }
        }
      catch (Exception e){
        e.printStackTrace();
      }
        return books;
    }

    public User getCompletedBooks(User user) {
        ResultSet rs = booksDAO.getCompletedBooks(user.getUsername());
        ArrayList<String> books = new ArrayList<String>();
        try{
            while(rs.next()){
                books.add(rs.getString(1));
            }
//            System.out.println(bookIDs);
//            System.out.println(books);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        user.setCompleted(books);
        return user;
    }

    public User getFavoriteBooks(User user) {
        ResultSet rs = booksDAO.getFavoriteBooks(user.getUsername());
        ArrayList<String> books = new ArrayList<String>();
        try{
            while(rs.next()){
                books.add(rs.getString(1));
            }
//            System.out.println(bookIDs);
//            System.out.println(books);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        user.setFavorite(books);
        return user;
    }
}
