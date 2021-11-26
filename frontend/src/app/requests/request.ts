import { User } from "../user";


export interface UserRequest{
    sender : User;
    reciever : User;
    requestType : UserRequestType;
}
