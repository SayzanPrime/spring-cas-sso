package com.isicod.net.springCas.controller;

import com.isicod.net.springCas.models.CasUser;
import com.isicod.net.springCas.service.CasUserDetailsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class TestApi {

    private final CasUserDetailsService casUserDetailsService;

    public TestApi(CasUserDetailsService casUserDetailsService) {
        this.casUserDetailsService = casUserDetailsService;
    }

    @GetMapping(value = "/not-protected", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> notProtectedUrl() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to not protected url");
        return response;
    }


    @GetMapping(value = "/protected", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> protectedUrl() {

        CasUser casUser = casUserDetailsService.getCurrentLoggedInUser();

        // Example of how to access attributes
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to protected url");
        response.put("mail", casUser.getMail());
        response.put("roles", casUser.getEduPersonAffiliation().toString());
        return response;
    }
}
