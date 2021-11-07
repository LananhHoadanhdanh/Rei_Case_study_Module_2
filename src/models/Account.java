package models;

import service.manage.UserManage;

public class Account {

    public static void register() {
        UserManage.getUserList();
        UserManage.add(UserManage.createUser());
    }

    public static boolean login(String username, String password) {
        int index = UserManage.findIndexByUsername(username);
        return UserManage.getUserList().get(index).getPassword().equals(password);
    }
}
