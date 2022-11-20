package controller;

import model.User;
import service.UserServiceImpl;
import view.UserView;
import view.AdminView;

public class UserController {

    public static UserController getInstance(){
        return new UserController();
    }
    public void handleLoginRole(String email){
        if (UserServiceImpl.getInstance().checkRole(email).equals("user")){
             new UserView(UserServiceImpl.getInstance().findByEmail(email));
        } else {
            new AdminView(UserServiceImpl.getInstance().findByEmail(email));
        }
    }

    public void changeUsername(String username){
        UserServiceImpl.getInstance().changeUserName(username);
    }

    public boolean changePassword(String password){
        return UserServiceImpl.getInstance().changePassword(password);
    }

    public void creatUser(User user){
        UserServiceImpl.getInstance().createUser(user);
    }

    public boolean checkEmailExisted(String email){
        return UserServiceImpl.getInstance().checkEmailExisted(email);
    }

    public void viewAll(){
        UserServiceImpl.getInstance().viewAll();
    }
}
