package com.babbleverse.group;

import com.babbleverse.message.Message;
import com.babbleverse.user.*;
import com.babbleverse.message.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    @Column(name = "groups")
    private List<User> members;

    @OneToMany
    private List<Message> messages;

    private String groupName;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User creator;

    protected Group (User creator, String groupName){
        this.creator = creator;
        this.groupName = groupName;
    }

    public Group(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void addUser(User user){
        members.add(user);
    }


}
