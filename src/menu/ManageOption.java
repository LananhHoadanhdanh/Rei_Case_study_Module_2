package menu;

import model.Account;
import service.manage.ReceiptManage;
import service.manage.RoomManage;
import service.manage.UserManage;

import java.io.IOException;
import java.text.ParseException;

public class ManageOption {

    public static void roomManageOption(String username) throws IOException, ParseException {
        int choice = -1;
        while (choice != 0) {
            ShowMenu.showRoomMenu();
            choice = Account.choiceExceptionHandling();
            switch (choice) {
                case 1:
                    RoomManage.displayListRoom();
                    break;
                case 2:
                    RoomOption.roomOptionCheckIn(username);
                    break;
                case 3:
                    RoomOption.roomOptionCheckOut(username);
                    break;
                case 4:
                    RoomOption.roomOptionClean(username);
                    break;
                case 5:
                    RoomOption.roomOptionAdd();
                    break;
                case 6:
                    RoomOption.roomOptionUpdate();
                    break;
                case 7:
                    RoomManage.displayReadyRoom();
                    break;
                case 8:
                    RoomOption.roomOptionInformationById();
                    break;
                case 9:
                    RoomOption.roomOptionDeleteById();
                    break;
                case 10:
                    RoomOption.roomOptionInformationByPrice();
                    break;
                default:
                    System.out.println("Không có tùy chọn, vui lòng nhập lại!");
            }
        }
    }

    public static void receiptManageOption() throws IOException, ParseException {
        int choice = -1;
        while (choice != 0) {
            ShowMenu.showReceiptMenu();
            choice = Account.choiceExceptionHandling();
            switch (choice) {
                case 1:
                    ReceiptManage.displayAllReceipt();
                    break;
                case 2:
                    ReceiptOption.receiptOptionUpdateById();
                    break;
                case 3:
                    ReceiptOption.receiptOptionDeleteById();
                    break;
                case 4:
                    ReceiptOption.receiptOptionFindByDay();
                    break;
                case 5:
                    ReceiptManage.writeReceiptToFile();
                    break;
            }
        }
    }
}
