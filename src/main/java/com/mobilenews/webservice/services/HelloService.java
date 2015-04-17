package com.mobilenews.webservice.services;

import com.mobilenews.webservice.messages.HelloWorldMessage;

public interface HelloService {
    HelloWorldMessage sayHello(String name);
}
