package com.bitstogigs.bitstogigsjava.service;

import com.bitstogigs.bitstogigsjava.config.SpringServiceConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

public class SampleServiceImpl {

    private ObjectMapper objectMapper = SpringServiceConfig.objectMapper();

    public HttpStatus objectMapperMethod() {
        try {
            Object obj = objectMapper.writeValueAsBytes("some-text");
        } catch (JsonProcessingException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
