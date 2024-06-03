package com.isicod.net.springCas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class TestApi {
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> welcome() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to api");
        return response;
    }
    
    @GetMapping(value = "not-protected", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> notProtectedUrl() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to not protected api");
        return response;
    }


    @GetMapping(value = "protected")
    public Map<String, String> protectedUrl() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to protected api");
        return response;
    }
}
