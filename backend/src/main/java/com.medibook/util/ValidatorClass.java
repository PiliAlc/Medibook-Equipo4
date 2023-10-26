package com.medibook.util;


public class ValidatorClass {

    public static boolean isNumeric(String strNum) {
            if (strNum == null) {
                return false;
            }
            try {
                long l = Long.parseLong(strNum);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
    }
}



