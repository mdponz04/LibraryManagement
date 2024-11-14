package view;

import model.Book;

import java.util.HashMap;
import java.util.Iterator;


public class BookView {

    public void printBookDetails(Book book){
        if(book == null){
            System.out.println("This book does not exist!!!");
            return;
        }

        System.out.println("-------Book Details-------");
        // Print the table headers
        System.out.printf("%-7s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n"
                , "ID", "Title", "Author", "publication year", "Publisher", "ISBN", "Active book");
        System.out.printf("%-7s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n"
                , book.getId(), book.getTitle(), book.getAuthor(), book.getPublicationYear()
                , book.getPublisher(), book.getISBN(), book.isActiveBook());

    }

    public void printBookList(HashMap<String, Book> books){
        if(books.isEmpty()){
            System.out.println("There is no book!!!");
            return;
        }

        System.out.println("-------Book list-------");
        System.out.printf("%-7s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n"
                , "ID", "Title", "Author", "publication year", "Publisher", "ISBN", "Active book");

        Iterator<Book> bookIter = books.values().iterator();
        while(bookIter.hasNext()){
            Book book = bookIter.next();
            System.out.printf("%-7s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n"
                    , book.getId(), book.getTitle(), book.getAuthor(), book.getPublicationYear()
                    , book.getPublisher(), book.getISBN(), book.isActiveBook());
        }
    }
}
