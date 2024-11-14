package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Loan implements Serializable {
    private String loanId;
    private String borrowedBookId;
    private String userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Loan() {
    }

    public Loan(String loanId, String borrowedBookId, String userId, LocalDate borrowDate, LocalDate returnDate) {
        this.loanId = loanId;
        this.borrowedBookId = borrowedBookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public String getBorrowedBookId() {
        return borrowedBookId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public void setBorrowedBookId(String borrowedBookId) {
        this.borrowedBookId = borrowedBookId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
