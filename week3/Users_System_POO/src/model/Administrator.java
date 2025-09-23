package model;

import static utils.InputCheck.showInfoMessage;

public class Administrator extends User{

    public Administrator (String name, String email, String password, String role, String status){
        super(name,email,password,role,status);
    }

    @Override
    public String showProfile() {
        return "-------- " + getName().toUpperCase() + " --------\n" +
                "Email: " + getEmail() + "\n\n" +
                "Role: " + getRole() + "\n" + "Status : " + getStatus()+"\n";
    }
}
