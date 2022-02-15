package com.babbleverse.message;


import com.babbleverse.user.User;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String message;
    private String sender;
    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable=false)
    private User user;
    @Column(name = "user_id")
    private long  userId;


    protected Message(long id, String message, String sender) {
        this.id = id;
        this.message = message;
        this.sender = sender;
    }

    public Message() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
