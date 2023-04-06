package com.freelkee.btcbalancechecker.repository;

import com.freelkee.btcbalancechecker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    
}
