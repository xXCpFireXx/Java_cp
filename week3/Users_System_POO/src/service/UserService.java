package service;

import model.Customer;
import model.User;
import security.IAutenticable;
import utils.InputCheck;

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
            } else {
                InputCheck.showWarningMessage("User INACTIVE","Error");
                return;
            }
        }
    }

    @Override
    public void logout() {
        currentUser = null;
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
    public void updateUser(int type, String data) {
        User user = getCurrentUser();
        if (user instanceof Customer customer) {
            switch (type){
                case 0:
                    customer.setTelephone(data);
                    break;
                case 1:
                    customer.setAddress(data);
                    break;
            }
        }

    }

    @Override
    public void updateUser(String telephone, String address) {
        User user = getCurrentUser();
        if (user instanceof Customer customer) {
            customer.setTelephone(telephone);
            customer.setAddress(address);

        }
    }

    @Override
    public void blockUser(String name) {
        for (User user : users){
            if (user.getName().equals(name)){
                user.setStatus("Inactive");
            }
        }
    }

    @Override
    public void unblockUser(String name) {
        for (User user : users){
            if (user.getName().equals(name) && user.getStatus().equals("Inactive")){
                user.setStatus("Active");
            }
        }
    }

    public String listUserName(){
        StringBuilder listNames = new StringBuilder();
        for (User user : users){
            listNames.append(" - ").append(user.getName()).append(" [").append(user.getStatus()).append("]").append("\n");
        }
        return String.valueOf(listNames);
    }
}
