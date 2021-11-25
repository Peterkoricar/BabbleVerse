package com.babbleverse.request;

import com.babbleverse.user.User;

import javax.persistence.*;

@Entity
public class Request {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable=false)
    private User sender;
    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable=false)
    private User receiver;

    @Column(name = "request_type")
    private RequestType requestType;

    @Column(name = "request_is_active")
    private boolean requestIsActive;

    public Request(User sender, User receiver, RequestType requestType) {
        this.sender = sender;
        this.receiver = receiver;
        this.requestType = requestType;
        requestIsActive = true;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public boolean isRequestIsActive() {
        return requestIsActive;
    }

    public void setRequestIsActive(boolean requestIsActive) {
        this.requestIsActive = requestIsActive;
    }
}
