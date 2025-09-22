package model;

public class Customer extends User{

    private String telephone;
    private String address;

    public Customer(String name, String email, String password, String role, String status, String telephone, String address) {
        super(name, email, password, role, status);
        this.telephone = telephone;
        this.address = address;
    }

    @Override
    public void showProfile() {

    }

    @Override
    public void roleDescription() {

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
