package service.manage;

import models.DateCalculator;
import models.Receipt;
import service.interfaceService.ReceiptService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReceiptManage implements ReceiptService {
    private static ArrayList<Receipt> receiptList;

    private ReceiptManage() {
    }

    public static ArrayList<Receipt> getReceiptList() {
        if (receiptList == null) {
            receiptList = new ArrayList<>();
        }
        return receiptList;
    }

    public static void add(Receipt receipt) {
        receiptList.add(receipt);
    }

    public static void update(String id, Receipt receipt) {
        receiptList.set(findIndexById(id), receipt);
    }

    public static void delete(String id) {
        receiptList.remove(findIndexById(id));
    }

    public static int findIndexById(String id) {
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getReceiptID().equals(id)) {
                return i;
            }
        } return -1;
    }

    public static void displayReceiptList(String startDay, String endDay) throws ParseException {
        int sumTotal = 0;
        System.out.println();
        System.out.println("__________________*** DANH SÁCH HÓA ĐƠN TỪ NGÀY " + startDay + " ĐẾN NGÀY " + endDay + " ***_________________");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s %-15s %n", "Số hóa đơn", "Khách hàng", "Nhân viên", "Ngày check-in", "Ngày check-out", "Tổng tiền");
        for (int i = 0; i < receiptList.size(); i++) {
            Receipt receipt = receiptList.get(i);
            int startCompare = DateCalculator.dateCompare(receipt.getCheckOutTime(), startDay);
            int endCompare = DateCalculator.dateCompare(receipt.getCheckOutTime(), endDay);
            if (startCompare >= 0 && endCompare <=0) {
                sumTotal += receipt.getTotalPrice();
                System.out.println(receipt);
            }
        }

        System.out.println("___________________________________________________________________________________________________");
        System.out.println("Tổng số tiền: " + sumTotal);
        System.out.println();
    }

    public static void writeReceiptToFile() throws IOException, ParseException {
        FileWriter fileWriter = new FileWriter("src/service/manage.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "Số hóa đơn,Tên khách hàng,Tên nhân viên,Giờ check-in,Giờ check-out,Tổng số tiền";
        for (int i = 0; i < receiptList.size(); i++) {
            Receipt receipt = receiptList.get(i);
            str += "\n";
            str += receipt.getReceiptID() + ",";
            str += receipt.getCustomerName() + ",";
            str += receipt.getStaffName() + ",";
            str += receipt.getCheckInTime() + ",";
            str += receipt.getCheckOutTime() + ",";
            str += receipt.getTotalPrice();
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
}
