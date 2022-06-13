package com.gamescores.model.dto;

import com.gamescores.model.domain.User;

public class UserDTO {

    private Integer userID;

    private String userName;

    private String email;

    public UserDTO() {
    }

    //Parametrized constructor
    public UserDTO(User user) {
        this.userID = user.getUserID();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
