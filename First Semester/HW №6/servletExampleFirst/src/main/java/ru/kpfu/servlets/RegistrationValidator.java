package ru.kpfu.servlets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidator {

    private String name;
    private String email;
    private String password;
    private String password2;
    private String isAgree;

    public RegistrationValidator(String name, String email, String password, String password2, String isAgree) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.password2 = password2;
        this.isAgree = isAgree;
    }

    public boolean isValidate(){
        if (email != null && password != null && password2 != null && isAgree != null ){
            Pattern pattern = Pattern.compile(".+@.+");
            Matcher matcher = pattern.matcher(email);
            if(matcher.matches() && password.equals(password2) && isAgree.equals("on")){
                System.out.println(email + " is passed!");
                return true;
            }
        }
        return false;
    }
}
