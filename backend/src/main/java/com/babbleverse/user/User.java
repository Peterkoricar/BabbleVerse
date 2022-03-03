package com.babbleverse.user;

import com.babbleverse.group.Group;
import com.babbleverse.request.Request;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String password;
    @ManyToMany
    @JoinColumn(name = "groups_id")
    private List<Group> groups;

    @OneToMany
    private List<User> owner;
    //https://stackoverflow.com/questions/1656113/hibernate-recursive-many-to-many-association-with-the-same-entity
    @ManyToMany
    @JoinColumn(name="friendId")
    private List<User> friends = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name="personId")
    private List<User> friendOf = new ArrayList<>();


    @JsonIgnore
    @Column(name = "sent_requests")
    @OneToMany(mappedBy = "sender")
    private List<Request> sentRequests = new ArrayList<>();

    @JsonIgnore
    @Column(name = "received_requests")
    @OneToMany(mappedBy = "receiver")
    private List<Request> receivedRequests = new ArrayList<>();


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

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
    public void addFriend(User user){
        this.friends.add(user);
    }

    public List<Request> getSentRequests() {
        return sentRequests;
    }

    public void setSentRequests(List<Request> sentRequests) {
        this.sentRequests = sentRequests;
    }

    public List<Request> getReceivedRequests() {
        return receivedRequests;
    }

    public void setReceivedRequests(List<Request> receivedRequests) {
        this.receivedRequests = receivedRequests;
    }

    public void addSentRequest(Request request){
        sentRequests.add(request);
    }

    public void addReceivedRequest(Request request){
        receivedRequests.add(request);
    }

    public List<User> getFriendOf() {
        return friendOf;
    }

    public void setFriendOf(List<User> friendOf) {
        this.friendOf = friendOf;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<User> getOwner() {
        return owner;
    }

    public void setOwner(List<User> owner) {
        this.owner = owner;
    }
}

