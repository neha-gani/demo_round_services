package com.interview.service1.controller;

import com.interview.service1.dto.Person;
import com.interview.service1.dto.ResponseDTO;
import com.interview.service1.services.SagaExecutionCoordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private SagaExecutionCoordinator sagaExecutionCoordinator;

    @GetMapping("/get-state")
    String getServiceStatus(){
        return "Up";
    }

    @PostMapping("/post-state")
    ResponseDTO<String> getBothServices(@RequestBody Person person){
        return sagaExecutionCoordinator.orchestrateServicesTransaction(person);
    }
}
