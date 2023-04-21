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
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "amount")
    private double amount;

    @PrePersist
    public void setCreatedAt() {
        this.date = new Timestamp(System.currentTimeMillis());
    }

}

