package com.BabbleVerse.Message;


import com.BabbleVerse.User.User;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String message;
    private String sender;
    private String sendTime;
    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable=false)
    private User user;


    protected Message(long id, String message, String sender, String sendTime) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.sendTime = sendTime;
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

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
