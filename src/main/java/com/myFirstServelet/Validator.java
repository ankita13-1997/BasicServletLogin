package com.myFirstServelet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean validateUserName(String Username){
        String regexString="[A-Z]{1}[a-z]{3,20}$";
        Pattern patternMatching = Pattern.compile(regexString);
        Matcher m = patternMatching.matcher(Username);
         return m.matches();


    }

    public boolean validatePassword(String password){
        String regexString="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#&$])(?=\\S+$).{4,10}$";
        Pattern patternMatching = Pattern.compile(regexString);
        Matcher m = patternMatching.matcher(password);
        return m.matches();


    }

}
