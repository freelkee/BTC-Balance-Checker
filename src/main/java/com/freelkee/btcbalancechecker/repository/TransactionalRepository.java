package com.freelkee.btcbalancechecker.repository;

import com.freelkee.btcbalancechecker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TransactionalRepository extends JpaRepository<Transaction, Integer> {

    Optional<Transaction> findByAddress(String address);
}
