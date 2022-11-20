package view;

import controller.UserController;
import model.User;
import service.UserServiceImpl;

import java.util.Scanner;

public class WorkApplication {

    public static User user;
    public WorkApplication () {
        boolean a = false ;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("===========LOGIN=========== \n" +
                    "Chào mừng đến với trang quản lý công việc \n" +
                    "Xin mời đăng nhâp");

            System.out.println("Xin mời nhập email của bạn");
            String email = scanner.nextLine();
            System.out.println("Xin mời nhập password của bạn");
            String password = scanner.nextLine();
            if (UserServiceImpl.getInstance().checkAccount(email, password)) {
                System.out.println("Đăng nhập thành công");
                UserController.getInstance().handleLoginRole(email);
            } else {
                System.out.println("Đăng nhập thất bại \n" +
                        "Xin mời đăng nhập lại");
                a = true;
            }
        } while (a);
        new WorkApplication();
    }

    public static void main(String[] args) {
        new WorkApplication();
    }
}
