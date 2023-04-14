package com.freelkee.btcbalancechecker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "date")
    private Timestamp date;

    @Column(name = "wallet_address")
    private String address;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private double amount;

    @Column(name = "amount_in_currency")
    private double amountInCurrency;

    @Column(name = "note")
    private String note;

    @PrePersist
    public void setCreatedAt() {
        this.date = new Timestamp(System.currentTimeMillis());
    }

}
