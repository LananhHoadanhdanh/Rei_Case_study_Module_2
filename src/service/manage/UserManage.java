package service.manage;

import models.User;
import models.Validation;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManage {
    private static ArrayList<User> usersList;

    private UserManage() {
        }

    public static ArrayList<User> getUserList() {
        if (usersList == null) {
            usersList = new ArrayList<>();
            usersList.add(new User("Phạm Thị Lan Anh", 25, "0969001936", "chituhoa@gmail.com", "chituhoa", "danhdanh"));
            usersList.add(new User("Igata Kasakura", 21, "0969001936", "chituhoa@gmail.com", "hoadanhdanh", "danhdanh"));
        } return usersList;
    }

    public static void add(User user) {
        usersList.add(user);
    }

    public static int findIndexByUsername(String username){
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUsername().equals(username)) {
                return i;
            }
        } return -1;
    }

    public static void updateUser(String username, User user) {
        usersList.set(findIndexByUsername(username), user);
    }

    public static void getUserInformation(String username) {
        if (findIndexByUsername(username) != -1) {
            System.out.println();
            System.out.println("____________________________*** THÔNG TIN TÀI KHOẢN ***____________________________");
            System.out.printf("%-20s %-10s %-20s %-25s %n", "Họ và tên", "Tuổi", "Số điện thoại", "Email");
            System.out.println();
            System.out.println(usersList.get(findIndexByUsername(username)));
            System.out.println("___________________________________________________________________________________");
            System.out.println();
        } else {
            System.err.println("Sai tên đăng nhập.");
        }
    }

    public static void deleteUser(String username) {
        if (findIndexByUsername(username) != -1) {
            usersList.remove(findIndexByUsername(username));
        } else {
            System.err.println("Sai tên đăng nhập.");
        }
    }

    public static User createUser(){
        Scanner scanner = new Scanner(System.in);
        getUserList();
        System.out.println("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();
        while (findIndexByUsername(username) != -1 || !Validation.validateDay(username, Validation.LOGIN_NAME_REGEX)) {
            System.err.println("Tên đăng nhập đã tồn tại hoặc không hợp lệ. Vui lòng nhập lại. (8-16 kí tự, không gồm kí tự đặc biệt)");
            username = scanner.nextLine();
        }

        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        while (!Validation.validateDay(password, Validation.PASSWORD_REGEX)) {
            System.err.println("Chưa hợp lệ. Mật khẩu gồm từ 8-16 kí tự, không gồm kí tự đặc biệt.");
            password = scanner.nextLine();
        }
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        while (age < 18) {
            System.err.println("Bạn phải từ 18 tuổi trở lên.");
            age = scanner.nextInt();
        }

        System.out.print("Nhập số điện thoại: ");
        scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        while (!Validation.validateDay(phoneNumber, Validation.PHONE_NUMBER_REGEX)) {
            System.err.println("Số điện thoại chưa hợp lệ, vui lòng nhập lại.");
            phoneNumber = scanner.nextLine();
        }

        System.out.print("Nhập địa chỉ email: ");
        String email = scanner.nextLine();
        while (!Validation.validateDay(email, Validation.EMAIL_REGEX)) {
            System.err.println("Địa chỉ email chưa hợp lệ, vui lòng nhập lại.");
            email = scanner.nextLine();
        }
        return new User(name, age, phoneNumber, email, username, password);
    }
}
