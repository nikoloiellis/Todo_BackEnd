package com.cog.rest.webservices.restfulwebservices.controller;

import com.cog.rest.webservices.restfulwebservices.models.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(method= RequestMethod.GET, path = "/hello")
    //Enables cross-origins of a certain url
    @CrossOrigin(origins = "http://localhost:4200")
    public String helloWorld(){
        //throw new RuntimeException("Something Went Wrong");
        return "Hello World";
    }


    //turns a model into a REST API or JSON Format
    @RequestMapping(method= RequestMethod.GET, path = "/hello-bean")
    //Enables cross-origins of a certain url
    @CrossOrigin(origins = "http://localhost:4200")
    public HelloWorldBean helloWorldBean() {

        return new HelloWorldBean("Hello World");
    }


    //turns a model into a REST API or JSON Format
    @RequestMapping(method= RequestMethod.GET, path = "/hello/path-variable/{name}")
    //Enables cross-origins of a certain url
    @CrossOrigin(origins = "http://localhost:4200")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
