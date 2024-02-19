// UserBean.java
package com.example;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserBean implements Serializable {

    @Inject
    private ApplicationBean applicationBean;

    private String username;
    private String password;

    // getters and setters
    // getters and setters for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // getters and setters for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String login() {
        // login logic
        // if login is successful, add user to ApplicationBean
        applicationBean.addUser(new User(username, password));
        return "index?faces-redirect=true";
    }
}