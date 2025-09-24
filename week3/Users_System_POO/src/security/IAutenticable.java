package security;

public interface IAutenticable {

    void login (String email, String password);
    void logout ();
}
