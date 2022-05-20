package com.interview.service1.command;

import com.interview.service1.dto.Person;
import com.interview.service1.services.HttpServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Slf4j
@Service("personCmd")
public class PersonCmd extends Command {

    public static final String PERSON_COMPLETED = "PERSON_COMPLETED";
    public static final String PERSON_FAILED = "PERSON_FAILED";
    @TargetAggregateIdentifier
    private String id;
    private Person person;

    @Autowired
    private HttpServices httpServices;

    @Value("${endpoint.service3}")
    private String service3URL;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonCmd personCmd = (PersonCmd) o;
        return Objects.equals(id, personCmd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Command nextStep() {
        return null;
    }

    @Override
    public  CommandResponse process(Object person) {
        CommandResponse response = new CommandResponse();
        String personResponse = null;
        try {
            personResponse = httpServices.post(service3URL, person);
            response.setResponse(personResponse);
            response.setStatus(PERSON_COMPLETED);
        }catch (Exception e){
            log.error("Failed to get person response {}", e);
            response.setStatus(PERSON_FAILED);
        }
        return response;
    }

    @Override
    public String revert() {
        //do revert operations
        return "COMPLETED";
    }
}