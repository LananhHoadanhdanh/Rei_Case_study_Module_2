package Menu;

import models.Account;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
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
                    LoginMenu.registerToSystem();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
