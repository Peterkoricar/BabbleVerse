import { User } from "../user";
import { UserRequestType } from "./requestType";


export interface UserRequest{
    sender : User;
    reciever : User;
    requestType : UserRequestType;
}
