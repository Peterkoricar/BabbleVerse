package com.babbleverse.group;

import com.babbleverse.user.User;
import org.springframework.stereotype.Service;

@Service
public interface GroupService {
    void createGroup(Group group);
    void removeGroup(long id);
    void addUserToGroup(Group group, User user);
}
