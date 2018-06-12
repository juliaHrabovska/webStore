package com.epam.preprod.hrabovska.model.entity;

/**
 * User entity
 */
public class User extends Entity {

    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private boolean desiredList;
    private String imagePath;
    private Integer roleId;

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

    public boolean getDesiredList() {
        return desiredList;
    }

    public void setDesiredList(boolean desiredList) {
        this.desiredList = desiredList;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", desiredList=" + desiredList +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
