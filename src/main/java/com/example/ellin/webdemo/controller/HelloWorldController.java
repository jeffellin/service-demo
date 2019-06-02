package com.example.ellin.webdemo.controller;


import com.example.ellin.webdemo.Hello;
import com.example.ellin.webdemo.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    HelloRepository helloRepository;

    @GetMapping("/hello")
    public String sayHello(){
        return helloRepository.findById("hello").orElse(new Hello()).getPhrase();
    }
}
