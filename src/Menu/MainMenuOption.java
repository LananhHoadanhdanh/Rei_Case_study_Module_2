package Menu;

import models.Account;
import models.MyException;
import service.manage.UserManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MainMenuOption {
    public static void main(String[] args) throws IOException, ParseException {
        int choice = -1;
        while (choice != 0) {
            Scanner scanner = new Scanner(System.in);
            ShowMenu.showLoginMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    LoginMenu.loginToSystem();
                    break;
                case 2:
                    Account.register();
                    break;
                case 3:
                    System.out.print("Nhập tên đăng nhập: ");
                    scanner.nextLine();
                    String username = scanner.nextLine();
                    UserManage.getUserList();
                    int index = UserManage.findIndexByUsername(username);
                    while (index == -1) {
                        System.err.println("Sai tên đăng nhập. Vui lòng nhập lại!");
                        username = scanner.nextLine();
                        index = UserManage.findIndexByUsername(username);
                    }
                    System.out.print("Nhập mật khẩu: ");
                    String password = scanner.nextLine();
                    if (Account.login(username, password)) {
                        UserManage.deleteUser(username);
                        System.out.println("Nhập thông tin mới.");
                        UserManage.add(UserManage.createUser());
                        System.out.println("Đã cập nhật thông tin thành công.");
                    } else {
                        System.err.println("Mật khẩu sai!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên đăng nhập: ");
                    scanner.nextLine();
                    String usernameDelete = scanner.nextLine();
                    UserManage.getUserList();
                    int indexDelete = UserManage.findIndexByUsername(usernameDelete);
                    while (indexDelete == -1) {
                        System.err.println("Sai tên đăng nhập. Vui lòng nhập lại!");
                        usernameDelete = scanner.nextLine();
                        indexDelete = UserManage.findIndexByUsername(usernameDelete);
                    }
                    System.out.print("Nhập mật khẩu: ");
                    String passwordDelete = scanner.nextLine();
                    if (Account.login(usernameDelete, passwordDelete)) {
                        UserManage.getUserList().remove(UserManage.findIndexByUsername(usernameDelete));
                        System.out.println("Xóa tài khoản thành công!");
                    } else {
                        System.err.println("Mật khẩu sai!");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Không có tùy chọn. Vui lòng nhập lại!");
            }
        }
    }
}
