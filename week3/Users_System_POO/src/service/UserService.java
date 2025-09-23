package service;

import model.User;
import security.IAutenticable;
import java.util.ArrayList;

import static utils.InputCheck.*;

public class UserService implements IUser, IAutenticable {

    ArrayList<User> users = new ArrayList<>();
    User currentUser = null;

    @Override
    public void login(String email, String password) {
        for (User users : users){
            if (users.getEmail().equals(email) && users.getPassword().equals(password) && users.getStatus().equals("Active")){
                currentUser = users;
            }
        }
    }


    @Override
    public void registerUser(User newUser) {
        for (User users : users) {
            if (users.getName().equals(newUser.getEmail())){
                showWarningMessage("User already exist","Error");
                return;
            }
        }

        users.add(newUser);
        showSuccessMessage("User added successfully.");
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void listAllUsers() {
        StringBuilder list = new StringBuilder();
        list.append("------ Customers ------\n");
        for (User user : users) {
            if (user.getRole().equals("Customer")){
                list.append(user.showProfile());
            }
        }

        list.append("\n------ Administrators ------\n");
        for (User user : users) {
            if (user.getRole().equals("Administrator")){
                list.append(user.showProfile());
            }
        }

        showInfoMessage(String.valueOf(list),"List Users");
    }

    @Override
    public void updateUser(String data) {

    }

    @Override
    public void updateUser(String telephone, String address) {

    }
}
