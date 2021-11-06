package Menu;

import models.Account;
import models.User;
import service.manage.UserManage;

import java.util.Scanner;

public class LoginMenu extends MainMenu{
    public static void loginToSystem() {
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
        User user = UserManage.getUserList().get(index);
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        if (Account.login(username, password)) {
            int choice = -1;
            while (choice != 0) {
                ShowMenu.showManageMenu();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        accountManage(username);
                        break;
                    case 2:
                        int number2 = -1;
                        while (number2 != -1) {
                            ShowMenu.showRoomMenu();
                            number2 = scanner.nextInt();
                        }
                        break;

                    case 3:
                    case 0:
                }
            }

        } else {
            System.err.println("Sai mật khẩu");

        }
    }

    public static void registerToSystem() {
        Account.register();
    }


    public static void accountManage(String username) {
        int choice = -1;
        while (choice != 0) {
            ShowMenu.showAccountMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    UserManage.getUserInformation(username);
                    break;
                case 2:
                    UserManage.updateUser(username, UserManage.createUser());
                    break;
                case 3:
                    UserManage.deleteUser(username);
                    break;
            }
        }
    }

}
