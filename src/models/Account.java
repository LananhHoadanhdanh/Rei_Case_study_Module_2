package models;

import java.util.TreeMap;

public class Account {
    private TreeMap<String, String> accountMap;

    public Account() {
        accountMap = new TreeMap<>();
        accountMap.put("reireirei", "chituhoa");
    }

    public Account(TreeMap<String, String> accountMap) {
        this.accountMap = accountMap;
    }

    public void setAccountMap(TreeMap<String, String> accountMap) {
        this.accountMap = accountMap;
    }

    public void register(String username, String password) {
        boolean check = accountMap.containsKey(username);
        if (!check) {
            accountMap.put(username, password);
            System.out.println("Đăng kí thành công!!!");
        } else {
            System.out.println("Tên đăng nhập đã tồn tại!!!");
        }
    }

    public boolean login(String username, String password) {
        boolean check = accountMap.containsKey(username);
        if (check) {
            if (accountMap.get(username).equals(password)) {
                System.out.println("Đăng nhập thành công!!!");
                return true;
            }
            System.out.println("Sai mật khẩu");
            return false;
        }
        System.out.println("Tài khoản không tồn tại");
        return false;
    }

}
