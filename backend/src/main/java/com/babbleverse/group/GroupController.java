package com.babbleverse.group;

import com.babbleverse.message.MessageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
        private GroupService groupService;

        public GroupController(GroupService groupService) {
                this.groupService = groupService;
        }

        @RequestMapping("/createGroup")
        public void createGroup(@RequestBody Group group){
                groupService.createGroup(group);
        }
        @RequestMapping("/removeGroup")
        public void removeGroup(@PathVariable long id){
                groupService.removeGroup(id);
        }
}
