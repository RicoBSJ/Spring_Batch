package com.aubrun.eric.projet7.spring_batch;

import com.aubrun.eric.projet7.spring_batch.dao.BorrowingTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class BorrowingTransactionItemProcessor implements ItemProcessor<BorrowingTransaction, BorrowingTransaction> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Override
    public BorrowingTransaction process(BorrowingTransaction borrowingTransaction) throws Exception {
        borrowingTransaction.setBeginTransactionDate(dateFormat.parse(borrowingTransaction.getStrBeginTransactionDate()));
        return null;
    }
}
