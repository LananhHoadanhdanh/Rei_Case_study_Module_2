package model;

import service.manage.UserManage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {

    public static void register() {
        UserManage.getUserList();
        UserManage.add(UserManage.createUser());
    }

    public static boolean login(String username, String password) {
        int index = UserManage.findIndexByUsername(username);
        return UserManage.getUserList().get(index).getPassword().equals(password);
    }

    public static int choiceExceptionHandling() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.err.println("Nhập số nguyên!");
        } finally {
            scanner.nextLine();
        }
        return choice;
    }
}
