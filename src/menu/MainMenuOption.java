package menu;

import model.Account;
import service.manage.ReceiptManage;
import service.manage.RoomManage;
import service.manage.UserManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MainMenuOption {
    public static void main(String[] args) throws IOException, ParseException {
        RoomManage.getRoomList();
        RoomManage.readRoomFromFile();
        RoomManage.writeRoomToFile();


        UserManage.getUserList();
        UserManage.readUserFromFile();
        UserManage.writeUserToFile();


        ReceiptManage.getReceiptList();
        ReceiptManage.readReceiptFromFile();
        ReceiptManage.writeReceiptToFile();


        int choice = -1;
        while (choice != 0) {
            Scanner scanner = new Scanner(System.in);
            ShowMenu.showLoginMenu();
            choice = Account.choiceExceptionHandling();
            switch (choice) {
                case 1:
                    LoginMenu.loginToSystem();
                    break;
                case 2:
                    Account.register();
                    System.out.println("Đăng kí thành công!");
                    break;
                case 3:
                    String username = LoginMenu.createUsername();
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
                    String usernameDelete = LoginMenu.createUsername();
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
