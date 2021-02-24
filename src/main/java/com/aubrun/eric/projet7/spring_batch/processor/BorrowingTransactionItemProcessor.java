package com.aubrun.eric.projet7.spring_batch.processor;

import com.aubrun.eric.projet7.spring_batch.model.BorrowingTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BorrowingTransactionItemProcessor implements ItemProcessor<BorrowingTransaction, BorrowingTransaction> {

    private final LocalDate localDate = LocalDate.of(Integer.parseInt("yyyy"),Integer.parseInt("mm"),Integer.parseInt("dd"));

    @Override
    public BorrowingTransaction process(BorrowingTransaction borrowingTransaction) throws Exception {
        borrowingTransaction.setEndTransactionDate(localDate);
        return borrowingTransaction;
    }
}
