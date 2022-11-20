package service;

public interface UserService {

    public boolean  checkAccount(String email, String password);

    public void changeUserName(String username);

    public boolean changePassword(String newPassword);
}
