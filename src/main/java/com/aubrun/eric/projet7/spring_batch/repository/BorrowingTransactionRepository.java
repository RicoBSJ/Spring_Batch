package com.aubrun.eric.projet7.spring_batch.repository;

import com.aubrun.eric.projet7.spring_batch.model.BorrowingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Locale;

public interface BorrowingTransactionRepository extends JpaRepository<BorrowingTransaction, Integer> {

    List<BorrowingTransaction> findBorrowingTransactionByEndTransactionDateAndUserAccountBorrowing(Locale date);
}
