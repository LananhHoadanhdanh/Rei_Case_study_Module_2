import models.Account;
import models.MyException;
import models.User;
import service.manage.ReceiptManage;
import service.manage.UserManage;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws MyException, ParseException, IOException {
//        User user = UserManage.getUserList().get(0);
//        user.doCheckInForCustomer(101);
//        user.doCheckOutForCustomer(101);
        ReceiptManage.getReceiptList();
        ReceiptManage.writeReceiptToFile();
    }
}
