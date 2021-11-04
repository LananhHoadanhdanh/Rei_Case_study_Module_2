package models;

public class Room {
//    public static final
    private int roomID;
    private int price;
    private String status;
    private int numberOfBed;
    private int numberOfToilet;

    public Room() {
    }

    public Room(int roomID, int price, String status, int numberOfBed, int numberOfToilet) {
        this.roomID = roomID;
        this.price = price;
        this.status = status;
        this.numberOfBed = numberOfBed;
        this.numberOfToilet = numberOfToilet;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public int getNumberOfToilet() {
        return numberOfToilet;
    }

    public void setNumberOfToilet(int numberOfToilet) {
        this.numberOfToilet = numberOfToilet;
    }
}
