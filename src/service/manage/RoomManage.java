package service.manage;

import models.Room;
import service.interfaceService.RoomService;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomManage implements RoomService {
    private static ArrayList<Room> roomList;

    private RoomManage() {
    }

    public static ArrayList<Room> getRoomList() {
        if (roomList == null) {
            roomList = new ArrayList<>();
            roomList.add(new Room(101, 10000, Room.READY, 1, 1));
            roomList.add(new Room(102, 15000, Room.READY, 1, 2));
            roomList.add(new Room(103, 20000, Room.READY, 2, 2));
        }
        return roomList;
    }

    public static void add(Room room) {
        roomList.add(room);
    }

    public static void update(int id, Room room) {
        roomList.set(findIndexById(id), room);
    }

    public static void delete(int id) {
        roomList.remove(findIndexById(id));
    }

    public static int findIndexById(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomID() == id) {
                return i;
            }
        } return -1;
    }

    public static void displayListRoom() {
        System.out.println();
        System.out.println("________________________***  DANH SÁCH PHÒNG  ***________________________");
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %n", "Số phòng", "Giá phòng", "Trạng thái phòng", "Số giường ngủ", "Số nhà VS");
        System.out.println();
        for (Room room : roomList) {
            System.out.println(room);
        }
        System.out.println("_________________________________________________________________________");
        System.out.println();
    }

    public static void findRoomByPrice(int minPrice, int maxPrice) {
        System.out.println();
        System.out.println("____________________***  DANH SÁCH PHÒNG PHÙ HỢP  ***____________________");
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %n", "Số phòng", "Giá phòng", "Trạng thái phòng", "Số giường ngủ", "Số nhà VS");
        System.out.println();
        for (Room room : roomList) {
            if (room.getPrice() >= minPrice && room.getPrice() <= maxPrice) {
                System.out.println(room);
            }
        }
        System.out.println("_________________________________________________________________________");
        System.out.println();
    }

    public static Room createRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phòng: ");
        int roomId = scanner.nextInt();
        System.out.print("Nhập giá thuê phòng: ");
        int price = scanner.nextInt();
        System.out.print("Nhập số giường ngủ: ");
        int numberOfBed = scanner.nextInt();
        System.out.print("Nhập số nhà vệ sinh: ");
        int numberOfToilet = scanner.nextInt();
        return new Room(roomId, price, Room.READY, numberOfBed, numberOfToilet);
    }
}
