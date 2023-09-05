package com.transactionalBank.demo.repositories;

import com.transactionalBank.demo.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
