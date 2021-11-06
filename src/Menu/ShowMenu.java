package Menu;

public class ShowMenu {
    public static void showLoginMenu() {
        System.out.println("__________*** CHỌN ĐỂ ĐĂNG NHẬP NGAY ***__________");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng kí tài khoản");
        System.out.println("0. Thoát khỏi hệ thống");
    }

    public static void showManageMenu() {
        System.out.println("________*** CHỌN MENU QUẢN LÝ ***________");
        System.out.println("1. Quản lý tài khoản");
        System.out.println("2. QUản lý phòng");
        System.out.println("3. QUản lý hóa đơn");
        System.out.println("0. Thoát khỏi menu quản lý");
    }

    public static void showAccountMenu() {
        System.out.println("________*** QUẢN LÝ TÀI KHOẢN ***________");
        System.out.println("1. Xem thông tin tài khoản");
        System.out.println("2. Sửa thông tin cá nhân");
        System.out.println("3. Xóa tài khoản");
        System.out.println("0. Thoát khỏi menu quản lý tài khoản");
    }

    public static void showRoomMenu() {
        System.out.println("________*** QUẢN LÝ PHÒNG ***________");
        System.out.println("1. Hiển thị danh sách phòng");
        System.out.println("2. Làm thủ tục check-in");
        System.out.println("3. Làm thủ tục check-out và phát hành hóa đơn");
        System.out.println("4. Dọn dẹp phòng");
        System.out.println("5. Thêm phòng");
        System.out.println("6. Sửa thông tin phòng");
        System.out.println("7. Hiển thị danh sách phòng còn trống");
        System.out.println("8. Tìm kiếm thông tin theo số phòng");
        System.out.println("9. Tìm phòng theo khoảng giá");
        System.out.println("0. Thoát khỏi menu quản lý tài khoản");
    }

    public static void showReceiptMenu() {
        System.out.println("________*** QUẢN LÝ HÓA ĐƠN ***________");
        System.out.println("1. Tìm và tính tổng tiền hóa đơn theo khoảng thời gian");
        System.out.println("2. Sửa thông tin hóa đơn theo số hóa đơn.");
        System.out.println("3. Xóa hóa đơn");
        System.out.println("4. Xuất danh sách hóa đơn ra file");
        System.out.println("0. Thoát khỏi menu quản lý tài khoản");
    }
}
