package com.bitstogigs.bitstogigsjava.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Field;

@SpringBootTest
public class SampleServiceImplTest {

    @Autowired
    private SampleServiceImpl sampleService;

    @Mock
    private ObjectMapper objectMapperMock;

    @Test
    public void objectMapperMethodTest() throws NoSuchFieldException, IllegalAccessException, JsonProcessingException {

        Field field = sampleService.getClass().getDeclaredField("objectMapper");
        field.setAccessible(true);
        field.set(sampleService, objectMapperMock);

        when(objectMapperMock.writeValueAsBytes(any())).thenThrow(JsonProcessingException.class);
        HttpStatus httpStatus = sampleService.objectMapperMethod();
        assertThat(httpStatus).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
