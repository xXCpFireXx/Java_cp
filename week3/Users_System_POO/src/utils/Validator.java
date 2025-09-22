package utils;

import java.util.regex.Pattern;

public class Validator {

    public static boolean validateEmail(String emailInput){

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compile the regex
        Pattern p = Pattern.compile(emailRegex);

        return emailInput != null && p.matcher(emailInput).matches();
    }
}
