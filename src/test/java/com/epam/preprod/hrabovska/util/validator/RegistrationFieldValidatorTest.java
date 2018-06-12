package com.epam.preprod.hrabovska.util.validator;

import com.epam.preprod.hrabovska.model.bean.RegistrationFormBean;
import junit.framework.TestCase;
import org.junit.After;

import java.util.Map;

public class RegistrationFieldValidatorTest extends TestCase {

    private RegistrationFormBean formBean;

    private String firstName = "firstName";
    private String secondName = "secondName";
    private String email = "email@gmail.com";
    private String password = "z0SFrp2T";
    private String confirmPassword = "z0SFrp2T";

    private String wrongField = "A";

    @After
    public void clearFormBean() {
        formBean = null;
    }

    public void testValidateWithValidParameters() throws Exception {
        formBean = new RegistrationFormBean();
        formBean.setFirstName(firstName);
        formBean.setSecondName(secondName);
        formBean.setEmail(email);
        formBean.setPassword(password);
        formBean.setConfirmPassword(confirmPassword);
        Map<String,String> errors = new RegistrationFieldValidator(formBean).validate();
        assertEquals(0, errors.size());

    }

    public void testValidateWithNotValidParameters() throws Exception {
        formBean = new RegistrationFormBean();
        formBean.setFirstName(wrongField);
        formBean.setSecondName(wrongField);
        formBean.setEmail(wrongField);
        formBean.setPassword(wrongField);
        formBean.setConfirmPassword(wrongField);

        Map<String,String> errors = new RegistrationFieldValidator(formBean).validate();
        assertEquals(4, errors.size());
    }

}