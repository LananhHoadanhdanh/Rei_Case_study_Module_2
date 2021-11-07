package Menu;

import models.Room;
import models.User;
import service.manage.RoomManage;
import service.manage.UserManage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomOption {
    public static void roomOptionCheckIn(String username) {
        RoomManage.getRoomList();
        int roomId = 0;
        System.out.print("Nhập số phòng: ");
        while (RoomManage.findIndexById(roomId) == -1){
            Scanner sc = new Scanner(System.in);
            try {
                roomId = sc.nextInt();
                if (RoomManage.findIndexById(roomId) == -1) {
                    System.err.println("Phòng không tồn tại. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e){
                System.err.println("Số phòng không hợp lệ. Vui lòng nhập lại");
            }
        }
        User user = UserManage.getUserList().get(UserManage.findIndexByUsername(username));
        user.doCheckInForCustomer(roomId);
    }

    public static void roomOptionCheckOut(String username) {
        RoomManage.getRoomList();
        int roomId = 0;
        System.out.print("Nhập số phòng: ");
        while (RoomManage.findIndexById(roomId) == -1){
            Scanner sc = new Scanner(System.in);
            try {
                roomId = sc.nextInt();
                if (RoomManage.findIndexById(roomId) == -1) {
                    System.err.println("Phòng không tồn tại. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e){
                System.err.println("Số phòng không hợp lệ. Vui lòng nhập lại");
            }
        }
        User user = UserManage.getUserList().get(UserManage.findIndexByUsername(username));
        user.doCheckOutForCustomer(roomId);
    }

    public static void roomOptionClean(String username) {
        RoomManage.getRoomList();
        int roomId = 0;
        System.out.print("Nhập số phòng: ");
        while (RoomManage.findIndexById(roomId) == -1){
            Scanner sc = new Scanner(System.in);
            try {
                roomId = sc.nextInt();
                if (RoomManage.findIndexById(roomId) == -1) {
                    System.err.println("Phòng không tồn tại. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e){
                System.err.println("Số phòng không hợp lệ. Vui lòng nhập lại");
            }
        }
        User user = UserManage.getUserList().get(UserManage.findIndexByUsername(username));
        user.cleanTheRoom(roomId);
    }

    public static void roomOptionAdd() {
        RoomManage.getRoomList();
        RoomManage.add(RoomManage.createRoom());
    }

    public static void roomOptionUpdate() {
        RoomManage.getRoomList();
        int roomId = 0;
        System.out.print("Nhập số phòng muốn sửa: ");
        while (RoomManage.findIndexById(roomId) == -1){
            Scanner sc = new Scanner(System.in);
            try {
                roomId = sc.nextInt();
                if (RoomManage.findIndexById(roomId) == -1) {
                    System.err.println("Phòng không tồn tại. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e){
                System.err.println("Số phòng không hợp lệ. Vui lòng nhập lại");
            }
        }
        RoomManage.delete(roomId);
        System.out.println("Nhập thông tin mới: ");
        RoomManage.add(RoomManage.createRoom());
        System.out.println("Cập nhật thành công!!!");
    }

    public static void roomOptionInformationById() {
        RoomManage.getRoomList();
        int roomId = 0;
        System.out.print("Nhập số phòng: ");
        while (RoomManage.findIndexById(roomId) == -1){
            Scanner sc = new Scanner(System.in);
            try {
                roomId = sc.nextInt();
                if (RoomManage.findIndexById(roomId) == -1) {
                    System.err.println("Phòng không tồn tại. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e){
                System.err.println("Số phòng không hợp lệ. Vui lòng nhập lại");
            }
        }
        RoomManage.getInformationById(roomId);
    }

    public static void roomOptionDeleteById() {
        RoomManage.getRoomList();
        int roomId = 0;
        String status = RoomManage.getRoomList().get(RoomManage.findIndexById(roomId)).getStatus();
        System.out.print("Nhập số phòng: ");
        while (RoomManage.findIndexById(roomId) == -1 || status.equals(Room.READY)){
            Scanner sc = new Scanner(System.in);
            try {
                roomId = sc.nextInt();
                status = RoomManage.getRoomList().get(RoomManage.findIndexById(roomId)).getStatus();
                if (RoomManage.findIndexById(roomId) == -1) {
                    System.err.println("Phòng không tồn tại. Vui lòng nhập lại.");
                }
                if (status.equals(Room.READY)) {
                    System.err.println("Không thể xóa phòng. Phòng đang ở trạng thái: " + status);
                }
            } catch (InputMismatchException e){
                System.err.println("Số phòng không hợp lệ. Vui lòng nhập lại");
            }
        }
        RoomManage.delete(roomId);
    }

    public static void roomOptionInformationByPrice() {
        System.out.println("Nhập giá tiền nhỏ nhất: ");
        int minPrice = -1;
        while (minPrice < 0){
            Scanner sc = new Scanner(System.in);
            try {
                minPrice = sc.nextInt();
                if (minPrice < 0) {
                    System.err.println("Số tiền không hợp lệ. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e){
                System.err.println("Dữ liệu nhập vào không hợp lệ. Vui lòng nhập lại");
            }
        }

        System.out.println("Nhập giá tiền lớn nhất: ");
        int maxPrice = -1;
        while (maxPrice < 0 || maxPrice < minPrice){
            Scanner sc = new Scanner(System.in);
            try {
                maxPrice = sc.nextInt();
                if (maxPrice < 0) {
                    System.err.println("Số tiền không hợp lệ. Vui lòng nhập lại.");
                }
                if (maxPrice < minPrice) {
                    System.err.println("Vui lòng nhập giá tiền lớn hơn hoặc bằng giá tiền nhỏ nhất");
                }
            } catch (InputMismatchException e){
                System.err.println("Dữ liệu nhập vào không hợp lệ. Vui lòng nhập lại");
            }
        }

        RoomManage.findRoomByPrice(minPrice, maxPrice);
    }
}
