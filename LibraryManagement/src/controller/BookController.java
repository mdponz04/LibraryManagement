package controller;

import model.Book;
import view.BookView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class BookController {
    private int idCounter;
    private static final String FILE_NAME = "src/books.dat";
    private HashMap<String, Book> books = new HashMap();
    private BookView view = new BookView();
    private String generateId(){
        idCounter++;
        return String.format("B%05d", idCounter);
    }

    public Book findBook(String id){
        for(String bookId : books.keySet()){
            if(bookId.equals(id)){
                return books.get(bookId);
            }
        }
        return null;
    }
    //2.1 add a book
    public void createBook(String title, String author, int publicationYear, String publisher, String ISBN){
        if(title.isEmpty() || author.isEmpty() || publisher.isEmpty() || ISBN.isEmpty() || publicationYear <= 0){
            System.out.println("Input field for create book is required, cannot be null!!!");
            return;
        }

        Book book = new Book(generateId(), title, author, publicationYear, publisher, ISBN);

        books.put(book.getId(), book);
    }

    //2.2 update book information
    public void updateBook(String id, String title, String author, int publicationYear, String publisher, String ISBN){
        Book updatedBook = findBook(id);
        if(updatedBook == null){
            return;
        }
        if(!title.isEmpty() && title != null){
            updatedBook.setTitle(title);
        }
        if(!author.isEmpty()){
            updatedBook.setAuthor(author);
        }
        if(!publisher.isEmpty()){
            updatedBook.setPublisher(publisher);
        }
        if(!ISBN.isEmpty()){
            updatedBook.setISBN(ISBN);
        }
        if(publicationYear <= 0) {
            return;
        }
    }
    //2.3 Delete a book
    public void deleteBook(String id){
        findBook(id).setActiveBook(false);
        showActiveBooks();
    }
    //2.4 show all books
    public void showAllBooks(){
        view.printBookList(books);
    }
    public void save(){

        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(books);
            oos.writeObject(idCounter);

            oos.close();
            fos.close();
            System.out.println("Events list save successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving events list to file. ");
            e.printStackTrace();
        }
    }
    public void load(){
        try{
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);

            books = (HashMap<String, Book>) ois.readObject();
            idCounter = (int) ois.readObject();
            view.printBookList(books);

            ois.close();
            fis.close();
        }catch (IOException e){
            System.err.println("Error loading events list from file. System end!!!");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Error loading file. System end!!!");
            ex.printStackTrace();
        }
    }
    public void showBorrowBooks(ArrayList<String> borrowedBookList){
        HashMap<String, Book> borrowedBooks = new HashMap();
        for(String bookId : borrowedBookList){
            borrowedBooks.put(bookId, books.get(bookId));
        }
        view.printBookList(borrowedBooks);
    }
    private void showActiveBooks(){
        HashMap<String, Book> activeBooks = new HashMap();
        for(Book b : books.values().stream().toList()){
            if(b.isActiveBook()){
                activeBooks.put(b.getId(), b);
            }
        }

        view.printBookList(activeBooks);
    }
    public void showOverdueBooks(ArrayList<String> overdueBooksId){
        HashMap<String, Book> overdueBooks = new HashMap();
        for(String bookId : overdueBooksId){
            overdueBooks.put(bookId, findBook(bookId));
        }

        view.printBookList(overdueBooks);
    }
    public void showBookDetails(String userId){
        view.printBookDetails(findBook(userId));
    }
}
