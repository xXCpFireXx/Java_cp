package service;

import security.IAutenticable;

public class UserService implements IUser, IAutenticable {

    @Override
    public boolean login(String email, String password) {
        return false;
    }


}
