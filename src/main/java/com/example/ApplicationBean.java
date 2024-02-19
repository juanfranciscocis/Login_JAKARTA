// ApplicationBean.java
package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.List;
import java.util.ArrayList;

@Named
@ApplicationScoped
public class ApplicationBean {

    private List<User> loggedInUsers = new ArrayList<>();

    // getter
    public List<User> getLoggedInUsers() {
        return loggedInUsers;
    }

    public void addUser(User username) {
        loggedInUsers.add(username);
        System.out.println("User " + username.getUsername() + " logged in");
    }
}