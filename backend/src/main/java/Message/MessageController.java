package Message;

import com.BabbleVerse.User.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MessageController {
    MessageService messageService;
    public MessageController(MessageService messageService){

        this.messageService=messageService;
    }

}
