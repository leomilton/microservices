package com.epam.microcollector.dto;

public class NotificationMessage {

    private String user;
    private String message;

    public NotificationMessage() {}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

