package menu;

import model.DateCalculator;
import model.Validation;
import service.manage.ReceiptManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReceiptOption {
    public static void receiptOptionUpdateById() throws ParseException, IOException {
        String receiptId = null;
        System.out.print("Nhập số hóa đơn muốn sửa: ");
        while (ReceiptManage.findIndexById(receiptId) == -1){
            Scanner sc = new Scanner(System.in);
            try {
                receiptId = sc.nextLine();
                if (ReceiptManage.findIndexById(receiptId) == -1) {
                    System.err.println("Phòng không tồn tại. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e){
                System.err.println("Số phòng không hợp lệ. Vui lòng nhập lại");
            }
        }
        ReceiptManage.delete(receiptId);
        ReceiptManage.add(ReceiptManage.createReceipt());
    }

    public static void receiptOptionDeleteById() throws IOException, ParseException {
        String receiptId = null;
        System.out.print("Nhập số hóa đơn muốn xóa: ");
        while (ReceiptManage.findIndexById(receiptId) == -1){
            Scanner sc = new Scanner(System.in);
            try {
                receiptId = sc.nextLine();
                if (ReceiptManage.findIndexById(receiptId) == -1) {
                    System.err.println("Phòng không tồn tại. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e){
                System.err.println("Số phòng không hợp lệ. Vui lòng nhập lại");
            }
        }
        ReceiptManage.delete(receiptId);
        System.out.println("Đã xóa thành công!");
    }

    public static void receiptOptionFindByDay() throws ParseException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày bắt đầu (định dạng dd/MM/yyyy): ");
        String startTime = scanner.nextLine();
        while (!Validation.validateString(startTime, Validation.DATE_REGEX)) {
            System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
            startTime = scanner.nextLine();
        }
        System.out.println("Nhập ngày kết thúc (định dạng dd/MM/yyyy): ");
        String endTime = scanner.nextLine();
        while (!Validation.validateString(endTime, Validation.DATE_REGEX) || DateCalculator.dateCompare(startTime, endTime) > 0) {
            if (!Validation.validateString(endTime, Validation.DATE_REGEX)) {
                System.err.println("Ngày không hợp lệ. Vui lòng nhập lại.");
            }
            if (DateCalculator.dateCompare(startTime, endTime) > 0) {
                System.err.println("Ngày kết thúc phải sau ngày bắt đầu!");
            }
            startTime = scanner.nextLine();
        }
        ReceiptManage.displayReceiptListByDay(startTime, endTime);
    }
}
