package com.interview.service1.services;

import com.interview.service1.dto.Person;

public interface HttpServices {

    String get(String url);

    <T> String post(String url, T requestType);
}
