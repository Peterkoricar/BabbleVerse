package com.babbleverse.request;

import com.babbleverse.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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
        return requestRepository.save(new Request(sender,receiver,requestType));
    }

    @Override
    public void requestAccepted(Request request) {

        switch (request.getRequestType()){
            case groupInvite:

            case friendRequest:
        }
    }

    @Override
    public void requestRejected(Request request) {

    }
}
