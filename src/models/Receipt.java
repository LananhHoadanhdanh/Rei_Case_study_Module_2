package models;

import java.util.Date;

public class Receipt {
    private int receiptID;
    private String customerName;
    private String staffName;
    private Date checkIn;
    private Date checkOut;
    private int receiptPrice;

    public Receipt() {
    }

    public Receipt(int receiptID, String customerName, String staffName, Date checkIn, Date checkOut, int receiptPrice) {
        this.receiptID = receiptID;
        this.customerName = customerName;
        this.staffName = staffName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.receiptPrice = receiptPrice;
    }
}
