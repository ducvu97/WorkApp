package view;

import controller.UserController;
import controller.WorkController;
import model.User;
import model.Work;

import java.util.Scanner;

public class AdminView {

    Scanner scanner = new Scanner(System.in);

    public AdminView(User user) {
        WorkApplication.user = user;
        ViewAd();
    }

    public void ViewAd() {
        System.out.println("Xin chào Admin " + WorkApplication.user.getUsername() + "\n" +
                "Xin mời lựa chọn các chức năng sau \n" +
                "1.Tạo tài khoản cho thành viên \n" +
                "2.Tạo task cho thành viên \n" +
                "3.Chỉnh sửa task của thành viên \n" +
                "4.Xem thông tin thành viên \n" +
                "5.Xem task \n" +
                "6.Đăng xuất");

        int lc = Integer.parseInt(scanner.nextLine());
        do {
            if (lc == 1) {
                createUser();
                break;
            } else if (lc == 2) {
                creatTask();
                break;
            } else if (lc == 3) {
                UpdateTask();
                break;
            } else if (lc == 4) {
                viewAll();
                break;
            } else if (lc == 5) {
                viewAllTask();
                break;
            } else if (lc == 6) {
                return;
            }
        } while (lc != 6);
        ViewAd();
    }

    public void createUser() {
        System.out.println("0.Quay trở lại");
        System.out.println("Bạn hãy nhập thông tin thành viên vào đây");
        String email = "";
        boolean a = false;
        do {
            System.out.println("Nhập email:");
            email = scanner.nextLine();
            if (email.equals("0") || email.equals("")) {
                return;
            } else if (!UserController.getInstance().checkEmailExisted(email)) {
                System.out.println("Email đã tồn tại");
                a = true;
            } else {
                break;
            }
        } while (a);
        System.out.println("Nhập tên người dùng:");
        String username = scanner.nextLine();
        if (username.equals("0") || username.equals("")) {
            return;
        }
        System.out.println("Nhập password:");
        String password = scanner.nextLine();
        if (password.equals("0") || password.equals("")) {
            return;
        }
        User user = new User(email, username, password);
        UserController.getInstance().creatUser(user);
        System.out.println("Tạo tài khoản thành công");
    }

    public void viewAll() {
        UserController.getInstance().viewAll();
    }

    public void viewAllTask() {
        WorkController.getInstance().viewAllTask();
    }

    public void creatTask() {
        System.out.println("0.Quay trở lại");
        System.out.println("====TASK====");
        System.out.println("Nhập tên task");
        String tittleTask = scanner.nextLine();
        if (tittleTask.equals("0")) {
            return;
        }
        System.out.println("Nhập tên người xử lý task");
        String username = scanner.nextLine();
        if (username.equals("0") || username.equals("")) {
            return;
        }
        System.out.println("Nhập trạng thái task");
        String status = scanner.nextLine();
        if (status.equals("0") || status.equals("")) {
            return;
        }
        Work work = new Work(tittleTask, status);
        WorkController.getInstance().createTask(work, username);
        System.out.println("Tạo task thành công");
    }

    public void UpdateTask() {
        System.out.println("Mời lựa chọn tính năng sau \n" +
                "1.Chỉnh sửa task \n" +
                "2.Xóa task \n" +
                "3.Quay lại");
        int lc1 = Integer.parseInt(scanner.nextLine());
        do {
            if (lc1 == 1) {
                editTask();
                break;
            } else if (lc1 == 2) {
                deleteTask();
                break;
            } else if (lc1 == 3) {
                return;
            }
        } while (lc1 == 2 || lc1 == 1);
        UpdateTask();
    }

    public void deleteTask() {
        System.out.println("0.Quay trở lại \n" +
                "Nhập tên người xử lý task:");
        String username = scanner.nextLine();
        if (username.equals("0") || username.equals("")) {
            return;
        } else {
            WorkController.getInstance().deleteTask(username);
            System.out.println("Xóa task thành công");
        }
    }

    public void editTask() {
        System.out.println("0.Quay trở lại");
        String titleTask = "";
        boolean c = false;
        do {
            System.out.println("Nhập vào tên task cần chỉnh sửa");
            titleTask = scanner.nextLine();
            if (titleTask.equals("0") || titleTask.equals("")) {
                return;
            } else if (WorkController.getInstance().findByTittleTask(titleTask, 1) == null) {
                System.out.println("Không tìm thấy task");
                c = true;
            } else {
                break;
            }
        } while (c);
        System.out.println("Nhập lại tên task");
        String newTitleTask = scanner.nextLine();
        if (newTitleTask.equals("0") || newTitleTask.equals("")) {
            return;
        }
        System.out.println("Nhập vào tên người xử lý task");
        String username = scanner.nextLine();
        if (username.equals("0") || username.equals("")) {
            return;
        }
        System.out.println("Nhập vào trạng thái task");
        String status = scanner.nextLine();
        if (status.equals("0") || status.equals("")) {
            return;
        }
        Work work = new Work(newTitleTask, status);
        WorkController.getInstance().editTask(work, titleTask, username, 2);
        System.out.println("Chỉnh sửa thành công");
    }
}
