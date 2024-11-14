package view;

import model.Loan;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;


public class LoanView {

    public void printLoanDetails(Loan loan){
        if(loan == null){
            System.out.println("This loan is not exist!!!");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("-------Loan details-------");
        // Print the table headers
        System.out.printf("%-7s|%-7s|%-20s|%-20s|%-20s|\n"
                , "Loan ID", "User ID", "Borrow date", "Return date", "Borrowed book");


        System.out.printf("%-7s|%-7s|%-20s|%-20s|%-20s|\n"
                , loan.getLoanId(), loan.getUserId(), loan.getBorrowDate().format(formatter)
                , loan.getReturnDate().format(formatter), loan.getBorrowedBookId());
    }

    public void printLoanList(HashMap<String, Loan> loans){
        if(loans.isEmpty()){
            System.out.println("There is no loan!!!");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("-------Loan list-------");
        System.out.printf("%-7s|%-7s|%-20s|%-20s|%-20s|\n"
                , "Loan ID", "User ID", "Borrow date", "Return date", "Borrowed book");

        Iterator<Loan> userIterator = loans.values().iterator();
        while(userIterator.hasNext()){
            Loan loan = userIterator.next();
            System.out.printf("%-7s|%-7s|%-20s|%-20s|%-20s|\n"
                    , loan.getLoanId(), loan.getUserId(), loan.getBorrowDate().format(formatter)
                    , loan.getReturnDate().format(formatter), loan.getBorrowedBookId());

        }
    }
}
