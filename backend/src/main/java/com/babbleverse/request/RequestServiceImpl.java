package com.babbleverse.request;

import com.babbleverse.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class RequestServiceImpl implements RequestService{

    private RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    @Override
    public Optional<Request> getRequestInfo(Long id) {
        return requestRepository.findById(id);
    }

    @Override
    public Request createNewRequest(User sender, User receiver, RequestType requestType) {
        Request request = new Request(requestType);
        sender.addSentRequest(request);
        receiver.addReceivedRequest(request);
        return requestRepository.save(request);
    }

    @Override
    public void requestAccepted(Request request) {

        switch (request.getRequestType()){
            case groupInvite:

            case friendRequest:
                request.getSender().addFriend(request.getReceiver());
                System.console().printf(request.getSender().getFriends().toString());
        }
    }

    @Override
    public void requestRejected(Request request) {

    }
}
