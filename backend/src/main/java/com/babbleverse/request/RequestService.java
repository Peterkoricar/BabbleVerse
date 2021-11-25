package com.babbleverse.request;

import com.babbleverse.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RequestService {
     Optional<Request> getRequestInfo(Long id);
     Request createNewRequest(User sender, User receiver,RequestType requestType);
     void requestAccepted(Request request);
     void requestRejected(Request request);

}
