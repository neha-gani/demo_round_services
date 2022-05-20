package com.interview.service1.services.impl;

import com.interview.service1.command.Command;
import com.interview.service1.command.CommandResponse;
import com.interview.service1.command.GreetingCmd;
import com.interview.service1.command.PersonCmd;
import com.interview.service1.dto.Person;
import com.interview.service1.dto.ResponseDTO;
import com.interview.service1.services.HttpServices;
import com.interview.service1.services.SagaExecutionCoordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SagaExecutionCoordinatorImpl implements SagaExecutionCoordinator {

    @Autowired
   private HttpServices httpServices;

    @Value("${endpoint.service2}")
    private String service2URL;

    @Value("${endpoint.service3}")
    private String service3URL;

    @Autowired
    @Qualifier("personCmd")
    Command step2;

    @Autowired
    @Qualifier("greetingCmd")
    Command step1;

    private String COMPLETED = "COMPLETED";
    private String FAILED = "FAILED";
    private String GREETING_COMPLETED = "GREETING_COMPLETED";
    private String GREETING_FAILED = "GREETING_FAILED";
    private String PERSON_COMPLETED = "PERSON_COMPLETED";
    private String PERSON_FAILED = "PERSON_FAILED";

    
    public ResponseDTO<String> orchestrateServicesTransaction(Person person) {
        String status = null;
        String personResponse = null;
        String greetingResponse = null;

        List<String> results = new ArrayList<>();


        CommandResponse step1Response = step1.process(person);
        status = step1Response.getStatus();

        CommandResponse step2Response = null;
        if(status.equals(GREETING_COMPLETED)) {
            results.add(step1Response.getResponse());
            if(step1.nextStep() != null) {
                step2Response = step1.nextStep().process(person);
                status = step2Response.getStatus();
                results.add(step2Response.getResponse());
            }
        }
        else if(status.equals(PERSON_FAILED)) {
            step1.revert();
            step1Response.setResponse("");
            step2Response.setResponse("");
        }
        return new ResponseDTO<>(String.join(" ", results));
    }
}
