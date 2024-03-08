package com.example;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class Messages implements Serializable {


    @Inject
    private ApplicationBean applicationBean;

    private String username;
    private String message;

    private Boolean privateVisible = false;

    private String messagepriv;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessagepriv() {
        return messagepriv;
    }

    public void setMessagepriv(String messagepriv) {
        System.out.println(messagepriv);
        this.messagepriv = messagepriv;
    }

    public Boolean getPrivateVisible() {
        return privateVisible;
    }

    public void setPrivateVisible(Boolean privateVisible) {
        System.out.println("Is visible " + privateVisible);
        this.privateVisible = privateVisible;
    }

    public void updateTable() {
        applicationBean.addMessage(username, message);
    }

    public void updateTablePriv(){applicationBean.addMessagePriv(username,messagepriv);}



}
