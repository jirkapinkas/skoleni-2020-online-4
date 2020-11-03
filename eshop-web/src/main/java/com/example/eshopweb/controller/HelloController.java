package com.example.eshopweb.controller;

import com.example.eshopweb.pojo.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/message")
    public Message message() {
        return new Message("Spring Boot Rulez! :-)", 123);
    }

}
