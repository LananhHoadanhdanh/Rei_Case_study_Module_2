package Menu;

import models.Account;
import service.manage.UserManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class LoginMenu{
    public static void loginToSystem() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên đăng nhập: ");
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
            System.out.println("Đăng nhập thành công!");
            int choice = -1;
            while (choice != 0) {
                ShowMenu.showManageMenu();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        UserManage.getUserInformation(username);
                        break;
                    case 2:
                        ManageOption.roomManageOption(username);
                        break;
                    case 3:
                        ManageOption.receiptManageOption();
                        break;
                    default:
                        System.err.println("Không có tùy chọn, vui lòng nhập lại.");
                }
            }
        } else {
            System.err.println("Mật khẩu sai!");
        }
    }
}
