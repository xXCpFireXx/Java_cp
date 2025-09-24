package service;

import model.User;

public interface IUser {

    void registerUser(User user);
    void listAllUsers();
    void updateUser(int type, String data);
    void updateUser(String telephone, String address);
    void blockUser(String name);
    void unblockUser(String name);
}
