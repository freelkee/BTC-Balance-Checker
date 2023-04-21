package com.freelkee.btcbalancechecker.repository;

import com.freelkee.btcbalancechecker.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    Optional<Wallet> findByAddress(String address);
}
