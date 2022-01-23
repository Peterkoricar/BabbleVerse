package com.babbleverse.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    private RequestServiceImpl requestService;
    @Autowired
    public RequestController(RequestServiceImpl requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/newRequest")
    private Request createRequest(@RequestBody Request request){
        return requestService.createNewRequest(request.getSender(),request.getReceiver(),request.getRequestType());
    }

    private void sendRequest(@RequestBody Request request){

    }

    @PostMapping("/acceptRequest")
    private void requestAccepted(@RequestBody Request request){
        requestService.requestAccepted(request);
    }
}
