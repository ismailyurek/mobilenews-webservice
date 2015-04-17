package com.mobilenews.webservice.services.impl;

import com.mobilenews.webservice.messages.HelloWorldMessage;
import com.mobilenews.webservice.services.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public HelloWorldMessage sayHello(String name) {

        HelloWorldMessage message = new HelloWorldMessage();
        message.setMessage(String.format("Merhaba, %s!", name));

        return message;
    }
}
