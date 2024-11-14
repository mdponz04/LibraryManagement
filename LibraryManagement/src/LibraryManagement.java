import controller.LibraryController;


import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {
        //-------------------------------------------------------------------------

        //-------------------------------------------------------------------------


        LibraryController controller = new LibraryController();
        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean validInput;
        int choice;

        do{
            controller.displayMenu();
            choice = scanner.nextInt();

            switch(choice){
                case 1://book
                    scanner = new Scanner(System.in);

                    do{
                        controller.displaySubmenuBook();
                        choice = scanner.nextInt();
                        switch(choice){
                            case 1://good
                                scanner = new Scanner(System.in);
                                do{
                                    System.out.println("----Adding a book----");
                                    System.out.println("Enter book title:");
                                    String title = scanner.nextLine().trim();
                                    System.out.println("Enter book author:");
                                    String author = scanner.nextLine().trim();
                                    int publicationYear = 0;
                                    do {
                                        try {
                                            System.out.println("Enter book publication year:");
                                            publicationYear = scanner.nextInt();
                                            validInput = true;
                                        } catch (InputMismatchException e) {
                                            validInput = false;
                                            System.err.println("Wrong input type!");
                                        }
                                    }while(!validInput);
                                    scanner.nextLine();
                                    System.out.println("Enter book publisher:");
                                    String publisher = scanner.nextLine().trim();
                                    System.out.println("Enter ISBN:");
                                    String ISBN = scanner.nextLine().trim();
                                    controller.addABook(title, author, publicationYear, publisher, ISBN);
                                    controller.showAllBook();
                                    do{
                                        System.out.println("Do you want to add another book?(yes/no)");
                                        answer = scanner.nextLine().trim();
                                    }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
                                }while(answer.equalsIgnoreCase("yes"));
                                break;
                            case 2://good
                                scanner = new Scanner(System.in);
                                do{
                                    System.out.println("----Updating a book----");
                                    System.out.println("Enter book id:");
                                    String bookId = scanner.nextLine().trim();

                                    if(controller.isBookExist(bookId.trim())){
                                        System.out.println("Enter book title:");
                                        String title = scanner.nextLine().trim();
                                        System.out.println("Enter book author:");
                                        String author = scanner.nextLine().trim();
                                        int publicationYear = 0;
                                        do {
                                            System.out.println("Enter book publication year:");
                                            try {
                                                publicationYear = scanner.nextInt();
                                                validInput = true;
                                            } catch (InputMismatchException e) {
                                                System.err.println("Wrong input type!");
                                                validInput = false;
                                                scanner = new Scanner(System.in);
                                            }
                                        }while(!validInput);
                                        scanner.nextLine();
                                        System.out.println("Enter book publisher:");
                                        String publisher = scanner.nextLine().trim();
                                        System.out.println("Enter ISBN:");
                                        String ISBN = scanner.nextLine().trim();
                                        controller.updateBookInformation(bookId, title, author, publicationYear, publisher, ISBN);
                                        controller.showBookDetails(bookId);
                                    }else{
                                        System.out.println("This book does not exist!\nUpdate book failed.");
                                    }

                                    do{
                                        System.out.println("Do you want to update another book?(yes/no)");
                                        answer = scanner.nextLine().trim();
                                    }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));

                                }while(answer.equalsIgnoreCase("yes"));
                                break;
                            case 3://good
                                scanner = new Scanner(System.in);
                                do{
                                    System.out.println("----Deleting a book----");
                                    System.out.println("Enter book id:");
                                    String bookId = scanner.nextLine().trim();

                                    if(controller.isBookExist(bookId)){
                                        do{
                                            System.out.println("Do you really want to delete this book?(yes/no)");
                                            answer = scanner.nextLine().trim();
                                        }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));

                                        if(answer.equalsIgnoreCase("yes")){
                                            controller.deleteABook(bookId);
                                        }
                                    }else{
                                        System.out.println("This book does not exist!\nDelete book failed.");
                                    }

                                    do{
                                        System.out.println("Do you want to delete another book?(yes/no)");
                                        answer = scanner.nextLine().trim();
                                    }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));

                                }while(answer.equalsIgnoreCase("yes"));
                                break;
                            case 4://good
                                controller.showAllBook();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Incorrect input!");
                                break;
                        }
                    }while(choice != 5);

                    break;
                case 2://user
                    do{
                        controller.displaySubmenuUser();
                        choice = scanner.nextInt();
                        switch(choice){
                            case 1://good
                                scanner = new Scanner(System.in);
                                do{
                                    System.out.println("----Adding a new user----");
                                    System.out.println("Enter user name:");
                                    String name = scanner.nextLine().trim();
                                    System.out.println("Enter user date of birth(dd/MM/yyyy):");
                                    String dateOfBirth = scanner.nextLine().trim();
                                    System.out.println("Enter user phone number:");
                                    String phoneNumber = scanner.nextLine().trim();
                                    System.out.println("Enter user email:");
                                    String email = scanner.nextLine().trim();
                                    controller.addAUser(name, dateOfBirth, phoneNumber, email);
                                    controller.showAllUsers();
                                    do{
                                        System.out.println("Do you want to add another user?(yes/no)");
                                        answer = scanner.nextLine().trim();
                                    }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
                                }while(answer.equalsIgnoreCase("yes"));
                                break;
                            case 2://good
                                scanner = new Scanner(System.in);
                                do{
                                    System.out.println("----Updating user information----");
                                    System.out.println("Enter user id:");
                                    String userId = scanner.nextLine().trim();
                                    if(controller.isUserExist(userId)){
                                        System.out.println("Enter user name:");
                                        String name = scanner.nextLine().trim();
                                        System.out.println("Enter user date of birth(dd/MM/yyyy):");
                                        String dateOfBirth = scanner.nextLine().trim();
                                        System.out.println("Enter user phone number:");
                                        String phoneNumber = scanner.nextLine().trim();
                                        System.out.println("Enter user email:");
                                        String email = scanner.nextLine().trim();
                                        controller.updateUserInformation(userId, name, dateOfBirth, phoneNumber, email);
                                        controller.showUserDetails(userId);
                                    }else{
                                        System.out.println("This user does not exist!");
                                    }

                                    do{
                                        System.out.println("Do you want to update another user?(yes/no)");
                                        answer = scanner.nextLine().trim();
                                    }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
                                }while(answer.equalsIgnoreCase("yes"));
                                break;
                            case 3://good
                                scanner = new Scanner(System.in);
                                do{
                                    System.out.println("----Deleting a user----");
                                    System.out.println("Enter user id:");
                                    String userId = scanner.nextLine().trim();

                                    if(controller.isUserExist(userId)){
                                        do{
                                            System.out.println("Do you really want to delete this user?(yes/no)");
                                            answer = scanner.nextLine().trim();
                                        }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));

                                        if(answer.equalsIgnoreCase("yes")){
                                            controller.deleteAUser(userId);
                                        }
                                    }else{
                                        System.out.println("This user does not exist!\nDelete user failed.");
                                    }

                                    do{
                                        System.out.println("Do you want to delete another user?(yes/no)");
                                        answer = scanner.nextLine().trim();
                                    }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
                                }while(answer.equalsIgnoreCase("yes"));
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Incorrect input!");
                                break;
                        }
                    }while(choice != 4);

                    break;
                case 3://loan
                    scanner = new Scanner(System.in);

                    do{
                        controller.displaySubmenuLoan();
                        choice = scanner.nextInt();
                        switch(choice){
                            case 1://good
                                scanner = new Scanner(System.in);
                                do{
                                    System.out.println("----Borrowing a book----");
                                    System.out.println("Enter user id:");
                                    String userId = scanner.nextLine().trim();
                                    System.out.println("Enter book id:");
                                    String bookId = scanner.nextLine().trim();
                                    if(controller.isUserExist(userId) && controller.isBookExist(bookId)){
                                        System.out.println("Enter borrow date:");
                                        String borrowDate = scanner.nextLine().trim();
                                        System.out.println("Enter return date:");
                                        String returnDate = scanner.nextLine().trim();
                                        controller.borrowABook(bookId, userId, borrowDate, returnDate);
                                    }else{
                                        System.out.println("Book id/user id not existed.");
                                    }

                                    do{
                                        System.out.println("Do you want to borrow another book?(yes/no)");
                                        answer = scanner.nextLine().trim();
                                    }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
                                }while(answer.equalsIgnoreCase("yes"));
                                break;
                            case 2:
                                scanner = new Scanner(System.in);
                                do{
                                    System.out.println("----Updating borrowing information----");
                                    System.out.println("Enter loan id:");
                                    String loanId = scanner.nextLine().trim();
                                    if(controller.isLoanExist(loanId)){
                                        System.out.println("Enter user id:");
                                        String userId = scanner.nextLine().trim();
                                        System.out.println("Enter book id:");
                                        String bookId = scanner.nextLine().trim();
                                        if(controller.isUserExist(userId) && controller.isBookExist(bookId)){
                                            System.out.println("Enter user borrow date:");
                                            String borrowDate = scanner.nextLine().trim();
                                            System.out.println("Enter user return date:");
                                            String returnDate = scanner.nextLine().trim();
                                            controller.updateBorrowingInformation(loanId, bookId, userId, borrowDate, returnDate);
                                        }else{
                                            System.out.println("Book id/user id not existed.");
                                        }
                                    }else{
                                        System.out.println("This loan does not exist!");
                                    }

                                    do{
                                        System.out.println("Do you want to update another loan?(yes/no)");
                                        answer = scanner.nextLine().trim();
                                    }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
                                }while(answer.equalsIgnoreCase("yes"));
                                break;
                            case 3://good
                                controller.displayAllBorrowedBooks();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Incorrect input!");
                                break;
                        }
                    }while(choice != 4);

                    break;
                case 4://report
                    scanner = new Scanner(System.in);

                    do{
                        controller.displaySubmenuReport();
                        choice = scanner.nextInt();
                        switch(choice){
                            case 1:
                                System.out.println("----Currently borrowed books----\n");
                                controller.showAllBorrowBooks();
                                break;
                            case 2:
                                System.out.println("----Currently overdue books----\n");
                                controller.showAllOverdueBooks();
                                break;
                            case 3:

                                scanner = new Scanner(System.in);
                                do{
                                    System.out.println("----Search activities in a period time----");
                                    System.out.println("Enter start date:");
                                    String startDate = scanner.nextLine().trim();
                                    System.out.println("Enter end date:");
                                    String endDate = scanner.nextLine().trim();
                                    controller.showAllLoanInSpecificPeriod(startDate, endDate);

                                    do{
                                        System.out.println("Do you want to continue searching?(yes/no)");
                                        answer = scanner.nextLine().trim();
                                    }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
                                }while(answer.equalsIgnoreCase("yes"));
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Incorrect input!");
                                break;
                        }
                    }while(choice != 4);
                    break;
                case 5:
                    controller.save();
                    break;
                case 6:
                    controller.load();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Incorrect input!");
                    break;
            }
        }while(choice != 7);
    }
}
