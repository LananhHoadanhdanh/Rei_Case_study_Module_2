package models;

import service.manage.UserManage;

import java.util.Scanner;

public class Account {

    public static void register() {
        UserManage.getUserList();
        UserManage.add(UserManage.createUser());
    }

    public static boolean login() {
        Scanner scanner = new Scanner(System.in);
        UserManage.getUserList();
        System.out.println("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();
        while (UserManage.findIndexByUsername(username) == -1) {
            System.err.println("Tên đăng nhập không đúng. Vui lòng nhập lại.");
            username = scanner.nextLine();
        }

        System.out.println("Nhập mật khẩu: ");
        int index = UserManage.findIndexByUsername(username);
        String password = scanner.nextLine();
        return UserManage.getUserList().get(index).getPassword().equals(password);
    }


}
