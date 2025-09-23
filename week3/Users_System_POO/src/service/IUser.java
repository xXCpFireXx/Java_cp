package service;

import model.User;

public interface IUser {

    void registerUser(User user);
    void listAllUsers();
    void updateUser(String data);
    void updateUser(String telephone, String address);

}
