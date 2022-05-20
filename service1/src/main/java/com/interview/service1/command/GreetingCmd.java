package com.interview.service1.command;


import com.interview.service1.services.HttpServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Service("greetingCmd")
public class GreetingCmd extends Command{

    private String id;

    private String greetMessage;

    @Autowired
    private HttpServices httpServices;

    @Value("${endpoint.service2}")
    private String service2URL;

    @Autowired
    @Qualifier("personCmd")
    private Command nextStep;

    public GreetingCmd(Command nextStep){
        this.nextStep =  nextStep;
    }

    public CommandResponse process(Object person){
        CommandResponse response = new CommandResponse();
        String greetingResponse = null;
        try {
            greetingResponse = httpServices.get(service2URL);
            if(greetingResponse == null)
                throw new IllegalArgumentException();
            response.setResponse(greetingResponse);
            response.setStatus("GREETING_COMPLETED");
        }catch (Exception e){
            log.error("Failed to get person response {}", e);
            response.setStatus("GREETING_FAILED");
    }

        return response;
    }

    public String revert(){
        //do revert operations
        return "COMPLETED";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreetingCmd that = (GreetingCmd) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Command nextStep() {
        return this.nextStep;
    }
}