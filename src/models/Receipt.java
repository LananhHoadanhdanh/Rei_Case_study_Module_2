package models;

import service.manage.RoomManage;

import java.text.ParseException;

public class Receipt {
    private String receiptID;
    private String customerName;
    private String staffName;
    private String checkInTime;
    private String checkOutTime;
    private int roomId;

    public Receipt() {
    }

    public Receipt(String receiptID, String customerName, String checkInTime, String checkOutTime) {
        this.receiptID = receiptID;
        this.customerName = customerName;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public long getTotalPrice() throws ParseException {
        int roomPrice = RoomManage.getRoomList().get(RoomManage.findIndexById(roomId)).getPrice();
        long dateCal = DateCalculator.dateCalculator(checkInTime, checkOutTime);
        return roomPrice * (dateCal + 1);
    }

    @Override
    public String toString() {
        String str = null;
        try {
            str = String.format("%-15s %-20s %-20s %-15s %-15s %-15d", receiptID, customerName, staffName, checkInTime, checkOutTime,getTotalPrice());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
