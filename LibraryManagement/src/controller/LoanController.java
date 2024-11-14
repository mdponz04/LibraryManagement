package controller;

import model.Loan;
import view.LoanView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoanController {
    private LoanView view = new LoanView();
    private int idCounter;
    private static final String FILE_NAME = "src/loans.dat";
    private HashMap<String, Loan> loans = new HashMap();
    private String generateId(){
        idCounter++;
        return String.format("L%05d", idCounter);
    }

    private LocalDate convertStringToDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(stringDate, formatter);


            String reconstructedDateString = date.format(formatter);
            if (!stringDate.equals(reconstructedDateString)) {
                throw new DateTimeParseException("Invalid date", stringDate, 0);
            }

            return date;
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format or value for input: " + stringDate);
            return null;
        }
    }
    public Loan findLoan(String id){
        for(String loanId : loans.keySet()){
            if(loanId.equals(id)){
                return loans.get(id);
            }
        }
        return null;
    }
    public void borrowBook(String borrowedBookId, String userId, String borrowDate, String returnDate){
        Loan loan = new Loan(generateId(), borrowedBookId, userId, convertStringToDate(borrowDate), convertStringToDate(returnDate));
        loans.put(loan.getLoanId(), loan);
    }
    public void updateLoanInformation(String loanId, String borrowedBookId, String userId, String borrowDate, String returnDate){
        Loan updatedLoan = findLoan(loanId);
        if(!borrowedBookId.isEmpty()){
            updatedLoan.setBorrowedBookId(borrowedBookId);
        }
        if(!userId.isEmpty()){
            updatedLoan.setUserId(userId);
        }
        if(convertStringToDate(borrowDate) != null){
            updatedLoan.setBorrowDate(convertStringToDate(borrowDate));
        }
        if(convertStringToDate(returnDate) != null){
            updatedLoan.setReturnDate(convertStringToDate(returnDate));
        }
    }

    public void save(){

        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(loans);
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

            loans = (HashMap<String, Loan>) ois.readObject();
            idCounter = (int) ois.readObject();
            view.printLoanList(loans);

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
    public ArrayList<String> getOverdueBooks(){
        ArrayList<String> overdueBooks = new ArrayList();
        for(String loanId : loans.keySet()){
            if(loans.get(loanId).getReturnDate().isBefore(LocalDate.now())){
                overdueBooks.add(loans.get(loanId).getBorrowedBookId());
            }
        }

        return overdueBooks;
    }
    public void showLoansInSpecificPeriod(String startDateString, String endDateString){
        HashMap<String, Loan> searchedLoans = new HashMap();
        LocalDate startDate = convertStringToDate(startDateString);
        LocalDate endDate = convertStringToDate(endDateString);
        for(String loanId : loans.keySet()){
            LocalDate borrowDate = loans.get(loanId).getBorrowDate();
            if(borrowDate.isAfter(startDate) && borrowDate.isBefore(endDate)){
                searchedLoans.put(loanId, loans.get(loanId));
            }
        }

        view.printLoanList(searchedLoans);
    }
    public ArrayList<String> getBorrowedBooksId(){
        ArrayList<String> borrowedBooksId = new ArrayList();
        for(String loanId : loans.keySet()){
            borrowedBooksId.add(loans.get(loanId).getBorrowedBookId());
        }
        return borrowedBooksId;
    }
    public void showAllLoan(){
        view.printLoanList(loans);
    }
}
