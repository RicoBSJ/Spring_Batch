package com.aubrun.eric.projet7.spring_batch.items;

import com.aubrun.eric.projet7.spring_batch.model.BatchDto;
import com.aubrun.eric.projet7.spring_batch.model.BorrowingDto;
import com.aubrun.eric.projet7.spring_batch.model.JwtToken;
import io.micrometer.core.lang.NonNull;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Component
public class BatchDtoItemWriter implements ItemWriter<BatchDto> {

    //autowire le restemplate dans la classe
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtToken jwtToken;

    @Override
    public void write(@NonNull List<? extends BatchDto> lists) throws Exception {

        /*final List<BatchDto> batchDtoList = lists*/
        //boucler sur la liste de batchDto

        //pour chaque élément appeler le endpoint qui envoie le mail
    }

    public ResponseEntity<Void> sendMail(BatchDto borrowing, JwtToken jwtToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", jwtToken.getJwt());
        HttpEntity<BatchDto> entity = new HttpEntity<>(borrowing, headers);
        return restTemplate.exchange("http://localhost:8081/biblio-api/borrowings/lateDate", HttpMethod.POST, entity, Void.class);
    }

    public ResponseEntity<BatchDto> findLateBorrowingDate(JwtToken jwtToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", jwtToken.getJwt());
        HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8081/biblio-api/borrowings/sendMail", HttpMethod.GET, entity, BatchDto.class);
    }
}