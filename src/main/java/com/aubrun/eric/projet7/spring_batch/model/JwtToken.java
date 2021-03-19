package com.aubrun.eric.projet7.spring_batch.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Map;

@Component
public class JwtToken {

    private static String URL = "http://localhost:8081/biblio-api/api/auth/signin";

    @Autowired
    private RestTemplate restTemplate;

    private String jwt;

    public String getJwt() {
        if (jwt == null){
            login();
        }
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = "Bearer " + jwt;
    }

    private void login() {

        @SuppressWarnings("unchecked")
        Map<String, Object> result = (Map<String, Object>) restTemplate.postForEntity(URL, new Dto(), Map.class).getBody();
        setJwt(result.get("accessToken").toString());
    }

    private static class Dto{

        public String username = "Jobs";
        public String password = "sJ53";
    }
}
