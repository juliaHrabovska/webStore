package com.epam.preprod.hrabovska.model.bean;

/**
 * Registration bean getting from request
 */
public class RegistrationFormBean {

    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String confirmPassword;
    private boolean desiredList;
    private String captcha;
    private String imagePath;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean getDesiredList() {
        return desiredList;
    }

    public void setDesiredList(boolean desiredList) {
        this.desiredList = desiredList;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "RegistrationFormBean{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", desiredList=" + desiredList +
                ", captcha='" + captcha + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
