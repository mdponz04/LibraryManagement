package controller;



public class LibraryController {
    private BookController bookController = new BookController();
    private UserController userController = new UserController();
    private LoanController loanController = new LoanController();

    // 2.1
    public void addABook(String title, String author, int publicationYear, String publisher, String ISBN){
        bookController.createBook(title, author, publicationYear, publisher, ISBN);
    }
    // 2.2
    public void updateBookInformation(String id, String title, String author, int publicationYear, String publisher, String ISBN){
        bookController.updateBook(id,title,author,publicationYear,publisher,ISBN);
    }
    public boolean isBookExist(String id){
        return bookController.findBook(id) != null;
    }
    // 2.3
    public void deleteABook(String id){
        bookController.deleteBook(id);
    }
    // 2.4
    public void showAllBook(){
        bookController.showAllBooks();
    }
    public void showBookDetails(String bookId){
        bookController.showBookDetails(bookId);
    }
    // 3.1
    public void addAUser(String name, String dateOfBirth, String phoneNumber, String email){
        userController.createUser(name, dateOfBirth, phoneNumber, email);

    }
    // 3.2
    public void updateUserInformation(String id, String name, String dateOfBirth, String phoneNumber, String email){
        userController.updateUser(id, name, dateOfBirth, phoneNumber, email);
    }
    public boolean isUserExist(String id){
        return userController.findUser(id) != null;
    }
    // 3.3
    public void deleteAUser(String id){
        userController.deleteUser(id);
    }
    public void showAllUsers(){
        userController.showAllUser();
    }
    public void showUserDetails(String userId){
        userController.showUserDetails(userController.findUser(userId));
    }
    // 4.1 borrow books
    public void borrowABook(String borrowedBookId, String userId, String borrowDate, String returnDate){
        loanController.borrowBook(borrowedBookId, userId, borrowDate, returnDate);
    }
    // 4.2 update borrowing information
    public void updateBorrowingInformation(String loanId, String borrowedBookId, String userId, String borrowDate, String returnDate){
        loanController.updateLoanInformation(loanId, borrowedBookId, userId, borrowDate, returnDate);
    }
    public boolean isLoanExist(String id){
        return loanController.findLoan(id) != null;
    }
    // 4.3
    public void displayAllBorrowedBooks(){
        loanController.showAllLoan();
    }
    // 5.1
    public void showAllBorrowBooks(){
        bookController.showBorrowBooks(loanController.getBorrowedBooksId());
    }
    // 5.2
    public void showAllOverdueBooks(){
        bookController.showOverdueBooks(loanController.getOverdueBooks());
    }
    // 5.3
    public void showAllLoanInSpecificPeriod(String startDate, String endDate){
        loanController.showLoansInSpecificPeriod(startDate, endDate);
    }
    // 6.1 save
    public void save(){
        bookController.save();
        userController.save();
        loanController.save();
    }
    // 6.2 load
    public void load(){
        bookController.load();
        userController.load();
        loanController.load();
    }
    public void displayMenu(){
        System.out.println("******Library Management System******");
        System.out.println("1.Manage books.");
        System.out.println("2.Manage users.");
        System.out.println("3.Manage loans.");
        System.out.println("4.Report.");
        System.out.println("5.Save data.");
        System.out.println("6.Load data.");
        System.out.println("7.Exit");
        System.out.print("Enter your choice(1-7):");
    }
    public void displaySubmenuBook(){
        System.out.println("------Managing books------");
        System.out.println("1.Add a new book.");
        System.out.println("2.Update book's information.");
        System.out.println("3.Delete a book.");
        System.out.println("4.Show all books.");
        System.out.println("5.Back to main menu.");
        System.out.print("Enter your choice(1-5):");
    }
    public void displaySubmenuUser(){
        System.out.println("------Managing users------");
        System.out.println("1.Add a new user.");
        System.out.println("2.Update user's information.");
        System.out.println("3.Delete a user.");
        System.out.println("4.Back to main menu.");
        System.out.print("Enter your choice(1-4):");
    }
    public void displaySubmenuLoan(){
        System.out.println("------Managing loans------");
        System.out.println("1.Borrow books.");
        System.out.println("2.Update loan information.");
        System.out.println("3.Show all borrowed books.");
        System.out.println("4.Back to main menu.");
        System.out.print("Enter your choice(1-4):");
    }
    public void displaySubmenuReport(){
        System.out.println("------Reporting------");
        System.out.println("1.Report on borrowed books.");
        System.out.println("2.Report on overdue books.");
        System.out.println("3.Report on total borrowing activities.");
        System.out.println("4.Back to main menu.");
        System.out.print("Enter your choice(1-4):");
    }
}
