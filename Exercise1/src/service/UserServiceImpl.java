package service;

import model.User;
import view.WorkApplication;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    public static ArrayList<User> userList = add();

    public static ArrayList<User> add() {
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User(1, "vungocduc597@gmail.com", "Vũ Ngọc Đức", "ducdzai97", "user"));
        userList.add(new User(2, "vungocduc598@gmail.com", "Vũ Đức", "ducdzai97", "admin"));
        userList.add(new User(3, "vungocduc599@gmail.com", "Vũ Đồng", "ducdzai97", "user"));
        return userList;
    }

    public static UserServiceImpl getInstance() {
        return new UserServiceImpl();
    }

    @Override
    public boolean checkAccount(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User findByEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public String checkRole(String email) {
        return findByEmail(email).getRole();
    }

    @Override
    public void changeUserName(String username) {
        int index;
        index = userList.indexOf(WorkApplication.user);
        WorkApplication.user.setUsername(username);
        userList.add(index, WorkApplication.user);
    }

    @Override
    public boolean changePassword(String newPassword) {
        int index;
        index = userList.indexOf(WorkApplication.user);
        if (WorkApplication.user.getPassword().equals(newPassword)) {
            return false;
        }
        WorkApplication.user.setPassword(newPassword);
        userList.set(index, WorkApplication.user);
        System.out.println(userList);
        return true;
    }

    public boolean checkEmailExisted(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public void createUser(User user){
        int id= userList.size();
        user.setId(id);
        user.setRole("user");
        userList.add(user);
    }

    public void viewAll(){
        System.out.println(userList);
    }

    public int findByUsername(String username){
        for (User user : userList){
            if (user.getUsername().equals(username)){
                return user.getId();
            }
        }
        return 0;
    }

}
