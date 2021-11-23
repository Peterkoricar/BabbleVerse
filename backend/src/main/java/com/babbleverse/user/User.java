package com.babbleverse.user;

import com.babbleverse.request.Request;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String password;
    @ManyToMany
    @Column(name = "friends")
    private List<User> friends;
    @ManyToOne
    @Column(name = "receivedRequests")
    private List<Request> receivedRequests;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(){

    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nickname) {
        this.name = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

