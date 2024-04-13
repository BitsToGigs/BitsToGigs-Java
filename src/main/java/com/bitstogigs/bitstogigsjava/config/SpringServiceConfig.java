package com.bitstogigs.bitstogigsjava.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SpringServiceConfig {

    public static ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
