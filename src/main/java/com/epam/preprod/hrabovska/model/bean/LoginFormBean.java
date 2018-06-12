package com.epam.preprod.hrabovska.model.bean;

/**
 * Login bean getting from request
 */
public class LoginFormBean {

    private String email;
    private String password;

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

    @Override
    public String toString() {
        return "LoginFormBean{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
