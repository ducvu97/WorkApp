package view;

import controller.UserController;
import controller.WorkController;
import model.User;

import java.util.Scanner;

public class UserView {

    Scanner scanner = new Scanner(System.in);

    public UserView(User user) {
        WorkApplication.user = user;
        View();
    }
    public void View(){
        System.out.println("Xin chào " + WorkApplication.user.getUsername() + "\n" +
                "Mời bạn chọn các chức năng sau \n" +
                "1.Thông tin tài khoản \n" +
                "2.Các hạng mục công việc \n" +
                "3.Đăng xuất");
        int lc = Integer.parseInt(scanner.nextLine());
        do {
            if (lc == 1) {
                userInformation();
                break;
            }else if (lc == 2){
                findWorkByIdUser();
                break;
            }else if (lc == 3){
              return ;
            }
        } while (lc == 1 || lc == 2);
        View();
    }

    public void userInformation() {
        System.out.println("=====User Information====== \n" +
                WorkApplication.user + "\n" +
                "1.Đổi tên hiển thị \n" +
                "2.Đổi mật khẩu \n" +
                "3.Quay trở lại \n"+
                "Nhập lựa chọn của bạn:");
        int lc1 = Integer.parseInt(scanner.nextLine());
        do {
            if (lc1 == 1) {
                changeUsername();
                break;
            }else if(lc1 == 2){
               changePassword();
               break;
            }else if (lc1 == 3){
                return;
            }
        } while (lc1 == 1 || lc1 == 2);
        userInformation();
    }

    public void changeUsername() {
        System.out.println("0.Quay trở lại \n"
                + "Tên hiện tại của bạn:\n"
                + WorkApplication.user.getUsername() + "\n"
                + "Nhập tên bạn muốn thay đổi:");
        String b = WorkApplication.user.getUsername();
        String username = scanner.nextLine();
        UserController.getInstance().changeUsername(username);
        if (username.equals("0")) {
            UserController.getInstance().changeUsername(b);
            return;
        } else if (username.equals(b) && username.equals("")) {
            UserController.getInstance().changeUsername(b);
            System.out.println("Tên hiển thị không thay đổi");
        } else {
            System.out.println("Bạn đã đổi tên thành công");
        }
    }

    public void changePassword(){
        System.out.println("0.Quay trở lại \n"+
                           "Nhập mật khẩu mới của bạn:");
        String c = WorkApplication.user.getPassword();
        String password = scanner.nextLine();
        if (password.equals("0")){
            UserController.getInstance().changePassword(c);
            return;
        } else if (password.equals("")){
            UserController.getInstance().changePassword(c);
        }else if (!UserController.getInstance().changePassword(password)){
            System.out.println("Mật khẩu đã tồn tại");
        }else {
            System.out.println("Bạn đã đổi mật khẩu thành công");
        }
    }

    public void findWorkByIdUser (){
        WorkController.getInstance().findByIdUser(WorkApplication.user.getId());
        if (WorkController.getInstance().findByIdUser(WorkApplication.user.getId()) == null){
            System.out.println("Hiện tại bạn đang không có task");
        }
    }
}
