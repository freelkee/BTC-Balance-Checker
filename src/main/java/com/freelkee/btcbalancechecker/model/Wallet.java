package com.freelkee.btcbalancechecker.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "wallet")
public class Wallet {
    private String address;
    private Timestamp date;
    private double amount;
    private String currency;
    private double amountInCurrency;
    public List<Tx> txs;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "txs")
    public static class Tx {
        private long id;
        private Timestamp date;
        private double amount;

    }
}
