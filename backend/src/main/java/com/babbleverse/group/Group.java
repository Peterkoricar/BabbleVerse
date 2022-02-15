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
    private List<User> members;
    private List<Message> messages;

    protected Group (long id, List<User> members, List<Message> messages){
        this.id = id;
        this.members = members;
        this.messages = messages;
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
}
