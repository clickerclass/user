package com.clickerclass.user.constans;

public interface ExpreReg {
    String REGEX_PASSWORD = "^(?:(?=.*?[A-Z])(?:(?=.*?[0-9])(?=.*?[-!@#$%^&*()_"
            + "[\\\\]{},.<>+=])|(?=.*?[a-z])(?:(?=.*?[0-9])|(?=.*?[-!@#$%^&*()_[\\\\]{},"
            + ".<>+=])))|(?=.*?[a-z])(?=.*?[0-9])(?=.*?[-!@#$%^&*()_[\\\\]{},.<>+=]))[A-Za-z0-9!"
            + "@#$%^&*()_[\\\\]{},.<>+=-]{7,50}$";
    String REGEX_SOLO_LETRAS = "^[a-zA-Z\\s]*$";
    String REGEX_DOCUMENTO = "^[[0-9]{8,16}]*$";
    String REGEX_SOLO_NUMEROS = "^[0-9]*$";
    String REGEX_LETRAS_NUMEROS = "^[0-9a-zA-Z]+$";
    String REGEX_NOMBRE_USUARIO = "^[0-9a-zA-Z]{6,20}$";
    String REGEX_TELEFONO = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
}
