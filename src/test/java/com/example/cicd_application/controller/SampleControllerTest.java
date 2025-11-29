package com.example.cicd_application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testTestEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/sample/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("CI/CD Pipeline is working!"));
    }

    @Test
    public void testDockerTestEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/sample/docker-test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Docker is Working!"));
    }
}
