package app;

import model.Administrator;
import model.Customer;
import model.User;
import service.UserService;
import utils.InputCheck;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        UserService service = new UserService();

        int breakDoWhile = 0;
        do {
            // Menu options
            String optionMenu = JOptionPane.showInputDialog(
                    null,
                    """
                            1. Login.
                            2. Register.
                            3. Exit""",
                    "Menu".toUpperCase(),
                    JOptionPane.QUESTION_MESSAGE);

            if (optionMenu == null) {
                break;
            }

            switch (optionMenu) {
                case "1":
                    loginMenu(service);
                    if (service.getCurrentUser().getRole().equals("Customer")){
                        int breakWhileUser = 0;
                        do {
                            String optionUser = JOptionPane.showInputDialog(null,
                                    """
                                    1. View my profile
                                    2. Update my contact information
                                    3. Log out
                                    """);

                            switch (optionUser){
                                case "1":
                                    InputCheck.showInfoMessage(service.getCurrentUser().showProfile(),
                                            service.getCurrentUser().getName().toUpperCase());
                                    break;
                                case "2":
                                    updateUserInfo(service);
                                    break;
                                case "3":
                                    breakWhileUser = 3;
                                    break;
                                default:
                                    InputCheck.showWarningMessage("Invalid option","Error");
                                    break;
                            }

                        } while (breakWhileUser !=3);
                    } else if (service.getCurrentUser() instanceof Administrator administrator){
                        int breakWhileAdmin = 0;
                        do {
                            String optionUser = JOptionPane.showInputDialog(null,
                                    """
                                    1. Register user
                                    2. List all users
                                    3. Block user
                                    4. Unblock user
                                    5. View my profile
                                    6. Log out
                                    """);

                            switch (optionUser){
                                case "1":
                                    registerMenu(service);
                                    break;
                                case "2":
                                    service.listAllUsers();
                                    break;
                                case "3":
                                    break;
                                case "4":
                                    break;
                                case "5":
                                    InputCheck.showInfoMessage(service.getCurrentUser().showProfile(),
                                            service.getCurrentUser().getName().toUpperCase());
                                    break;
                                case "6":
                                    breakWhileAdmin = 6;
                                    break;
                                default:
                                    InputCheck.showWarningMessage("Invalid option","Error");
                                    break;
                            }

                        } while (breakWhileAdmin !=6);
                    }
                    break;
                case "2":
                    registerMenu(service);
                    break;
                case "3":
                    breakDoWhile = 3;
                    break;
                default:
                    InputCheck.showWarningMessage("Invalid option","Error");
                    break;
            }

        } while (breakDoWhile != 3);
    }

    public static void registerMenu(UserService service){

        String[] typeOption = {"Customer", "Administrator"};
        int userType = JOptionPane.showOptionDialog(null,
                "What type of user do you want to create?", "Select a Type",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                typeOption,
                typeOption[0]);

        String nameUser = InputCheck.requestString(
                "Enter user name",
                "The name cannot be empty.");

        String telephone="", address="";
        if (userType == 0){
            telephone = InputCheck.requestString(
                    "Enter user telephone",
                    "The telephone cannot be empty.");

            address = InputCheck.requestString(
                    "Enter user address",
                    "The address cannot be empty.");
        }

        String email = InputCheck.requestString(
                "Enter user email",
                "The email cannot be empty.");


        String password = InputCheck.requestString(
                "Enter the user password",
                "The password cannot be empty.");

        String role;
        if (userType == 0){
            role = "Customer";
        } else {
            role = "Administrator";
        }

        User newUser = (userType == 0) ? new Customer(nameUser, email, password, role, "Active", telephone, address) : new Administrator(nameUser, email, password, role, "Active");
        service.registerUser(newUser);
    }

    public static void loginMenu(UserService service){
        String email = InputCheck.requestString(
                "Enter user email",
                "The email cannot be empty.");


        String password = InputCheck.requestString(
                "Enter the user password",
                "The password cannot be empty.");

        service.login(email,password);
    }

    public static void updateUserInfo(UserService service){
        String[] option = {"Telephone", "Address", "Both"};
        int userType = JOptionPane.showOptionDialog(null,
                "Which option do you want to update?", "Select a option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                option,
                option[0]);

//        String email = InputCheck.requestString(
//                "Enter user email",
//                "The email cannot be empty.");
//
//
//        String password = InputCheck.requestString(
//                "Enter the user password",
//                "The password cannot be empty.");
//
//        service.login(email,password);
    }
}
