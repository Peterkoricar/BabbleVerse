package com.babbleverse.request;

import org.springframework.stereotype.Service;

@Service
public interface RequestService {
     Request getRequestInfo();
     Request createNewRequest();
     void requestAccepted();
     void requestRejected();

}
