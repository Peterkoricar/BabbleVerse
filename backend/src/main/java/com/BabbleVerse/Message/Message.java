package com.BabbleVerse.Message;


import com.BabbleVerse.User.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String message;
    private String sender;
    private Date sendTime;
    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable=false)
    private User user;


    protected Message(long id, String message, String sender, Date sendTime) {
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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
