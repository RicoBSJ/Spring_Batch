package com.aubrun.eric.projet7.spring_batch.reader;

import com.aubrun.eric.projet7.spring_batch.model.BorrowingTransaction;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RestBorrowingTransactionReader implements ItemReader<BorrowingTransaction> {

    private final String apiUrl;
    private final RestTemplate restTemplate;

    private int nextBorrowingIndex;
    private List<BorrowingTransaction> borrowingTransactionList;

    public RestBorrowingTransactionReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        nextBorrowingIndex = 0;
    }

    @Override
    public BorrowingTransaction read() throws Exception {
        if (borrowingTransactionListIsNotInitialized()) {
            borrowingTransactionList = fetchBorrowingTransactionListFromAPI();
        }

        BorrowingTransaction nextBorrowing = null;

        if (nextBorrowingIndex < borrowingTransactionList.size()) {
            nextBorrowing = borrowingTransactionList.get(nextBorrowingIndex);
            nextBorrowingIndex++;
        } else {
            nextBorrowingIndex = 0;
            borrowingTransactionList = null;
        }
        return nextBorrowing;
    }

    private boolean borrowingTransactionListIsNotInitialized() {
        return this.borrowingTransactionList == null;
    }

    private List<BorrowingTransaction> fetchBorrowingTransactionListFromAPI() {
        ResponseEntity<BorrowingTransaction[]> response = restTemplate.getForEntity(apiUrl,
                BorrowingTransaction[].class
        );
        BorrowingTransaction[] borrowingTransactionList = response.getBody();
        return Arrays.asList(borrowingTransactionList);
    }
}