package com.aubrun.eric.projet7.spring_batch.items;

import com.aubrun.eric.projet7.spring_batch.model.BatchDto;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestBatchDtoReader implements ItemReader<BatchDto> {

    private final String apiUrl;
    private final RestTemplate restTemplate;

    private int nextBorrowingIndex;
    private List<BatchDto> batchDtoList;

    public RestBatchDtoReader(@Value("${rest.api.url}") String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        nextBorrowingIndex = 0;
    }

    @Override
    public BatchDto read() throws Exception {

        if (batchDtoListIsNotInitialized()) {
            batchDtoList = fetchBatchDtoListFromAPI();
        }

        BatchDto nextBorrowing = null;

        if (nextBorrowingIndex < batchDtoList.size()) {
            nextBorrowing = batchDtoList.get(nextBorrowingIndex);
            nextBorrowingIndex++;
        }
        else {
            nextBorrowingIndex = 0;
            batchDtoList = null;
        }
        return nextBorrowing;
    }

    private boolean batchDtoListIsNotInitialized() {
        return this.batchDtoList == null;
    }

    private List<BatchDto> fetchBatchDtoListFromAPI() {

        ResponseEntity<BatchDto[]> response = restTemplate.getForEntity(apiUrl, BatchDto[].class);
        BatchDto[] batchDtoList = response.getBody();

        return Arrays.asList(batchDtoList);
    }
}