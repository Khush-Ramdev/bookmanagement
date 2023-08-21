package Service;
import DAO.BooksDAO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookService {

    BooksDAO booksDAO = new BooksDAO();
    public ArrayList getAllBooks(){
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

    public ArrayList getCompletedBooks(String userName){
        ResultSet rs  = booksDAO.getCompletedBooks(userName);
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
        return books;
    }

    public ArrayList getFavoriteBooks(String userName){
        ResultSet rs  = booksDAO.getFavoriteBooks(userName);
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
        return books;
    }
}
