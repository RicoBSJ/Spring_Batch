package com.aubrun.eric.projet7.spring_batch.repository;

import com.aubrun.eric.projet7.spring_batch.model.BorrowingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingTransactionRepository extends JpaRepository<BorrowingTransaction, Integer> {
}
