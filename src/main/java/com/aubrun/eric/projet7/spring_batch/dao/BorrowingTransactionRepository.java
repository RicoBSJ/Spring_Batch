package com.aubrun.eric.projet7.spring_batch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingTransactionRepository extends JpaRepository<BorrowingTransaction, Integer> {
}
