package com.epam.preprod.hrabovska.util.validator;

import com.epam.preprod.hrabovska.model.bean.RegistrationFormBean;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.preprod.hrabovska.model.constant.RegistrationFormBeanConstants.*;

/**
 * Validate registration fields
 */
public class RegistrationFieldValidator {

    private final String PASSWORD_SAMPLE = "^[A-Za-z0-9]{4,20}$";
    private final String FIRSTNAME_SECONDNAME_SAMPLE = "^[A-Za-zА-Яа-я]{2,30}$";
    private final String EMAIL_SAMPLE = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    private RegistrationFormBean form;

    public RegistrationFieldValidator(RegistrationFormBean form) {
        this.form = form;
    }

    public Map<String, String> validate() {
        Map<String, String> errors = new HashMap<>();

        if (!isPasswordValid(form.getPassword())) {
            errors.put(PASSWORD, Message.NOT_VALID_PASSWORD);
        }

        if (!form.getPassword().equals(form.getConfirmPassword())) {
            errors.put(CONFIRM_PASSWORD, Message.PASSWORDS_NOT_MATCH);
        }

        if (!isEmailValid(form.getEmail())) {
            errors.put(EMAIL, Message.NOT_VALID_EMAIL);
        }

        if (!isNameFieldValid(form.getFirstName())) {
            errors.put(FIRST_NAME, Message.NOT_VALID_FIRSTNAME);
        }
        if (!isNameFieldValid(form.getSecondName())) {
            errors.put(SECOND_NAME, Message.NOT_VALID_SECONDNAME);
        }
        return errors;
    }

    private boolean isPasswordValid(String field) {
        return validateField(field, PASSWORD_SAMPLE);
    }

    private boolean isNameFieldValid(String field) {
        return validateField(field, FIRSTNAME_SECONDNAME_SAMPLE);
    }

    private boolean isEmailValid(String email) {
        return validateField(email, EMAIL_SAMPLE);
    }

    private static boolean validateField(String field, String regexp) {
        if (field == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(field);
        return matcher.matches();
    }
}
