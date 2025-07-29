
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// import javax.xml.validation.Validator; // Removed incorrect import

public class BookServiceImpl implements BookServiceInterface {
    public static final String RED = "\u001B[31m";
    public static final String RESENT = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLACK = "\u001B[30m";


    Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();
    List <Book> books = new ArrayList<>();

    @Override
    public void addBook()
    {
        String bookid = validator.validateId();
        String Author = validator.validateAuthorTitle("Author");
        String Title = validator.validateAuthorTitle("Title");
        String year = validator.validatePublishYear();
        Book book = new Book(bookid,Author,Title,year, "Available");
        books.add(book);
        System.out.println(GREEN+"Book Added Successfully !!"+RESENT);
        
    }

    @Override
    public void showAllBooks() {
       boolean flag = false;
       System.out.println("\n-----------------------------------------------------------------------");
       System.out.format(CYAN+ "%s%15s%15s%15s%15s","ID", "TITLE" ,"AUTHOR","PULISHER","STATUS");
       System.out.println("\n-----------------------------------------------------------------------");

            for(Book book : books){
                System.out.format("%s%15s%15s%15s%15s\n", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
                System.out.println();
                flag = true;
            }
            System.out.println("\n-------------------------------------------------------------------");
            if(flag==false)
            {
                System.out.println(RED+"There is no Books in Library"+RESENT);
            }
    }

    public void showAllAvailableBook() {
        boolean flag = false;
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.format(CYAN+ "%s%15s%15s%15s%15s","ID", "TITLE" ,"AUTHOR","PULISHER","STATUS");
        System.out.println("\n-----------------------------------------------------------------------");

       if(books.size()>0){
            for(Book book:books){
                if(book.getStatus() == "Available"){
                    System.out.format("%s%15s%15s%15s%15s\n", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
                    System.out.println();
                    flag = true;
                }
            }
       }
       else{
        System.out.println("\n-------------------------------------------------------------------");
            if(flag==false)
            {
                System.out.println(RED+"There is no Books in Library"+RESENT);
            }
       }

        
    }

    @Override
    public void borrowBook() {
       String bookid = validator.validateId();
       boolean flag = false;
       for(Book book:books){
            if(book.getId().equals(bookid) && book.getStatus().equals("Available")){
                flag = true;
                System.out.println(GREEN+ "Book Borrowed Successfully !!!"+RESENT);
                book.setStatus("Not Available");
                System.out.println("Borrowed Book Details: "+book);
                break;
            }
        }
       if(flag == false){
           System.out.println(RED+"This Book is Not Available to Borrow"+RESENT);
       }
    }

    @Override
    public void returnBook() {
        boolean flag = false;
        String bookid = validator.validateId();
        for(Book book:books){
            if(book.getId().equals(bookid) && book.getStatus().equals("NOT Available"));{
                flag = true;
                System.out.println(RED+"Book Returned Successfully !!!" +RESENT);
                book.setStatus("Available");
                System.out.println("Returned Book Details" +book);
            }    
        }
        if(flag == false){ 
            System.out.println(RED+ "We can NOT Return This Book" +RESENT);
        }
    }


    @Override
    public void showAllAvailableBooks() {
        boolean flag = false;
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.format(CYAN+ "%s%15s%15s%15s%15s","ID", "TITLE" ,"AUTHOR","PULISHER","STATUS");
        System.out.println("\n-----------------------------------------------------------------------");

        if(books.size()>0){
            for(Book book:books){
                if(book.getStatus() == "Available"){
                    System.out.format("%s%15s%15s%15s%15s\n", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
                    System.out.println();
                    flag = true;
                }
            }
        }else{
            System.out.println(RED+"NO Books Available in the Library" +RESENT);
        }
        
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

}
