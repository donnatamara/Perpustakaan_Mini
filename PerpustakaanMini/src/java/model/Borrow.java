package model;

import java.util.Date;

public class Borrow {
    private String id;
    private String memberId;
    private String bookId;
    private Date borrowDate;
    private Date returnDate;

    public Borrow(String id, String memberId, String bookId, Date borrowDate, Date returnDate) {
        this.id = id;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getTotalDays() {
        long diff = returnDate.getTime() - borrowDate.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }

    public String getId() {
        return id;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBookId() {
        return bookId;
    }


    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

}
