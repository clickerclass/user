package com.clickerclass.user.util;


public interface ExpreReg {
    String REGEX_PASSWORD = "^(?:(?=.*?[A-Z])(?:(?=.*?[0-9])(?=.*?[-!@#$%^&*()_"
            + "[\\\\]{},.<>+=])|(?=.*?[a-z])(?:(?=.*?[0-9])|(?=.*?[-!@#$%^&*()_[\\\\]{},"
            + ".<>+=])))|(?=.*?[a-z])(?=.*?[0-9])(?=.*?[-!@#$%^&*()_[\\\\]{},.<>+=]))[A-Za-z0-9!"
            + "@#$%^&*()_[\\\\]{},.<>+=-]{7,50}$";
    String REGEX_ONLY_LETTER = "^[a-zA-Z\\s]*$";
    String REGEX_DOCUMENT = "^[[0-9]{8,16}]*$";
    String REGEX_ONLY_NUMBER = "^[0-9]*$";
    String REGEX_LETTER_NUMBER = "^[0-9a-zA-Z]+$";
    String REGEX_USER_NAME = "^[0-9a-zA-Z]{6,20}$";
    String REGEX_PHONE = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
    String REGEX_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
}
