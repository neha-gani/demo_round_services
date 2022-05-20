package com.interview.service3.controller;

import com.interview.service3.dto.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @PostMapping("/post-state")
    String getGreetingFromPost(@RequestBody Person person){
        return person.getName() + " " + person.getSurname();
    }
}
