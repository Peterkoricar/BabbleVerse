package com.babbleverse.request;

import com.babbleverse.user.User;

public class Request {
    private Request_type requestType;
    private User reciever;

    public Request(Request_type requestType, User reciever) {
        this.requestType = requestType;
        this.reciever = reciever;
    }

    public Enum getRequestType() {
        return requestType;
    }

    public void setRequestType(Request_type requestType) {
        this.requestType = requestType;
    }

    public User getReciever() {
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
    }
}
