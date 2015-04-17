package com.mobilenews.webservice.controllers;

import com.mobilenews.webservice.services.HelloService;
import com.wordnik.swagger.annotations.*;
import com.mobilenews.webservice.messages.HelloWorldMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/welcome")
@Api(value = "/welcome", description = "Welcome service.")
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    private final HelloService helloService;

    @Autowired
    public HelloWorldController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(value = "/say-hello", method = RequestMethod.GET)
    @ResponseBody
    //@Cacheable(value = "say-hello")
    @ApiOperation(value = "Get specific product info.")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Locale is not defined. EN-gb, TR-tr etc."), @ApiResponse(code = 404, message = "Product not found")})
    public HelloWorldMessage sayHello(
            @ApiParam(name = "name", required = true, value = "Name of the request user.")
            @RequestParam(value = "name", required = true) String name) throws Exception {

        LOG.info("Deneme");
        LOG.error("Deneme");
        return helloService.sayHello(name);
    }
}
