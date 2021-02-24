package com.aubrun.eric.projet7.spring_batch;

import com.aubrun.eric.projet7.spring_batch.dao.BorrowingTransaction;
import com.aubrun.eric.projet7.spring_batch.dao.BorrowingTransactionRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BorrowingTransactionItemWriter implements ItemWriter<BorrowingTransaction> {

    private final BorrowingTransactionRepository borrowingTransactionRepository;

    public BorrowingTransactionItemWriter(BorrowingTransactionRepository borrowingTransactionRepository) {
        this.borrowingTransactionRepository = borrowingTransactionRepository;
    }

    @Override
    public void write(List<? extends BorrowingTransaction> list) throws Exception {
        borrowingTransactionRepository.saveAll(list);
    }
}
