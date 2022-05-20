package com.interview.service1.services;

import com.interview.service1.dto.Person;
import com.interview.service1.dto.ResponseDTO;

public interface SagaExecutionCoordinator {

   ResponseDTO<String> orchestrateServicesTransaction(Person person);

}
