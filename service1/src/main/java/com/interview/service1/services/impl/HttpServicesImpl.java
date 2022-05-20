package com.interview.service1.services.impl;

import com.interview.service1.services.HttpServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HttpServicesImpl implements HttpServices {

    @Override
    public String get(String url) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response
                    = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode() == HttpStatus.OK)
                return response.getBody();
        }
        catch (Exception ex){
            log.error("Failed to get from Service url {}", url);
        }
        return null;
    }

    @Override
    public <T> String post(String url, T requestType) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response
                    = restTemplate.postForEntity(url, requestType, String.class);

            if (response.getStatusCode() == HttpStatus.OK)
                return response.getBody();
        }
        catch (Exception ex){
            log.error("Failed to get from Service url {}", url);
        }
        return null;
    }
}
