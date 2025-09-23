package model;

import static utils.InputCheck.showInfoMessage;

public class Customer extends User{

    private String telephone;
    private String address;

    public Customer(String name, String email, String password, String role, String status, String telephone, String address) {
        super(name, email, password, role, status);
        setTelephone(telephone);
        setAddress(address);
    }

    @Override
    public String showProfile() {
        return "-------- " + getName().toUpperCase() + " --------\n" +
                "Email: " + getEmail() + "\n" + "Telephone: " + getTelephone() + "\n" + "Address: " + getAddress() + "\n\n" +
                "Role: " + getRole() + "\n" + "Status : " + getStatus()+"\n";
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
