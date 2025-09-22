package model;

public class Administrator extends User{

    public Administrator (String name, String email, String password, String role, String status){
        super(name,email,password,role,status);
    }

    @Override
    public void showProfile() {

    }

    @Override
    public void roleDescription() {

    }
}
