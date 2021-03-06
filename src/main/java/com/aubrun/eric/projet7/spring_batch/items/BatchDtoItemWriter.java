package com.aubrun.eric.projet7.spring_batch.items;

import com.aubrun.eric.projet7.spring_batch.model.BatchDto;
import com.aubrun.eric.projet7.spring_batch.model.JwtToken;
import io.micrometer.core.lang.NonNull;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BatchDtoItemWriter implements ItemWriter<BatchDto> {

    //autowire le restemplate dans la classe
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtToken jwtToken;

    @Override
    public void write(@NonNull List<? extends BatchDto> batchDtos) throws Exception {

        for (BatchDto batchDto : batchDtos) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", jwtToken.getJwt());
            HttpEntity<Object> entity = new HttpEntity<>(batchDto, headers);
            restTemplate.exchange("http://localhost:8081/biblio-api/sendMail", HttpMethod.POST, entity, Void.class);
        }
    }
}