package com.babbleverse.group;

import com.babbleverse.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService{

    GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void createGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void removeGroup(long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void addUserToGroup(Group group, User user){
        group.addUser(user);
    }
}
