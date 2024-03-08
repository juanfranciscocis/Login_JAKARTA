// ApplicationBean.java
package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Named
@ApplicationScoped
public class ApplicationBean {

    private List<User> loggedInUsers = new ArrayList<>();
    private List<HashMap<String, String>> messages = new ArrayList<>();

    private List<HashMap<String,String>> messagesPriv = new ArrayList<>();

    @Inject
    @Push(channel = "push")
    private PushContext push;

    @Inject
    @Push(channel = "priv")
    private PushContext pushPriv;

    @Inject
    private UserBean userBean;

    @Inject
    private Messages usermsg;


    private Map<String, UserBean> activeUsers = new HashMap<>();
    private Map<String, PushContext> userPushContexts = new HashMap<>();


    public void addUserPushContext(UserBean username, PushContext pushContext) {
        userPushContexts.put(username.getUsername(), pushContext);
    }

    public PushContext getPushContextForUser(String username) {
        return userPushContexts.get(username);
    }



    // getter
    public List<User> getLoggedInUsers() {
        return loggedInUsers;
    }

    public void addUser(User username) {
        loggedInUsers.add(username);
        activeUsers.put(username.getUsername(),userBean);
        System.out.println("User " + username.getUsername() + " logged in");

    }

    public void addMessage(String username, String message) {
        messages.add(new HashMap<String, String>() {{
            put("username", username);
            put("message", message);
        }});
        System.out.println("Message from " + username + " added");
        push.send("updateNotifications");
    }

    public void sendMessagesPriv(String username){
        System.out.println("send to"+username);
        UserBean usertosend = activeUsers.get(username);
        addUserPushContext(usertosend,pushPriv);
        getPushContextForUser(usertosend.getUsername()).send("showprivate");
        usermsg.setPrivateVisible(true);
        pushPriv.send("showprivate");
    }
    public void addMessagePriv(String username, String message){
        messagesPriv.add(new HashMap<String, String>() {{
            put("username", username);
            put("message", message);
        }});
        System.out.println("Message private from " + username + " added" + message);
        pushPriv.send("updateNotifications");

    }

    //getter
    public List<HashMap<String, String>> getMessages() {
        return messages;
    }

    public List<HashMap<String, String>> getMessagesPriv() {
        return messagesPriv;
    }

    public PushContext getPushPriv() {
        return pushPriv;
    }
}